package com.example.lifecycleapp.view;



import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.databinding.ListItemConstraintDataBindBinding;

import java.util.Objects;


public class RecyclerDataBindingViewHolder extends RecyclerView.ViewHolder {

    public ListItemConstraintDataBindBinding listItemConstraintDataBinding;


    public RecyclerDataBindingViewHolder(@NonNull ListItemConstraintDataBindBinding listItemConstraintDataBindBinding) {
        super(listItemConstraintDataBindBinding.getRoot());
        listItemConstraintDataBinding =DataBindingUtil.getBinding(listItemConstraintDataBindBinding.listItemDataBind.getRootView());
        this.listItemConstraintDataBinding =Objects
                .requireNonNull(listItemConstraintDataBindBinding);
    }
}
