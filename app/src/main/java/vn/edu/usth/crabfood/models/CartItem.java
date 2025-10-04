package vn.edu.usth.crabfood.models;

public class CartItem {
    private String name;
    private double price;
    private int imageResourceId; // New field for image resource ID

    public CartItem(String name, double price, int imageResourceId) {
        this.name = name;
        this.price = price;
        this.imageResourceId = imageResourceId; // Initialize new field
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter for imageResourceId
    public int getImageResourceId() {
        return imageResourceId;
    }

    // Setter for imageResourceId
    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
