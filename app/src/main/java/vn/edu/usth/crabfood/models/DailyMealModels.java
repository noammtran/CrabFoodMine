package vn.edu.usth.crabfood.models;

public class DailyMealModels {
    public DailyMealModels(int image, String name, String discount, String description) {
        this.image = image;
        this.name = name;
        this.discount = discount;
        this.description = description;
    }

    public DailyMealModels(int image, String name, String discount, String type, String description) {
        this.image = image;
        this.name = name;
        this.discount = discount;
        this.type = type;
        this.description = description;
    }

    int image;
    String name;
    String discount;
    String type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    String description;


}
