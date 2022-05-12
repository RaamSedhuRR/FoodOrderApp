package com.example.lifecycleapp.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.database.DataBaseHelper;
import com.example.lifecycleapp.databinding.FragmentSaveDataSqlDbBinding;




public class SaveDataSqlDbFragment extends Fragment {

    FragmentSaveDataSqlDbBinding fragmentSaveDataSqlDbBinding;

    Context context;

    DataBaseHelper dataBaseHelper;

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState
                            ){
        // Inflate the layout for this fragment

        fragmentSaveDataSqlDbBinding = FragmentSaveDataSqlDbBinding.inflate(getLayoutInflater());

        fragmentSaveDataSqlDbBinding.btnInsertData.setOnClickListener(view -> {
            boolean isInserted =  dataBaseHelper.insertData(
            fragmentSaveDataSqlDbBinding.txtUserName.getText().toString(),
            fragmentSaveDataSqlDbBinding.txtUserAge.getText().toString(),
            fragmentSaveDataSqlDbBinding.txtUserPhone.getText().toString());

            if(isInserted){
                Toast.makeText(context, "User Data Inserted Successfully...",
                               Toast.LENGTH_SHORT).show();
                resetForm();
            }else{
                Toast.makeText(context, "User Data Insertion Failed...",
                               Toast.LENGTH_SHORT).show();
            }
        });

        fragmentSaveDataSqlDbBinding.btnFetchData.setOnClickListener(view -> {
            Cursor cursor = dataBaseHelper.getAllData();
            if(cursor.getCount() == 0){
                showMessage("Error :" ," No Data Found");
                return;
            }

            StringBuilder buffer = new StringBuilder();
            while (cursor.moveToNext()){
                buffer.append("Id: ").append(cursor.getString(0)).append("\n");
                buffer.append("Name: ").append(cursor.getString(1)).append("\n");
                buffer.append("Age: ").append(cursor.getString(2)).append("\n");
                buffer.append("Phone Number: ").append(cursor.getString(3)).append("\n\n");
            }
            showMessage("Data:", buffer.toString());
        });

        fragmentSaveDataSqlDbBinding.btnUpdateData.setOnClickListener(view -> {
            boolean isUpdated = dataBaseHelper.updateData(
                    fragmentSaveDataSqlDbBinding.txtId.getText().toString(),
                    fragmentSaveDataSqlDbBinding.txtUserName.getText().toString(),
                    fragmentSaveDataSqlDbBinding.txtUserAge.getText().toString(),
                    fragmentSaveDataSqlDbBinding.txtUserPhone.getText().toString());

            if(isUpdated){
                Toast.makeText(context, "User Data Updated Successfully...",
                               Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "User Data Updation Failed...",
                               Toast.LENGTH_SHORT).show();
            }
        });

        fragmentSaveDataSqlDbBinding.btnDeleteData.setOnClickListener(view -> {
            Integer deleteRows = dataBaseHelper.deleteData(fragmentSaveDataSqlDbBinding.txtId.getText().toString());
            if(deleteRows > 0)
                Toast.makeText(context, "Data Deleted Successfully...", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "Data Deletion Failed...", Toast.LENGTH_SHORT).show();

        });


        return fragmentSaveDataSqlDbBinding.getRoot();
    }

    private void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    private void resetForm() {
        fragmentSaveDataSqlDbBinding.txtId.setText("");
        fragmentSaveDataSqlDbBinding.txtUserName.setText("");
        fragmentSaveDataSqlDbBinding.txtUserAge.setText("");
        fragmentSaveDataSqlDbBinding.txtUserPhone.setText("");
    }

}