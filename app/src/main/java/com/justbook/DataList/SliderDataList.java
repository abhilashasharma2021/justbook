package com.justbook.DataList;

public class SliderDataList {

    public int imageBack;
    public String date;
    public String location;
    public String like;

    public int getImageBack() {
        return imageBack;
    }

    public void setImageBack(int imageBack) {
        this.imageBack = imageBack;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public SliderDataList(int imageBack, String date, String location, String like) {
        this.imageBack = imageBack;
        this.date = date;
        this.location = location;
        this.like = like;
    }

}
