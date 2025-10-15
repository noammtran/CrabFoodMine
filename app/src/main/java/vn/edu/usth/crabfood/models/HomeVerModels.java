package vn.edu.usth.crabfood.models;

public class HomeVerModels {
    String image;
    String name;
    String timing;
    String rating;
    String price;
    String desc;

    public HomeVerModels(String image, String name, String timing, String rating, String price, String desc) {
        this.image = image;
        this.name = name;
        this.timing = timing;
        this.rating = rating;
        this.price = price;
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

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
