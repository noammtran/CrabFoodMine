package vn.edu.usth.crabfood.models;

public class FeaturedModel {
    String image;
    String name;
    String desc;

    public FeaturedModel(String image, String name, String desc) {
        this.image = image;
        this.name = name;
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }
}
