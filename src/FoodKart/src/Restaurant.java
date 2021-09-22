package FoodKart.src;

import java.util.*;

public class Restaurant {
    private String name;
    private String dishName;
    private int price;
    private int initialQuantity;
    private List<String> pinList;
    private double avgRating;
    private List<Rating> ratings;

    public Restaurant(String name, String dishName, int price, int initialQuantity, List<String> pinList) {
        this.name = name;
        this.dishName = dishName;
        this.price = price;
        this.initialQuantity = initialQuantity;
        this.pinList = pinList;
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(int initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public List<String> getPinList() {
        return pinList;
    }

    public void setPinList(List<String> pinList) {
        this.pinList = pinList;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void rate(double val,String comment){
        avgRating = (avgRating*ratings.size()+val)/(ratings.size()+1);
        ratings.add(new Rating(val,comment));
    }

}
