package com.example.foodorderapp.viewHolder;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodorderapp.databinding.RestaurentListItemBinding;
import com.example.foodorderapp.listeners.CartListener;
import com.example.foodorderapp.model.RestaurentList;


public class RestaurentListRecyclerViewHolder extends RecyclerView.ViewHolder {

    RestaurentListItemBinding binding;

    SharedPreferences sharedPreferencesGet;

    int addToCartCounter;

    public RestaurentListRecyclerViewHolder (@NonNull View itemView) {
        super(itemView);
    }

    public void bind(RestaurentList restaurentItem,Context context,CartListener cartListener) {
        binding =  RestaurentListItemBinding.bind(itemView);

        Glide.with(context)
                .load(restaurentItem.getDishImageView())
                .into(binding.restaurentListImgView);

        binding.restaurentName.setText(restaurentItem.getRestaurentName());

        binding.restaurentAddress.setText(restaurentItem.getRestaurentAddress());
        sharedPreferencesGet =context
                .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
        addToCartCounter = sharedPreferencesGet.getInt("addToCartCounter",0);

        binding.btnAddItem.setOnClickListener(view -> {
            binding.btnAddItem.setVisibility(View.INVISIBLE);
            binding.btnRelativeItem.setVisibility(View.VISIBLE);
            binding.btnAddDelAddItem.setOnClickListener(view1 -> {
                cartListener.addToCart();
                Log.d("counter",String.valueOf(addToCartCounter));
                if( sharedPreferencesGet.getInt("addToCartCounter",0) == 0 ){
                    binding.btnAddItem.setVisibility(View.VISIBLE);
                    binding.btnRelativeItem.setVisibility(View.INVISIBLE);
                }
            });
            binding.btnAddDelDelItem.setOnClickListener(view1 -> {
                Log.d("counter",String.valueOf(addToCartCounter));
                if(sharedPreferencesGet.getInt("addToCartCounter",0) ==  0){
                    binding.btnAddItem.setVisibility(View.VISIBLE);
                    binding.btnRelativeItem.setVisibility(View.INVISIBLE);
                }
                cartListener.removeFromCart();
            });
            cartListener.addToCart();
        });

        binding.btnShareItem.setOnClickListener(view -> {
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Share Address To:";
            String shareSubject = "74, Race Course Rd, Gopalapuram, Coimbatore, Tamil Nadu 641018";
            sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
            context.startActivity(Intent.createChooser(sharingIntent, "Share using"));
        });



    }
}
