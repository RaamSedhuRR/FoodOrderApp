package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecycleapp.adapter.RecyclerRetrofitAapter;
import com.example.lifecycleapp.databinding.FragmentRetrofitBinding;
import com.example.lifecycleapp.retrofit.ApiClient;
import com.example.lifecycleapp.retrofit.ApiInterface;
import com.example.lifecycleapp.retrofit.UserApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitFragment extends Fragment {

    private static final String TAG="Retrofit Success";

    FragmentRetrofitBinding fragmentRetrofitBinding;

    ApiInterface apiInterface;

    private List<UserApi> userList;

    RecyclerRetrofitAapter adapter;

    Context context;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        userList = new ArrayList<>();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragmentRetrofitBinding=FragmentRetrofitBinding.inflate(getLayoutInflater());
        apiInterface=ApiClient.getClient().create(ApiInterface.class);

        fragmentRetrofitBinding.btnGetCall.setOnClickListener(view -> {
            Call<List<UserApi>> Call=apiInterface.getUsers();
            Call.enqueue(new Callback<List<UserApi>>() {
                @Override
                public void onResponse (@NonNull Call<List<UserApi>> call,@NonNull Response
                        <List<UserApi>> response) {
                    Log.e(TAG,"Success :" + response.body());
                    userList =response.body();
                    assert userList != null;
                    Log.e(TAG,String.valueOf(userList.size()));

                    fragmentRetrofitBinding.recyclerRetrofitList
                            .setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter=new RecyclerRetrofitAapter(context,userList);

                    fragmentRetrofitBinding.recyclerRetrofitList.setAdapter(adapter);
                }

                @Override
                public void onFailure (@NonNull Call<List<UserApi>> call,@NonNull Throwable t) {
                    Log.e(TAG,"Failed :" + t.getLocalizedMessage());
                }
            });
        });

        fragmentRetrofitBinding.btnGetRouteCall.setOnClickListener(view -> {
            Call<UserApi> routeCall=apiInterface.getPosts(3);
            routeCall.enqueue(new Callback<UserApi>() {
                @Override
                public void onResponse (@NonNull Call<UserApi> call,@NonNull Response<UserApi> response) {

                    Log.e(TAG,"Success: " + response.body());

                }

                @Override
                public void onFailure (@NonNull Call<UserApi> call,@NonNull Throwable t) {

                    Log.e(TAG,"Failed :" + t.getLocalizedMessage());

                }
            });
        });

        fragmentRetrofitBinding.btnGetQueryCall.setOnClickListener(view -> {
            Call<List<UserApi>> queryCall=apiInterface.getPostsUsingQuery("1","8");
            queryCall.enqueue(new Callback<List<UserApi>>() {
                @Override
                public void onResponse (@NonNull Call<List<UserApi>> call,@NonNull Response<List<UserApi>> response) {
                    Log.e(TAG,"Success: " + response.body());
                }

                @Override
                public void onFailure (@NonNull Call<List<UserApi>> call,@NonNull Throwable t) {
                    Log.e(TAG,"Failed :" + t.getLocalizedMessage());
                }
            });
        });

        fragmentRetrofitBinding.btnPostCall.setOnClickListener(view -> {
            UserApi userApi=new UserApi("200","Ashwin","Right-Arm Off-break All Rounder");
            Call<UserApi> postCall=apiInterface.postPosts(userApi);
            postCall.enqueue(new Callback<UserApi>() {
                @Override
                public void onResponse (@NonNull Call<UserApi> call,@NonNull Response<UserApi> response) {
                    Log.e(TAG,"Success: " + response.body());
                }

                @Override
                public void onFailure (@NonNull Call<UserApi> call,@NonNull Throwable t) {
                    Log.e(TAG,"Failed :" + t.getLocalizedMessage());
                }
            });
        });




        return fragmentRetrofitBinding.getRoot();
    }
}