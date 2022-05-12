package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.util.Log;


import com.example.lifecycleapp.R;
import com.example.lifecycleapp.databinding.ActivityFragmentLayoutBinding;
import com.example.lifecycleapp.fragments.ConstraintLayoutFragment;
import com.example.lifecycleapp.fragments.LinearLayoutFragment;
import com.example.lifecycleapp.fragments.RelativeLayoutFragment;
import com.example.lifecycleapp.interfaces.SendDataInterface;


public class FragmentLayoutActivity extends AppCompatActivity  implements SendDataInterface{

    ActivityFragmentLayoutBinding binding;

    String TAG = "DATA TAG :";


    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new LinearLayoutFragment());
        binding.bottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.linearFragment:
                    replaceFragment(new LinearLayoutFragment());
                    break;
                case R.id.relativeFragment:
                    replaceFragment(new RelativeLayoutFragment());
                    break;
                case R.id.constraintFragment:
                    replaceFragment(new ConstraintLayoutFragment());
                    break;
            }


            return true;
        });



    }
    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle=new Bundle();
        bundle.putString("Name","Raam Sedhu RR");
        bundle.putInt ( "Id",111 );
        bundle.putBoolean ( "Value",true );
        fragment.setArguments(bundle);
        fragmentTransaction.replace (binding.frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void sendData(String Data){

        Log.d(TAG,Data);

    }

}