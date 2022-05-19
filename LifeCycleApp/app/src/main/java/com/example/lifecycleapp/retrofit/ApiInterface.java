package com.example.lifecycleapp.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/posts")
    Call<List<UserApi>> getUsers();

    @GET("/posts/{id}")
    Call<UserApi> getPosts(@Path("id") int id);

    @GET("/posts")
    Call<List<UserApi>> getPostsUsingQuery(@Query("userId") String userId, @Query("id") String id);

    @POST("/posts")
    Call<UserApi> postPosts(@Body UserApi userApi);
}
