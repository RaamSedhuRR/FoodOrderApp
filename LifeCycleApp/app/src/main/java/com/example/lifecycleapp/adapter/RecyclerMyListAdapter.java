package com.example.lifecycleapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifecycleapp.databinding.ListItemLinearBinding;
import com.example.lifecycleapp.databinding.ListItemLinearHorizontalBinding;
import com.example.lifecycleapp.model.CMEmployee;
import com.example.lifecycleapp.view.RecyclerMyViewHolder;
import com.example.lifecycleapp.view.RecyclerMyViewHolderHorizontal;

import java.util.List;

public class RecyclerMyListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    List<CMEmployee> contentData;

    private final int LAYOUT_HORIZONTAL = 0;

    private final String TAG = getClass().getSimpleName();


    public RecyclerMyListAdapter(Context context, List<CMEmployee> contentData) {
        this.context = context;
        this.contentData = contentData;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder
           onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "ViewType : " + viewType);
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == LAYOUT_HORIZONTAL) {
            return new RecyclerMyViewHolderHorizontal (
                    ListItemLinearHorizontalBinding
                            .inflate(layoutInflater, parent, false));
        }
        else {
            return new RecyclerMyViewHolder (
                    ListItemLinearBinding
                            .inflate(layoutInflater, parent, false)
            );
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RecyclerMyViewHolder) {
            ((RecyclerMyViewHolder) holder).bindView(contentData.get(position).getEmpName());
        }
        else {
           ((RecyclerMyViewHolderHorizontal) holder)
                   .bindView(contentData.get(position).getEmpName());
        }
    }

    @Override
    public int getItemCount() {
        return contentData.size();
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "MsgMine : " + contentData.get(position).type);
        int LAYOUT_VERTICAL = 1;
        if (contentData.get(position).type == 0)
            return LAYOUT_HORIZONTAL;
        else
            return LAYOUT_VERTICAL;
    }




}




