package com.justbook.DataList;

public class OfferDataListHorizontal {
    public int image_Food;
    public String discount_Percentage;
    public String discount_Details;
    public String location;


    public int getImage_Food() {
        return image_Food;
    }

    public void setImage_Food(int image_Food) {
        this.image_Food = image_Food;
    }

    public String getDiscount_Percentage() {
        return discount_Percentage;
    }

    public void setDiscount_Percentage(String discount_Percentage) {
        this.discount_Percentage = discount_Percentage;
    }

    public String getDiscount_Details() {
        return discount_Details;
    }

    public void setDiscount_Details(String discount_Details) {
        this.discount_Details = discount_Details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public OfferDataListHorizontal(int image_Food, String discount_Percentage, String discount_Details, String location){

        this.image_Food=image_Food;
        this.discount_Percentage=discount_Percentage;
        this.discount_Details=discount_Details;
        this.location=location;

    }
}
