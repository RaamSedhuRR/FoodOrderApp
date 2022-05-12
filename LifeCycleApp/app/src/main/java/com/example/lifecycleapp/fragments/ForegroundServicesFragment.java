package com.example.lifecycleapp.fragments;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lifecycleapp.databinding.FragmentForegroundServicesBinding;
import com.example.lifecycleapp.services.MediaPlayerService;




public class ForegroundServicesFragment extends Fragment implements View.OnClickListener{

    FragmentForegroundServicesBinding fragmentForegroundServicesBinding;

    Context context;


    @SuppressLint("StaticFieldLeak")

     public static ProgressBar progressBarId;

     int  progressCounter;



    private final BroadcastReceiver  broadcastReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
             progressCounter = Integer.parseInt(intent.getStringExtra("progressCounter"));
            Toast.makeText(context,progressCounter,Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState){
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
                            ){
        fragmentForegroundServicesBinding = FragmentForegroundServicesBinding.inflate(inflater);
        // Inflate the layout for this fragment
        fragmentForegroundServicesBinding.startServiceBtn.setOnClickListener(this);
        fragmentForegroundServicesBinding.stopServiceBtn.setOnClickListener(this);
        progressBarId = fragmentForegroundServicesBinding.serviceProgressBar;
        progressBarId.setProgress(progressCounter);
        return fragmentForegroundServicesBinding.getRoot();
    }

    @Override
    public void onClick(View view){
        if(view == fragmentForegroundServicesBinding.startServiceBtn){
            fragmentForegroundServicesBinding.startServiceBtn.setClickable(false);
            Intent intent = new Intent(context,MediaPlayerService.class);
            context.startService(intent);

        } else if(view == fragmentForegroundServicesBinding.stopServiceBtn){
            fragmentForegroundServicesBinding.startServiceBtn.setClickable(true);
            context.stopService(new Intent(context,MediaPlayerService.class));
        }
    }

}