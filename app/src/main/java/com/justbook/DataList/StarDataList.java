package com.justbook.DataList;

public class StarDataList {
    public String like;
    public String singerName;
    public int singerImage;

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSingerImage() {
        return singerImage;
    }

    public void setSingerImage(int singerImage) {
        this.singerImage = singerImage;
    }

    public StarDataList(String like, String singerName, int singerImage){
        this.like=like;
        this.singerName=singerName;
        this.singerImage=singerImage;




    }


}
