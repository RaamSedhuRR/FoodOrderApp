package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.lifecycleapp.adapter.RecyclerDataBindAdapter;
import com.example.lifecycleapp.databinding.ActivityConstraintLayoutWithRecyclerViewDataBindingBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.utils.RequiredDataSet;

import java.util.List;

public class ConstraintLayoutWithRecyclerViewDataBindingActivity extends AppCompatActivity {

    ActivityConstraintLayoutWithRecyclerViewDataBindingBinding activityConstraintLayoutWithRecyclerViewDataBindingBinding ;

    RecyclerDataBindAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        activityConstraintLayoutWithRecyclerViewDataBindingBinding = ActivityConstraintLayoutWithRecyclerViewDataBindingBinding.inflate(getLayoutInflater());
        activityConstraintLayoutWithRecyclerViewDataBindingBinding =DataBindingUtil
                .getBinding(activityConstraintLayoutWithRecyclerViewDataBindingBinding.recyclerViewDataBind.getRootView());

        if (activityConstraintLayoutWithRecyclerViewDataBindingBinding == null)
            throw new AssertionError();
        setContentView(activityConstraintLayoutWithRecyclerViewDataBindingBinding.getRoot());

        RequiredDataSet requiredDataSet = new RequiredDataSet();

        List<CMEmployee> employeeDetails = requiredDataSet.AddEmployees();

        adapter = new RecyclerDataBindAdapter(this, employeeDetails);

        activityConstraintLayoutWithRecyclerViewDataBindingBinding.recyclerViewDataBind.setLayoutManager(new LinearLayoutManager(this));

        activityConstraintLayoutWithRecyclerViewDataBindingBinding.recyclerViewDataBind.setAdapter(adapter);
    }

}