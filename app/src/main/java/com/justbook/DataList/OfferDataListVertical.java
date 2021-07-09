package com.justbook.DataList;

public class OfferDataListVertical {

    public int image_circle;
    public int image_food;
    public  String foodName;
    public  String discountDetails;
    public  String discountPercentage;

    public int getImage_circle() {
        return image_circle;
    }

    public void setImage_circle(int image_circle) {
        this.image_circle = image_circle;
    }

    public int getImage_food() {
        return image_food;
    }

    public void setImage_food(int image_food) {
        this.image_food = image_food;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getDiscountDetails() {
        return discountDetails;
    }

    public void setDiscountDetails(String discountDetails) {
        this.discountDetails = discountDetails;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public OfferDataListVertical(int image_circle, int image_food, String foodName, String discountDetails, String discountPercentage) {
        this.image_circle = image_circle;
        this.image_food = image_food;
        this.foodName = foodName;
        this.discountDetails = discountDetails;
        this.discountPercentage = discountPercentage;
    }
}
