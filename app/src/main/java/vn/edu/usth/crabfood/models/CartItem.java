package vn.edu.usth.crabfood.models;

public class CartItem {
    private final String name;
    private final double price;
    private final String imageResourceId;
    private int quantity;
    private final float rating; // New field

    public CartItem(String name, double price, String imageResourceId, float rating) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.quantity = 1; // Default quantity is 1
        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImageResourceId() {
        return imageResourceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getRating() {
        return rating;
    }
}
