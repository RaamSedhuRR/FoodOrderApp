package com.example.foodorderapp.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.foodorderapp.adapter.RestaurentListRecyclerAdapter;
import com.example.foodorderapp.databinding.FragmentRestaurentListBinding;
import com.example.foodorderapp.listeners.CartListener;
import com.example.foodorderapp.model.RestaurentList;
import com.example.foodorderapp.mvpArchitecture.RestaurentListContract;
import com.example.foodorderapp.mvpArchitecture.RestaurentListPresenter;
import com.example.foodorderapp.retrofit.ApiClient;
import com.example.foodorderapp.retrofit.ApiInterface;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantListFragment extends Fragment implements RestaurentListContract.View, CartListener {

    FragmentRestaurentListBinding fragmentRestaurentListBinding;


    List<RestaurentList> restaurantLists;

    RestaurentListRecyclerAdapter restaurentListRecyclerAdapter;

    Context context;

    ApiInterface apiInterface;

    RestaurentListPresenter presenter;

    SharedPreferences sharedPreferencesGet;

    private static final String TAG="Retrofit Success";


    int addToCartCounter ;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        restaurantLists= new ArrayList<>();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        fragmentRestaurentListBinding = FragmentRestaurentListBinding.inflate(getLayoutInflater());

        sharedPreferencesGet =context
                .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
        addToCartCounter = sharedPreferencesGet.getInt("addToCartCounter",0);
        fragmentRestaurentListBinding.foodCartCount.setText(String.valueOf(addToCartCounter));
        fragmentRestaurentListBinding.swipeRefreshFoodCart.setOnRefreshListener(() ->
                fragmentRestaurentListBinding.swipeRefreshFoodCart.setRefreshing(false));


        presenter = new RestaurentListPresenter(this);
        presenter.start();

        return fragmentRestaurentListBinding.getRoot();
    }

    @Override
    public void onResume () {
        super.onResume();
        sharedPreferencesGet =context
                .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
        addToCartCounter = sharedPreferencesGet.getInt("addToCartCounter",0);

    }

    @Override
    public void init () {
        apiInterface=ApiClient.getClient().create(ApiInterface.class);
        Call<List<RestaurentList>> Call = apiInterface.getRestaurents();
        Call.enqueue(new Callback<List<RestaurentList>>() {
            @Override
            public void onResponse (@NonNull retrofit2.Call<List<RestaurentList>> call,@NonNull Response<List<RestaurentList>> response) {
                if(response.isSuccessful()){
                    fragmentRestaurentListBinding.recyclerViewFoodCart
                            .setLayoutManager(new LinearLayoutManager(getContext()));
                    restaurantLists= response.body();
                    restaurentListRecyclerAdapter = new RestaurentListRecyclerAdapter(context,restaurantLists, RestaurantListFragment.this);
                    fragmentRestaurentListBinding.recyclerViewFoodCart.setAdapter(restaurentListRecyclerAdapter);

                    Log.e(TAG,"Success: " + response.body());
                    if (response.body() != null) {
                        Log.e(TAG,"Response Data : "+response);
                    }

                }

            }

            @Override
            public void onFailure (@NonNull retrofit2.Call<List<RestaurentList>> call,@NonNull Throwable t) {
                Log.e(TAG,"Failed :" + t.getLocalizedMessage());
            }
        });
    }

    @Override
    public int addToCart () {
        addToCartCounter = sharedPreferencesGet.getInt("addToCartCounter",0);
        addToCartCounter++;
        fragmentRestaurentListBinding.foodCartCount.setText(String.valueOf(addToCartCounter));
        addSharedPreference();
        return addToCartCounter;
    }

    @Override
    public int removeFromCart () {
        addToCartCounter = sharedPreferencesGet.getInt("addToCartCounter",0);
        addToCartCounter--;
        if(addToCartCounter < 0)
        {
            addToCartCounter = 0;
            return 0;
        }
        fragmentRestaurentListBinding.foodCartCount.setText(String.valueOf(addToCartCounter));
        addSharedPreference();
        return addToCartCounter;
    }

    private void addSharedPreference(){
        SharedPreferences sharedPreferencesPost =context
                .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferencesPost.edit();
        myEdit.putInt("addToCartCounter", addToCartCounter);
        myEdit.apply();
    }

}