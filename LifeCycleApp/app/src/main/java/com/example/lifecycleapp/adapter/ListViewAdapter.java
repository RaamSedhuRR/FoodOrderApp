package com.example.lifecycleapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.lifecycleapp.databinding.ListViewRelativeBinding;
import com.example.lifecycleapp.model.CMEmployee;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<CMEmployee> {

    private final Context context;

    int resource;

    ListViewRelativeBinding binding;

    public ListViewAdapter
            (@NonNull Context context, int resource, @NonNull List<CMEmployee> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;

    }

    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent) {
        String name = getItem(position).getEmpName();
        String email = getItem(position).getEmpEmail();
        Integer type = getItem(position).getType();
        new CMEmployee(name, email, type);
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        binding = ListViewRelativeBinding.bind(layoutInflater
                  .inflate(resource, parent, false));
        binding.listViewText.setText(name);
        return binding.getRoot();
    }
}
