package com.example.lifecycleapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lifecycleapp.activity.FragmentLifeCycleActivity;
import com.example.lifecycleapp.databinding.FragmentLifeCycleBinding;


public class LifeCycleFragment extends Fragment {

    FragmentLifeCycleBinding fragmentLifeCycleBinding;

    private static final String ActivityName =
            FragmentLifeCycleActivity.class.getSimpleName();
    private static final String Tag = ActivityName;

    public void printLog(String msg){
        Log.d(Tag,"Life Cycle Status : "+ msg);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fragmentLifeCycleBinding = FragmentLifeCycleBinding.inflate(inflater);
        return fragmentLifeCycleBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        printLog("onViewCreated Called");

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        printLog("onCreate Called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        printLog("onDestroy Called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        printLog("onDestroyView Called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        printLog("onDetach Called");
    }

    @Override
    public void onPause() {
        super.onPause();
        printLog("onPause Called");
    }

    @Override
    public void onResume() {
        super.onResume();
        printLog("onResume Called");
    }

    @Override
    public void onStart() {
        super.onStart();
        printLog("onStart Called");
    }

    @Override
    public void onStop() {
        super.onStop();
        printLog("onStop Called");
    }
}