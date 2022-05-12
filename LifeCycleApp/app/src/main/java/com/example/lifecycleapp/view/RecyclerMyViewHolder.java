package com.example.lifecycleapp.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lifecycleapp.databinding.ListItemLinearBinding;

public class RecyclerMyViewHolder extends RecyclerView.ViewHolder
{
    @NonNull
    ListItemLinearBinding binding;

    public RecyclerMyViewHolder(@NonNull ListItemLinearBinding listBinding) {
        super(listBinding.getRoot());
        this.binding = listBinding;
    }


    public void bindView(String txtName){
       binding.listText.setText(txtName);
    }
}
