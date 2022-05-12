package com.example.lifecycleapp.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.databinding.FragmentSharedPreferencesBinding;

public class SharedPreferencesFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    FragmentSharedPreferencesBinding fragmentSharedPreferencesBinding;

    Context context;

    boolean selectVal ;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }



    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ){
        // Inflate the layout for this fragment
        fragmentSharedPreferencesBinding = FragmentSharedPreferencesBinding
                .inflate(getLayoutInflater());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                context, R.array.values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        fragmentSharedPreferencesBinding.spinnerBool.setAdapter(adapter);
        fragmentSharedPreferencesBinding.spinnerBool.setOnItemSelectedListener(this);


        fragmentSharedPreferencesBinding.saveBtn.setOnClickListener(view -> {
            SharedPreferences sharedPreferencesPost =context
                    .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
            SharedPreferences.Editor myEdit = sharedPreferencesPost.edit();

            myEdit.putString("name", fragmentSharedPreferencesBinding.editTxtName.getText().toString());
            myEdit.putBoolean("booleanFlag", selectVal);
            myEdit.putFloat("floatValue", Float
                    .parseFloat(fragmentSharedPreferencesBinding.editTxtFloat.getText().toString()));
            myEdit.putInt("age", Integer.parseInt(fragmentSharedPreferencesBinding.editTxtAge.getText().toString()));
            myEdit.apply();
        });


        fragmentSharedPreferencesBinding.showBtn.setOnClickListener(view -> {
            SharedPreferences sharedPreferencesPost =context
                    .getSharedPreferences("CACHE_DATA", MODE_PRIVATE);
            String dataSet = sharedPreferencesPost.getString("name","")+"  "
                    + sharedPreferencesPost.getInt("age",0)+" "+ sharedPreferencesPost.getBoolean("booleanFlag",false)+
                    " "+sharedPreferencesPost.getFloat("floatValue", 0.00F);
            fragmentSharedPreferencesBinding.dataLabel.setText(dataSet);
            Toast.makeText(context, "Data Set : "+dataSet,
                           Toast.LENGTH_SHORT).show();
        });

        return fragmentSharedPreferencesBinding.getRoot();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
        selectVal =Boolean.parseBoolean(adapterView.getItemAtPosition(i).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView){

    }
}