package com.example.lifecycleapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.lifecycleapp.databinding.GridItemConstraintBinding;

public class GridAdapter extends BaseAdapter {

    Context context; String[] employeeNames;

    LayoutInflater layoutInflater;

    GridItemConstraintBinding gridItemConstraintBinding;


    public GridAdapter(Context context, String[] employeeNames) {
        this.context = context;
        this.employeeNames = employeeNames;
    }

    @Override
    public int getCount() {
        return employeeNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(layoutInflater == null)
            layoutInflater = LayoutInflater.from(context);
        if(view == null) gridItemConstraintBinding =
         GridItemConstraintBinding.inflate(layoutInflater, viewGroup, false);
        TextView empName =  gridItemConstraintBinding.txtgridItem;
        empName.setText(employeeNames[i]);
        return gridItemConstraintBinding.getRoot();
    }
}
