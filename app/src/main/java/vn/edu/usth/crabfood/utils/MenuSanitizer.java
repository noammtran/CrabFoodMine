package vn.edu.usth.crabfood.utils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import vn.edu.usth.crabfood.models.Bbq;
import vn.edu.usth.crabfood.models.BestFood;
import vn.edu.usth.crabfood.models.Bread;
import vn.edu.usth.crabfood.models.Burger;
import vn.edu.usth.crabfood.models.Chocolate;
import vn.edu.usth.crabfood.models.Dessert;
import vn.edu.usth.crabfood.models.Drink;
import vn.edu.usth.crabfood.models.FriedChicken;
import vn.edu.usth.crabfood.models.IceCream;
import vn.edu.usth.crabfood.models.Menu;
import vn.edu.usth.crabfood.models.OurFood;
import vn.edu.usth.crabfood.models.Pizza;
import vn.edu.usth.crabfood.models.Pork;
import vn.edu.usth.crabfood.models.Sandwich;
import vn.edu.usth.crabfood.models.Sausage;
import vn.edu.usth.crabfood.models.Steak;

public final class MenuSanitizer {

    private MenuSanitizer() {
    }

    public static SanitizationResult sanitize(Menu menu) {
        Menu safeMenu = menu != null ? menu : new Menu();
        Set<String> invalidUrls = new LinkedHashSet<>();

        safeMenu.setBbqs(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getBbqs(), Bbq::getImg, invalidUrls::add));
        safeMenu.setBestFood(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getBestFood(), BestFood::getImg, invalidUrls::add));
        safeMenu.setBreads(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getBreads(), Bread::getImg, invalidUrls::add));
        safeMenu.setBurgers(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getBurgers(), Burger::getImg, invalidUrls::add));
        safeMenu.setChocolates(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getChocolates(), Chocolate::getImg, invalidUrls::add));
        safeMenu.setDesserts(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getDesserts(), Dessert::getImg, invalidUrls::add));
        safeMenu.setDrinks(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getDrinks(), Drink::getImg, invalidUrls::add));
        safeMenu.setFriedChicken(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getFriedChicken(), FriedChicken::getImg, invalidUrls::add));
        safeMenu.setIcecream(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getIcecream(), IceCream::getImg, invalidUrls::add));
        safeMenu.setPizzas(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getPizzas(), Pizza::getImg, invalidUrls::add));
        safeMenu.setPorks(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getPorks(), Pork::getImg, invalidUrls::add));
        safeMenu.setSandwiches(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getSandwiches(), Sandwich::getImg, invalidUrls::add));
        safeMenu.setSausages(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getSausages(), Sausage::getImg, invalidUrls::add));
        safeMenu.setSteaks(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getSteaks(), Steak::getImg, invalidUrls::add));
        safeMenu.setOurFoods(ImageValidationUtils.filterItemsWithReachableImages(safeMenu.getOurFoods(), OurFood::getImg, invalidUrls::add));

        return new SanitizationResult(safeMenu, new ArrayList<>(invalidUrls));
    }

    public static final class SanitizationResult {
        private final Menu menu;
        private final List<String> invalidImageUrls;

        private SanitizationResult(Menu menu, List<String> invalidImageUrls) {
            this.menu = menu;
            this.invalidImageUrls = invalidImageUrls;
        }

        public Menu getMenu() {
            return menu;
        }

        public List<String> getInvalidImageUrls() {
            return invalidImageUrls;
        }
    }
}
