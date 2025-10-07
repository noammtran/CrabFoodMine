package vn.edu.usth.crabfood.models;

import com.google.gson.annotations.SerializedName;

public class Pagination{
    public int bbqs;
    @SerializedName("best-foods")
    public int bestFoods;
    public int breads;
    public int burgers;
    public int chocolates;
    public int desserts;
    public int drinks;
    @SerializedName("fried-chicken")
    public int friedChicken;
    @SerializedName("ice-cream")
    public int icecream;
    public int pizzas;
    public int porks;
    public int sandwiches;
    public int sausages;
    public int steaks;
    @SerializedName("our-foods")
    public int ourFoods;

    public Pagination(int bbqs, int bestFoods, int breads, int burgers, int chocolates, int desserts, int drinks, int friedChicken, int icecream, int pizzas, int porks, int sandwiches, int sausages, int steaks, int ourFoods) {
        this.bbqs = bbqs;
        this.bestFoods = bestFoods;
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
    }

    public int getBbqs() {
        return bbqs;
    }

    public void setBbqs(int bbqs) {
        this.bbqs = bbqs;
    }

    public int getBestFoods() {
        return bestFoods;
    }

    public void setBestFoods(int bestFoods) {
        this.bestFoods = bestFoods;
    }

    public int getBreads() {
        return breads;
    }

    public void setBreads(int breads) {
        this.breads = breads;
    }

    public int getBurgers() {
        return burgers;
    }

    public void setBurgers(int burgers) {
        this.burgers = burgers;
    }

    public int getChocolates() {
        return chocolates;
    }

    public void setChocolates(int chocolates) {
        this.chocolates = chocolates;
    }

    public int getDesserts() {
        return desserts;
    }

    public void setDesserts(int desserts) {
        this.desserts = desserts;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getFriedChicken() {
        return friedChicken;
    }

    public void setFriedChicken(int friedChicken) {
        this.friedChicken = friedChicken;
    }

    public int getIcecream() {
        return icecream;
    }

    public void setIcecream(int icecream) {
        this.icecream = icecream;
    }

    public int getPizzas() {
        return pizzas;
    }

    public void setPizzas(int pizzas) {
        this.pizzas = pizzas;
    }

    public int getPorks() {
        return porks;
    }

    public void setPorks(int porks) {
        this.porks = porks;
    }

    public int getSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(int sandwiches) {
        this.sandwiches = sandwiches;
    }

    public int getSausages() {
        return sausages;
    }

    public void setSausages(int sausages) {
        this.sausages = sausages;
    }

    public int getSteaks() {
        return steaks;
    }

    public void setSteaks(int steaks) {
        this.steaks = steaks;
    }

    public int getOurFoods() {
        return ourFoods;
    }

    public void setOurFoods(int ourFoods) {
        this.ourFoods = ourFoods;
    }
}
