package com.example.lifecycleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.lifecycleapp.databinding.ActivitySqliteDbactivityBinding;
import com.example.lifecycleapp.fragments.PeopleListFragment;
import com.example.lifecycleapp.fragments.RetrofitFragment;
import com.example.lifecycleapp.fragments.SaveDataSqlDbFragment;
import com.example.lifecycleapp.fragments.VolleyFragment;
import com.example.lifecycleapp.fragments.VolleyFragment;

public class SqliteDBActivity extends AppCompatActivity{

    ActivitySqliteDbactivityBinding activitySqliteDbactivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        activitySqliteDbactivityBinding = ActivitySqliteDbactivityBinding.inflate(getLayoutInflater());
        setContentView(activitySqliteDbactivityBinding.getRoot());

        replaceFragment(new SaveDataSqlDbFragment());

        activitySqliteDbactivityBinding.btnAddDB.setOnClickListener(view ->
                  replaceFragment(new SaveDataSqlDbFragment()));

        activitySqliteDbactivityBinding.btnShowDB.setOnClickListener(view ->
                  replaceFragment(new PeopleListFragment()));

        activitySqliteDbactivityBinding.btnVolley.setOnClickListener(view ->
                  replaceFragment(new VolleyFragment()));

        activitySqliteDbactivityBinding.btnRetrofit.setOnClickListener(view ->
                 replaceFragment((new RetrofitFragment())));

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace (activitySqliteDbactivityBinding.sqlLiteFrameLayout.getId()
                            ,fragment);
        fragmentTransaction.commit();
    }

}