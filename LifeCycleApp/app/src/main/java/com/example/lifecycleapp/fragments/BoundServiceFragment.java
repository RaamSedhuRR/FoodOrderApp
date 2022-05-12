package com.example.lifecycleapp.fragments;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecycleapp.databinding.FragmentBoundServiceBinding;
import com.example.lifecycleapp.services.BoundService;

public class BoundServiceFragment extends Fragment{

    FragmentBoundServiceBinding fragmentBoundServiceBinding;

    BoundService boundService = new BoundService();

    boolean isConnected = false;

    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(context,BoundService.class);
        context.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ){
        // Inflate the layout for this fragment
        fragmentBoundServiceBinding = FragmentBoundServiceBinding.inflate(getLayoutInflater());
        fragmentBoundServiceBinding.getTimeBtn.setOnClickListener(view ->
                fragmentBoundServiceBinding
                .timeTextView.setText(boundService.getSystemTime()));
        return fragmentBoundServiceBinding.getRoot();
    }

    private final ServiceConnection serviceConnection=new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder){
            BoundService.BoundServiceBinder boundServiceBinder=
                    (BoundService.BoundServiceBinder) iBinder;
            boundService=boundServiceBinder.getBoundService();
            isConnected=true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName){
            isConnected=false;
        }
    };


}