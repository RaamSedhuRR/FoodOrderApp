package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.adapter.GridAdapter;
import com.example.lifecycleapp.databinding.FragmentConstraintLayoutBinding;
import com.example.lifecycleapp.utils.RequiredDataSet;

public class ConstraintLayoutFragment extends Fragment{

    FragmentConstraintLayoutBinding binding;

    GridAdapter gridAdapter;

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ){
        binding=FragmentConstraintLayoutBinding.inflate(inflater);

        RequiredDataSet requiredDataSet = new RequiredDataSet();

        String[] employeeName = requiredDataSet.employeeName;

        Bundle bundle=getArguments();
        if (bundle != null) {
            Toast.makeText(getContext(),
                           String.valueOf(bundle.getBoolean("Value")),
                           Toast.LENGTH_LONG).show();
        }

        gridAdapter=new GridAdapter(context, employeeName);
        binding.gridviewConstraintFragment.setNumColumns(3);
        binding.gridviewConstraintFragment.setAdapter(gridAdapter);
        return binding.getRoot();

    }
}