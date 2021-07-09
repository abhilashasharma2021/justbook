package com.justbook.DataList;

public class FavouritePlaceDataList {
 public  int image;
 public String name;
 public String location;
 public String time;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public FavouritePlaceDataList(int image, String name, String location, String time){
     this.image=image;
     this.name=name;
     this.location=location;
     this.time=time;




 }

}
