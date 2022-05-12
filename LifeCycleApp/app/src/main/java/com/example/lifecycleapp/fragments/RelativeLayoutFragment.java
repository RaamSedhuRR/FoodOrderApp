package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.adapter.ListViewAdapter;
import com.example.lifecycleapp.databinding.FragmentRelativeLayoutBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.utils.RequiredDataSet;

import java.util.List;


public class RelativeLayoutFragment extends Fragment {

    FragmentRelativeLayoutBinding fragmentRelativeLayoutBinding;

    ListViewAdapter adapter;

    Context context;

    public String Data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ) {
        fragmentRelativeLayoutBinding = FragmentRelativeLayoutBinding.inflate(inflater);
        RequiredDataSet requiredDataSet = new RequiredDataSet();
        List<CMEmployee> employees = requiredDataSet.AddEmployees();

        getParentFragmentManager().setFragmentResultListener
                ("messageKey", this, (requestKey, result) -> {
                    Data = result.getString("Message");
                    Toast.makeText(getContext(),Data,Toast.LENGTH_LONG).show();
                });
        Bundle bundle=getArguments();
        if (bundle != null) {
            Toast.makeText ( getContext (),
                             String.valueOf ( bundle.getInt ( "Id" ) ),
                             Toast.LENGTH_LONG ).show ();
        }

        adapter = new ListViewAdapter(context, R.layout.list_view_relative, employees);
        fragmentRelativeLayoutBinding.listFragmentview.setAdapter(adapter);
        return fragmentRelativeLayoutBinding.getRoot();

    }

        // Inflate the layout for this fragment


}