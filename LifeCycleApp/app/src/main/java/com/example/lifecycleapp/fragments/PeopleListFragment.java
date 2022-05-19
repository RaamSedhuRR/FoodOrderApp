package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.adapter.RecyclerUserListAdapter;
import com.example.lifecycleapp.database.DataBaseHelper;
import com.example.lifecycleapp.database.User;
import com.example.lifecycleapp.databinding.FragmentPeopleListBinding;

import java.util.ArrayList;
import java.util.List;


public class PeopleListFragment extends Fragment {

    RecyclerUserListAdapter adapter;

    FragmentPeopleListBinding fragmentPeopleListBinding;

    private List<User> userList;

    Context context;

    DataBaseHelper dataBaseHelper;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
        userList = new ArrayList<>();
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Cursor cursor=dataBaseHelper.getAllData();
        if(cursor.getCount() > 0){
            while (cursor.moveToNext())
            {
                User userData = new User(cursor.getString(0),cursor.getString(1),
                                         cursor.getString(2),cursor.getString(3));
                userList.add(userData);
            }

        }else{
            Toast.makeText(context, "Better Luck Next Time!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ){
        // Inflate the layout for this fragment
        fragmentPeopleListBinding = FragmentPeopleListBinding.inflate(getLayoutInflater());


        if(userList.size() > 0){
            fragmentPeopleListBinding.recyclerFragmentList
                    .setLayoutManager(new LinearLayoutManager(getContext()));
            adapter = new RecyclerUserListAdapter(getContext(), userList);
            fragmentPeopleListBinding.recyclerFragmentList.setAdapter(adapter);
        }else{
            Toast.makeText(context, "Better Luck Next Time!", Toast.LENGTH_SHORT).show();
        }

        return fragmentPeopleListBinding.getRoot();
    }


}