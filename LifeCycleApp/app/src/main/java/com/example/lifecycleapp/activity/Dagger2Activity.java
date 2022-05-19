package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lifecycleapp.databinding.ActivityDagger2Binding;
import com.example.lifecycleapp.fragments.Dagger2Fragment;

public class Dagger2Activity extends AppCompatActivity {

    ActivityDagger2Binding activityDagger2Binding;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDagger2Binding = ActivityDagger2Binding.inflate(getLayoutInflater());
        setContentView(activityDagger2Binding.getRoot());
        replaceFragment(new Dagger2Fragment());

    }

    private void replaceFragment (Dagger2Fragment dagger2Fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(activityDagger2Binding.daggerFrameLayout.getId(),dagger2Fragment);
        fragmentTransaction.commit();

    }
}