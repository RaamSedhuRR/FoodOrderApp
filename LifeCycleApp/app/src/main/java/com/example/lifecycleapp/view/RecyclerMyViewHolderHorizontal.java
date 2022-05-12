package com.example.lifecycleapp.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.databinding.ListItemLinearHorizontalBinding;

public class RecyclerMyViewHolderHorizontal extends RecyclerView.ViewHolder {
    ListItemLinearHorizontalBinding binding;
    public RecyclerMyViewHolderHorizontal(@NonNull
                ListItemLinearHorizontalBinding listItemLinearHorizontalBinding) {
        super(listItemLinearHorizontalBinding.getRoot());
        this.binding = listItemLinearHorizontalBinding;

    }
    public void bindView(String txtName){
        binding.listText.setText(txtName);
    }

}
