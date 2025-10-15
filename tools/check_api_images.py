from __future__ import annotations

import argparse
import json
import sys
import urllib.error
import urllib.request
from collections import defaultdict
from typing import Dict, Iterable, Iterator, List, Tuple

DEFAULT_API_URL = "https://free-food-menus-api-two.vercel.app/all"


class ImageCheckResult:
    """Aggregated results for image link validation."""

    def __init__(self) -> None:
        self.total = 0
        self.failures: Dict[str, List[Tuple[str, str, str]]] = defaultdict(list)

    def add_success(self) -> None:
        self.total += 1

    def add_failure(self, category: str, item_id: str, image_url: str, reason: str) -> None:
        self.total += 1
        self.failures[category].append((item_id, image_url, reason))

    @property
    def failed_count(self) -> int:
        return sum(len(items) for items in self.failures.values())

    def to_text(self) -> str:
        lines = [
            f"Scanned {self.total} image URLs.",
            f"Found {self.failed_count} dead link(s).",
        ]
        if self.failures:
            lines.append("Broken links by category:")
            for category in sorted(self.failures):
                lines.append(f"  - {category}:")
                for item_id, url, reason in self.failures[category]:
                    lines.append(f"      * {item_id}: {url} ({reason})")
        return "\n".join(lines)


def fetch_menu_from_api(api_url: str, timeout: float) -> Dict[str, object]:
    request = urllib.request.Request(api_url, headers={"User-Agent": "Mozilla/5.0"})
    with urllib.request.urlopen(request, timeout=timeout) as response:
        data = response.read()
    return json.loads(data.decode("utf-8"))


def load_menu_from_file(path: str) -> Dict[str, object]:
    with open(path, "r", encoding="utf-8") as handle:
        return json.load(handle)


def iter_image_entries(menu: Dict[str, object]) -> Iterator[Tuple[str, str, str]]:
    for category, items in menu.items():
        if not isinstance(items, list):
            continue
        for entry in items:
            if not isinstance(entry, dict):
                continue
            image_url = entry.get("img")
            if not image_url:
                continue
            item_id = str(entry.get("id") or entry.get("name") or entry.get("slug") or "<unknown>")
            yield category, item_id, image_url


def check_image(url: str, timeout: float) -> Tuple[bool, str]:
    head_request = urllib.request.Request(url, method="HEAD", headers={"User-Agent": "Mozilla/5.0"})
    try:
        with urllib.request.urlopen(head_request, timeout=timeout) as response:
            status = getattr(response, "status", response.getcode())
            if status and 200 <= status < 400:
                return True, f"HTTP {status}"
            return False, f"HTTP {status}"
    except urllib.error.HTTPError as exc:
        # Một số CDN từ chối HEAD request -> fallback sang GET
        if exc.code in {403, 405, 501}:
            get_request = urllib.request.Request(url, headers={"User-Agent": "Mozilla/5.0"})
            try:
                with urllib.request.urlopen(get_request, timeout=timeout) as response:
                    status = getattr(response, "status", response.getcode())
                    if status and 200 <= status < 400:
                        return True, f"HTTP {status}"
                    return False, f"HTTP {status}"
            except urllib.error.URLError as err:
                return False, getattr(err, "reason", str(err))
            except urllib.error.HTTPError as err:
                return False, f"HTTP {err.code}"
        return False, f"HTTP {exc.code}"
    except urllib.error.URLError as err:
        return False, getattr(err, "reason", str(err))


def run_checker(menu: Dict[str, object], timeout: float) -> ImageCheckResult:
    result = ImageCheckResult()
    for category, item_id, image_url in iter_image_entries(menu):
        ok, reason = check_image(image_url, timeout=timeout)
        if ok:
            result.add_success()
        else:
            result.add_failure(category, item_id, image_url, reason)
    return result


def parse_args(argv: Iterable[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser(
        description="Check food menu API image links for dead URLs.",
        formatter_class=argparse.ArgumentDefaultsHelpFormatter,
    )
    parser.add_argument(
        "--api-url",
        dest="api_url",
        default=DEFAULT_API_URL,
        help="Remote API endpoint to fetch",
    )
    parser.add_argument(
        "--input",
        dest="input",
        help="Path to a local JSON file to inspect instead of calling the API",
    )
    parser.add_argument("--timeout", type=float, default=15.0, help="Timeout in seconds for HTTP requests")

    # ✅ Thêm mới: tham số --report để lưu kết quả ra file JSON
    parser.add_argument(
        "--report",
        dest="report",
        help="Path to save JSON report of broken images (optional)"
    )

    return parser.parse_args(list(argv))


def main(argv: Iterable[str]) -> int:
    args = parse_args(argv)
    try:
        if args.input:
            menu = load_menu_from_file(args.input)
        else:
            menu = fetch_menu_from_api(args.api_url, timeout=args.timeout)
    except (OSError, json.JSONDecodeError) as error:  # pragma: no cover - CLI feedback
        print(f"Failed to load menu data: {error}", file=sys.stderr)
        return 1

    result = run_checker(menu, timeout=args.timeout)
    print(result.to_text())

    # ✅ Nếu có yêu cầu xuất file JSON
    if args.report:
        broken_dict = {
            "total": result.total,
            "failed_count": result.failed_count,
            "failures": {
                category: [
                    {"id": item_id, "url": url, "reason": reason}
                    for item_id, url, reason in items
                ]
                for category, items in result.failures.items()
            },
        }
        with open(args.report, "w", encoding="utf-8") as f:
            json.dump(broken_dict, f, indent=4, ensure_ascii=False)
        print(f"\n💾 Report saved to {args.report}")

    return 0 if result.failed_count == 0 else 2


if __name__ == "__main__":  # pragma: no cover - CLI entrypoint
    raise SystemExit(main(sys.argv[1:]))
