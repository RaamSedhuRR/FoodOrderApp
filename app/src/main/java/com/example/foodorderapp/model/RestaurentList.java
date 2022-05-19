package com.example.foodorderapp.model;


import com.google.gson.annotations.SerializedName;

public class RestaurentList {

    public String imgUrl;

    @SerializedName("restaurentName")
    public String restaurentName;

    @SerializedName("restaurentAddress")
    public String restaurentAddress;

    public String getDishImageView () {
        return imgUrl;
    }

    public void setDishImageView (String dishImageView) {
        this.imgUrl =dishImageView;
    }

    public String getRestaurentName () {
        return restaurentName;
    }

    public void setRestaurentName (String restaurentName) {
        this.restaurentName=restaurentName;
    }

    public String getRestaurentAddress () {
        return restaurentAddress;
    }

    public void setRestaurentAddress (String restaurentAddress) {
        this.restaurentAddress=restaurentAddress;
    }

    public RestaurentList (String dishImageView,String restaurentName,String restaurentAddress) {
        this.imgUrl=dishImageView;
        this.restaurentName=restaurentName;
        this.restaurentAddress=restaurentAddress;
    }
}
