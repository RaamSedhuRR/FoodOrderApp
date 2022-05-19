package com.example.lifecycleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.database.User;
import com.example.lifecycleapp.databinding.UserListDataStyleBinding;
import com.example.lifecycleapp.retrofit.UserApi;
import com.example.lifecycleapp.view.RecyclerUserListViewHolder;

import java.util.List;

public class RecyclerVolleyGetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    List<User> userList;
    public RecyclerVolleyGetAdapter(Context context,List<User> userList){
        this.context = context;
        this.userList = userList;

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new RecyclerUserListViewHolder(UserListDataStyleBinding
                .inflate(layoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder,int position) {
        (( RecyclerUserListViewHolder ) holder).bindView(userList.get(position).getId(),
                userList.get(position).getName(),
                userList.get(position).getAge(),userList.get(position).getPhoneNumber());
    }

    @Override
    public int getItemCount () {
        return userList.size();
    }
}
