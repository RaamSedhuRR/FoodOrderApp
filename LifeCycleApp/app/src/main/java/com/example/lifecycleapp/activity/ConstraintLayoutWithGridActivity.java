package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.lifecycleapp.adapter.GridAdapter;
import com.example.lifecycleapp.databinding.ActivityConstraintLayooutWithGridBinding;
import com.example.lifecycleapp.utils.RequiredDataSet;

public class ConstraintLayoutWithGridActivity extends AppCompatActivity {
    ActivityConstraintLayooutWithGridBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConstraintLayooutWithGridBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        RequiredDataSet requiredDataSet = new RequiredDataSet();
        String[] employeeName = requiredDataSet.employeeName;
        GridAdapter gridAdapter = new GridAdapter(this, employeeName);
        binding.gridview.setNumColumns(3);
        binding.gridview.setAdapter(gridAdapter);

    }
}