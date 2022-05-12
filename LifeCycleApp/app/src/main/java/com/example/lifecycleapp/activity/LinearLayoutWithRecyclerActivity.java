package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.lifecycleapp.adapter.RecyclerMyListAdapter;
import com.example.lifecycleapp.databinding.ActivityLinearLayoutWithRecyclerBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.utils.RequiredDataSet;

import java.util.List;

public class LinearLayoutWithRecyclerActivity extends AppCompatActivity {
    ActivityLinearLayoutWithRecyclerBinding binding;

    RecyclerMyListAdapter horizontalAdapter;

    RecyclerMyListAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLinearLayoutWithRecyclerBinding.inflate(getLayoutInflater());
        View bindingView = binding.getRoot();
        setContentView(bindingView);
        RequiredDataSet requiredDataSet = new RequiredDataSet();
        List<CMEmployee> employeeDetails = requiredDataSet.AddEmployees();
        List<CMEmployee> employeeDetailsDuplicate = requiredDataSet.AddEmployees1()     ;


        binding.recyclerSampleList1.setLayoutManager(new
                LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false));
        horizontalAdapter = new RecyclerMyListAdapter(this,employeeDetails);
        binding.recyclerSampleList1.setAdapter(horizontalAdapter);


        binding.recyclerSampleList.setLayoutManager(new LinearLayoutManager(this));
        verticalAdapter = new RecyclerMyListAdapter(this, employeeDetailsDuplicate);
        binding.recyclerSampleList.setAdapter(verticalAdapter);



    }

}