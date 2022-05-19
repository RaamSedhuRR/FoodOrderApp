package com.example.foodorderapp.retrofit;

import com.example.foodorderapp.model.RestaurentList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("d45f4e7b-9900-480c-8aea-f17c41215ac2")
    Call<List<RestaurentList>> getRestaurents();
}
