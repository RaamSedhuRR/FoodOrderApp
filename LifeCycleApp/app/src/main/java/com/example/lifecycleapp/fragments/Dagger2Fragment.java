package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecycleapp.dagger2.DaggerSharedPreferenceComponent;
import com.example.lifecycleapp.dagger2.SharedPreferenceComponent;
import com.example.lifecycleapp.dagger2.SharedPreferenceModule;
import com.example.lifecycleapp.databinding.FragmentDagger2Binding;

import javax.inject.Inject;

public class Dagger2Fragment extends Fragment {

    FragmentDagger2Binding fragmentDagger2Binding;

    Context context;

    @Inject
    SharedPreferences sharedPreferences;


    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentDagger2Binding = FragmentDagger2Binding.inflate(getLayoutInflater());

        SharedPreferenceComponent sharedPreferenceComponent = DaggerSharedPreferenceComponent
                .builder().sharedPreferenceModule(new SharedPreferenceModule(context)).build();

        sharedPreferenceComponent.inject(this);

        fragmentDagger2Binding.saveBtn.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("inputField", fragmentDagger2Binding.inputField.getText().toString().trim());
            editor.apply();
        });

        fragmentDagger2Binding.getBtn.setOnClickListener(view -> fragmentDagger2Binding.outputField.setText(sharedPreferences.getString("inputField", "")));
        return fragmentDagger2Binding.getRoot();
    }
}