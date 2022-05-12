package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.adapter.ListViewAdapter;
import com.example.lifecycleapp.databinding.ActivityRelativeLayoutWithListBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.utils.RequiredDataSet;

import java.util.List;


public class RelativeLayoutWithListActivity extends AppCompatActivity {

    ActivityRelativeLayoutWithListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRelativeLayoutWithListBinding.inflate(getLayoutInflater());
        View bindingView = binding.getRoot();
        setContentView(bindingView);

        RequiredDataSet requiredDataSet = new RequiredDataSet();

        List<CMEmployee> employees = requiredDataSet.AddEmployees();

        ListViewAdapter adapter = new ListViewAdapter(this,
                                 R.layout.list_view_relative, employees);
        binding.listViewItem.setAdapter(adapter);
        binding.listViewItem.setOnItemClickListener((adapterView, view, i, l) -> {
            String empName = adapter.getItem(i).getEmpName();
            Toast.makeText(this,empName+" is Selected!",
                           Toast.LENGTH_LONG).show();
        });
    }


}