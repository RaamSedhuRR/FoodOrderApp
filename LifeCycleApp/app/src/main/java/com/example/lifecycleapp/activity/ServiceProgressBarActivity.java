package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lifecycleapp.databinding.ActivityServiceProgressBarBinding;
import com.example.lifecycleapp.fragments.BoundServiceFragment;
import com.example.lifecycleapp.fragments.ForegroundServicesFragment;


public class ServiceProgressBarActivity extends AppCompatActivity {

    ActivityServiceProgressBarBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityServiceProgressBarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new ForegroundServicesFragment());

        binding.foregroundServiceBtn.setOnClickListener(view -> {
            replaceFragment(new ForegroundServicesFragment());
            binding.foregroundServiceBtn.setClickable(false);
            binding.boundServiceBtn.setClickable(true);
        });
        binding.boundServiceBtn.setOnClickListener(view ->{
            replaceFragment(new BoundServiceFragment()) ;
            binding.foregroundServiceBtn.setClickable(true);
            binding.boundServiceBtn.setClickable(false);

        } );

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace (binding.frameLayoutService.getId(),fragment);
        fragmentTransaction.commit();
    }


}