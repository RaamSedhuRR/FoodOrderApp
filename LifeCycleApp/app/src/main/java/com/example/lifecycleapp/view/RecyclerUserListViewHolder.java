package com.example.lifecycleapp.view;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.databinding.UserListDataBinding;
import com.example.lifecycleapp.databinding.UserListDataStyleBinding;

public class RecyclerUserListViewHolder extends RecyclerView.ViewHolder{

    UserListDataStyleBinding userListDataStyleBinding;

    public RecyclerUserListViewHolder(@NonNull UserListDataStyleBinding userListDataStyleBinding){
        super(userListDataStyleBinding.getRoot());
        this.userListDataStyleBinding = userListDataStyleBinding;

    }
    public void bindView(String txtId,String txtName,String txtAge,String txtPhone){
        userListDataStyleBinding.txtId.setText(txtId);
        userListDataStyleBinding.txtName.setText(txtName);
        userListDataStyleBinding.txtAge.setText(txtAge);
        userListDataStyleBinding.txtPhone.setText(txtPhone);
    }
}
