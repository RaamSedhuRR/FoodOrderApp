package com.example.lifecycleapp.fragments;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.lifecycleapp.adapter.RecyclerVolleyGetAdapter;
import com.example.lifecycleapp.database.User;
import com.example.lifecycleapp.databinding.FragmentVolleyBinding;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class VolleyFragment extends Fragment {

    FragmentVolleyBinding fragmentVolleyBinding;

    private List<User> userList;

    RecyclerVolleyGetAdapter adapter;

    Context context;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        userList = new ArrayList<>();
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        fragmentVolleyBinding=FragmentVolleyBinding.inflate(getLayoutInflater());
        GetData();
        fragmentVolleyBinding.swipeRefreshVolley.setOnRefreshListener(() -> {
            GetData();
            fragmentVolleyBinding.swipeRefreshVolley.setRefreshing(false);
        });

        return fragmentVolleyBinding.getRoot();
    }

    private void GetData() {
        final ProgressDialog progressDialog=new ProgressDialog(context);
        String url="https://run.mocky.io/v3/1bcffbe0-e921-4009-b28d-f830506b4567";
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        RequestQueue requestQueue= Volley.newRequestQueue(context);
        @SuppressLint("NotifyDataSetChanged") JsonArrayRequest jsonArrayRequest
                = new JsonArrayRequest(Request.Method.GET, url,
                null,response -> {
            for(int i=0;i<=response.length();i++){
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                        userList.add(new User(
                                jsonObject.getString("id"),
                                jsonObject.getString("name"),
                                jsonObject.getString("age"),
                                jsonObject.getString("phone number")
                        ));
                        Log.d("List ",String.valueOf(userList.size()));

                } catch (JSONException e) {
                    e.printStackTrace();
                    progressDialog.dismiss();
                }
            }
            fragmentVolleyBinding.recyclerVolleyGetTest
                    .setLayoutManager(new LinearLayoutManager(getContext()));

            adapter=new RecyclerVolleyGetAdapter(context,userList);
            fragmentVolleyBinding.recyclerVolleyGetTest.setAdapter(adapter);
//            adapter.notifyDataSetChanged();
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        },error -> {
            progressDialog.dismiss();
            Log.d("TEST_LOG", "Data : "+ error.getMessage());
            //Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
        });
        requestQueue.add(jsonArrayRequest);
    }
}