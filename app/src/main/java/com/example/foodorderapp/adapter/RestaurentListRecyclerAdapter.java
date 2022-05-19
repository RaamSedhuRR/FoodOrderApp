package com.example.foodorderapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.foodorderapp.databinding.RestaurentListItemBinding;
import com.example.foodorderapp.listeners.CartListener;
import com.example.foodorderapp.model.RestaurentList;
import com.example.foodorderapp.viewHolder.RestaurentListRecyclerViewHolder;

import java.util.List;


public class RestaurentListRecyclerAdapter
        extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    List<RestaurentList> restaurentLists;


    CartListener cartListener;


    public RestaurentListRecyclerAdapter(Context context,
                                         List<RestaurentList> restaurentLists,
                                         CartListener cartListener){
        this.context = context;
        this.restaurentLists = restaurentLists;
        this.cartListener = cartListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType) {
        return new RestaurentListRecyclerViewHolder(RestaurentListItemBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent,false).getRoot());
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder,int position) {
        ((RestaurentListRecyclerViewHolder) holder)
                .bind(restaurentLists.get(position), context,cartListener);
    }

    @Override
    public int getItemCount () {
        return restaurentLists.size();
    }
}
