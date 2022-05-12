package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lifecycleapp.databinding.ActivitySharedPreferencesBinding;

import com.example.lifecycleapp.fragments.SharedPreferencesFragment;

public class SharedPreferencesActivity extends AppCompatActivity{

    ActivitySharedPreferencesBinding activitySharedPreferencesBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        activitySharedPreferencesBinding = ActivitySharedPreferencesBinding.inflate(getLayoutInflater());
        setContentView(activitySharedPreferencesBinding.getRoot());
        replaceFragment(new SharedPreferencesFragment());

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(activitySharedPreferencesBinding.sharedPreferenceFragment.getId(),fragment);
        fragmentTransaction.commit();
    }

}