package vn.edu.usth.crabfood.models;
public class BestFood{
    public String id;
    public String img;
    public String name;
    public String dsc;
    public int price;
    public int rate;
    public String country;

    public BestFood(String id, String img, String name, String dsc, int price, int rate, String country) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.dsc = dsc;
        this.price = price;
        this.rate = rate;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
