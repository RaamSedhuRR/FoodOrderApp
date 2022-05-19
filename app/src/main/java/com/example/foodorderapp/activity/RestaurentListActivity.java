package com.example.foodorderapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.foodorderapp.databinding.ActivityRestaurentListsBinding;
import com.example.foodorderapp.fragments.RestaurantListFragment;


public class RestaurentListActivity extends AppCompatActivity {

    ActivityRestaurentListsBinding binding;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRestaurentListsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new RestaurantListFragment());

    }

    private void replaceFragment (RestaurantListFragment restaurentListFragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(binding.restaurentListFrameLayout.getId()
                ,restaurentListFragment);
        fragmentTransaction.commit();
    }
}