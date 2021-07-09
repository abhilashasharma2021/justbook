package com.justbook.DataList;

public class ReviewDataList {
    public int image;
    public String txt_name;
    public  String txt_time;
    public  String txt_day;
    public  String txt_like;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTxt_name() {
        return txt_name;
    }

    public void setTxt_name(String txt_name) {
        this.txt_name = txt_name;
    }

    public String getTxt_time() {
        return txt_time;
    }

    public void setTxt_time(String txt_time) {
        this.txt_time = txt_time;
    }

    public String getTxt_day() {
        return txt_day;
    }

    public void setTxt_day(String txt_day) {
        this.txt_day = txt_day;
    }

    public String getTxt_like() {
        return txt_like;
    }

    public void setTxt_like(String txt_like) {
        this.txt_like = txt_like;
    }

    public ReviewDataList(int image, String txt_name, String txt_time, String txt_day, String txt_like){
        this.image=image;
        this.txt_name=txt_name;
        this.txt_time=txt_time;
        this.txt_day=txt_day;
        this.txt_like=txt_like;

    }


}
