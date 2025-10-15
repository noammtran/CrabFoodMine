package vn.edu.usth.crabfood.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Menu {
    public ArrayList<Bbq> bbqs;

    @SerializedName("best-foods")
    public ArrayList<BestFood> bestFood;
    public ArrayList<Bread> breads;
    public ArrayList<Burger> burgers;
    public ArrayList<Chocolate> chocolates;
    public ArrayList<Dessert> desserts;
    public ArrayList<Drink> drinks;
    @SerializedName("fried-chicken")
    public ArrayList<FriedChicken> friedChicken;
    @SerializedName("ice-cream")
    public ArrayList<IceCream> icecream;
    public ArrayList<Pizza> pizzas;
    public ArrayList<Pork> porks;
    public ArrayList<Sandwich> sandwiches;
    public ArrayList<Sausage> sausages;
    public ArrayList<Steak> steaks;
    @SerializedName("our-foods")
    public ArrayList<OurFood> ourFoods;
    public Pagination pagination;

    public Menu(ArrayList<Bbq> bbqs, ArrayList<BestFood> bestFood, ArrayList<Bread> breads, ArrayList<Burger> burgers, ArrayList<Chocolate> chocolates, ArrayList<Dessert> desserts, ArrayList<Drink> drinks, ArrayList<FriedChicken> friedChicken, ArrayList<IceCream> icecream, ArrayList<Pizza> pizzas, ArrayList<Pork> porks, ArrayList<Sandwich> sandwiches, ArrayList<Sausage> sausages, ArrayList<Steak> steaks, ArrayList<OurFood> ourFoods, Pagination pagination) {
        this.bbqs = bbqs;
        this.bestFood = bestFood;
        this.breads = breads;
        this.burgers = burgers;
        this.chocolates = chocolates;
        this.desserts = desserts;
        this.drinks = drinks;
        this.friedChicken = friedChicken;
        this.icecream = icecream;
        this.pizzas = pizzas;
        this.porks = porks;
        this.sandwiches = sandwiches;
        this.sausages = sausages;
        this.steaks = steaks;
        this.ourFoods = ourFoods;
        this.pagination = pagination;
    }

    public Menu() {

    }

    public ArrayList<Bbq> getBbqs() {
        return bbqs;
    }

    public void setBbqs(ArrayList<Bbq> bbqs) {
        this.bbqs = bbqs;
    }

    public ArrayList<BestFood> getBestFood() {
        return bestFood;
    }

    public void setBestFood(ArrayList<BestFood> bestFood) {
        this.bestFood = bestFood;
    }

    public ArrayList<Bread> getBreads() {
        return breads;
    }

    public void setBreads(ArrayList<Bread> breads) {
        this.breads = breads;
    }

    public ArrayList<Burger> getBurgers() {
        return burgers;
    }

    public void setBurgers(ArrayList<Burger> burgers) {
        this.burgers = burgers;
    }

    public ArrayList<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(ArrayList<Chocolate> chocolates) {
        this.chocolates = chocolates;
    }

    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(ArrayList<Drink> drinks) {
        this.drinks = drinks;
    }

    public ArrayList<FriedChicken> getFriedChicken() {
        return friedChicken;
    }

    public void setFriedChicken(ArrayList<FriedChicken> friedChicken) {
        this.friedChicken = friedChicken;
    }

    public ArrayList<IceCream> getIcecream() {
        return icecream;
    }

    public void setIcecream(ArrayList<IceCream> icecream) {
        this.icecream = icecream;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public ArrayList<Pork> getPorks() {
        return porks;
    }

    public void setPorks(ArrayList<Pork> porks) {
        this.porks = porks;
    }

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(ArrayList<Sandwich> sandwiches) {
        this.sandwiches = sandwiches;
    }

    public ArrayList<Sausage> getSausages() {
        return sausages;
    }

    public void setSausages(ArrayList<Sausage> sausages) {
        this.sausages = sausages;
    }

    public ArrayList<Steak> getSteaks() {
        return steaks;
    }

    public void setSteaks(ArrayList<Steak> steaks) {
        this.steaks = steaks;
    }

    public ArrayList<OurFood> getOurFoods() {
        return ourFoods;
    }

    public void setOurFoods(ArrayList<OurFood> ourFoods) {
        this.ourFoods = ourFoods;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
