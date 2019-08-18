package com.example.android.projectnetintel;

public class MenuItems {


    private String foodName;
    private String foodDescription;
    private int foodImage;
    private double price;

    public MenuItems(){

    }
    public MenuItems(String foodName, String foodDescription, int foodImage, double price ) {
        this.foodName = foodName;
        this.foodDescription = foodDescription;
        this.foodImage = foodImage;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(int foodImage) {
        this.foodImage = foodImage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
