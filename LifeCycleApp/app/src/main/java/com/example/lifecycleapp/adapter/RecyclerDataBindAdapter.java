package com.example.lifecycleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.databinding.ListItemConstraintDataBindBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.view.RecyclerDataBindingViewHolder;


import java.util.List;

public class RecyclerDataBindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    List<CMEmployee> contentData;


    public RecyclerDataBindAdapter(@NonNull Context context, List<CMEmployee> contentData) {

        this.context = context;

        this.contentData = contentData;
    }

    @NonNull

    public RecyclerView
            .ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ListItemConstraintDataBindBinding listItemConstraintDataBindBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.list_item_constraint_data_bind, parent, false);


        return new RecyclerDataBindingViewHolder(listItemConstraintDataBindBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CMEmployee employee = contentData.get(position);
        ((RecyclerDataBindingViewHolder) holder).listItemConstraintDataBinding
                .setEmployee(employee);
    }

    @Override
    public int getItemCount() {
        return contentData.size();
    }


}
