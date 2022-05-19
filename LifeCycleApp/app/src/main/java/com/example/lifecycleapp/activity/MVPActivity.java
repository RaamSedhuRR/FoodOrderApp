package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lifecycleapp.databinding.ActivityMvpactivityBinding;
import com.example.lifecycleapp.fragments.MVPFragment;

public class MVPActivity extends AppCompatActivity {

    ActivityMvpactivityBinding activityMvpactivityBinding;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMvpactivityBinding = ActivityMvpactivityBinding.inflate(getLayoutInflater());
        setContentView(activityMvpactivityBinding.getRoot());
        replaceFragment(new MVPFragment());
    }

    private void replaceFragment (MVPFragment mvpFragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(activityMvpactivityBinding.mvpFrameLayout.getId(),mvpFragment);
        fragmentTransaction.commit();

    }


}