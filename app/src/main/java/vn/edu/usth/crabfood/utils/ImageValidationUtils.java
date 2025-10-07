package vn.edu.usth.crabfood.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;

public final class ImageValidationUtils {

    private static final int CONNECTION_TIMEOUT_MILLIS = 5000;
    private static final int READ_TIMEOUT_MILLIS = 5000;

    private ImageValidationUtils() {
    }

    public static boolean isImageReachable(String urlString) {
        if (urlString == null || urlString.trim().isEmpty()) {
            return false;
        }

        HttpURLConnection connection = null;
        try {
            connection = openConnection(urlString, "HEAD");
            int responseCode = connection.getResponseCode();
            if (isSuccessful(responseCode)) {
                return true;
            }

            if (responseCode == HttpURLConnection.HTTP_BAD_METHOD) {
                disconnectQuietly(connection);
                connection = openConnection(urlString, "GET");
                responseCode = connection.getResponseCode();
                return isSuccessful(responseCode);
            }
        } catch (IOException ignored) {
            return false;
        } finally {
            disconnectQuietly(connection);
        }
        return false;
    }

    private static HttpURLConnection openConnection(String urlString, String method) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(CONNECTION_TIMEOUT_MILLIS);
        connection.setReadTimeout(READ_TIMEOUT_MILLIS);
        connection.setInstanceFollowRedirects(true);
        connection.setRequestMethod(method);
        connection.setUseCaches(false);
        connection.connect();
        return connection;
    }

    private static boolean isSuccessful(int responseCode) {
        return responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST;
    }

    private static void disconnectQuietly(HttpURLConnection connection) {
        if (connection != null) {
            connection.disconnect();
        }
    }

    public static <T> ArrayList<T> filterItemsWithReachableImages(ArrayList<T> items,
                                                                  Function<T, String> imageExtractor,
                                                                  Consumer<String> invalidUrlConsumer) {
        ArrayList<T> result = new ArrayList<>();
        if (items == null) {
            return result;
        }

        for (T item : items) {
            String imageUrl = imageExtractor.apply(item);
            if (isImageReachable(imageUrl)) {
                result.add(item);
            } else if (invalidUrlConsumer != null && imageUrl != null && !imageUrl.trim().isEmpty()) {
                invalidUrlConsumer.accept(imageUrl);
            }
        }
        return result;
    }
}
