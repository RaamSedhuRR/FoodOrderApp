package com.example.lifecycleapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.adapter.RecyclerMyListAdapter;
import com.example.lifecycleapp.databinding.FragmentLinearLayoutBinding;
import com.example.lifecycleapp.interfaces.SendDataInterface;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.utils.RequiredDataSet;


import java.util.List;

public class LinearLayoutFragment extends Fragment {

    RecyclerMyListAdapter adapter;

    FragmentLinearLayoutBinding fragmentLinearLayoutBinding;

    SendDataInterface sendDataInterface;


    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);

        Activity activity =( Activity ) context;

        try{

            sendDataInterface = (SendDataInterface ) activity;

        }catch(RuntimeException e){

            throw new RuntimeException(activity +"Try Something else");

        }


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ) {

        fragmentLinearLayoutBinding = FragmentLinearLayoutBinding.inflate(inflater);
        RequiredDataSet requiredDataSet = new RequiredDataSet();

        List<CMEmployee> employees = requiredDataSet.AddEmployees();

        String Data = "This String is passed from fragment to activity via interface";

        sendDataInterface.sendData(Data);

        Bundle bundle=getArguments();
        if (bundle != null) {
            bundle.putString("Message", "Data is passed Via Fragment Result Api");
        }
        assert bundle != null;
        getParentFragmentManager().setFragmentResult("messageKey", bundle);


        Toast.makeText ( getContext (),
                         bundle.getString ( "Name" ),
                         Toast.LENGTH_LONG ).show ();

        fragmentLinearLayoutBinding.recyclerFragmentList
                .setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RecyclerMyListAdapter(getContext(), employees);
        fragmentLinearLayoutBinding.recyclerFragmentList.setAdapter(adapter);
        return fragmentLinearLayoutBinding.getRoot();
    }


}