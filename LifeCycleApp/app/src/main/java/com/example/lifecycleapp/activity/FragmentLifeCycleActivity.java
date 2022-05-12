package com.example.lifecycleapp.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lifecycleapp.databinding.ActivityFragmentLifeCycleBinding;
import com.example.lifecycleapp.globalDatas.PassDataTest;


public class FragmentLifeCycleActivity extends AppCompatActivity {

    ActivityFragmentLifeCycleBinding activityFragmentLifeCycleBinding;
    public String Message,Name;
    public int id,RollNo;
    public boolean val,Attendance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();


        Message = intent.getStringExtra("Message");


        id = intent.getIntExtra("Id",0);


        val = intent.getBooleanExtra("Val",false);


        Name = PassDataTest.Message;


        RollNo = PassDataTest.Id;


        Attendance = PassDataTest.Val;


        activityFragmentLifeCycleBinding = ActivityFragmentLifeCycleBinding
                .inflate(getLayoutInflater());
        setContentView(activityFragmentLifeCycleBinding.getRoot());

        activityFragmentLifeCycleBinding.linearLayoutFragment.setOnClickListener(view ->
        Toast.makeText(getApplicationContext(), Message+" in "+id+"st Attempt and is " +
                "passed message is String?" +
                " "+val, Toast.LENGTH_LONG).show());

        activityFragmentLifeCycleBinding.relativeLayoutFragment.setOnClickListener ( view ->
        Toast.makeText(getApplicationContext(), "Name is "+Name+" Roll-No is  "
                 +RollNo+" Attendance "+ Attendance, Toast.LENGTH_LONG).show());

         Toast.makeText(getApplicationContext(),
                        Message+" in "+id+"st Attempt and is passed message is String? "
                 +val, Toast.LENGTH_LONG).show();
    }
//
}