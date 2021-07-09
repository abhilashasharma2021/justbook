package com.justbook.DataList;

public class EventDataList {
    public int imgBack;
    public  String time;
    public  String location;
    public  String like;

    public EventDataList(int imgBack, String time, String location, String like) {
        this.imgBack = imgBack;
        this.time = time;
        this.location = location;
        this.like = like;
    }

    public int getImgBack() {
        return imgBack;
    }

    public void setImgBack(int imgBack) {
        this.imgBack = imgBack;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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
}
