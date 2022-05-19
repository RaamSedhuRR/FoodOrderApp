package com.example.lifecycleapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lifecycleapp.R;
import com.example.lifecycleapp.databinding.FragmentMVPBinding;
import com.example.lifecycleapp.mvpArchitecture.LoginContract;
import com.example.lifecycleapp.mvpArchitecture.LoginPresenter;

public class MVPFragment extends Fragment implements LoginContract.View {

    FragmentMVPBinding fragmentMVPBinding;

    Context context;

    LoginContract.Presenter presenter;

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentMVPBinding = FragmentMVPBinding.inflate(getLayoutInflater());

        presenter = new LoginPresenter(this);

        fragmentMVPBinding.btnLogin.setOnClickListener(view -> {
            if(fragmentMVPBinding.txtUserName.getText().toString().isEmpty()
                    || fragmentMVPBinding.txtPassword.getText().toString().isEmpty()){
                onError("All the Fields are mandatory!");
            }else{
                presenter.doLogin(fragmentMVPBinding.txtUserName.getText().toString()
                        ,fragmentMVPBinding.txtPassword.getText().toString());
            }
        });
        return fragmentMVPBinding.getRoot();
    }

    @Override
    public void onSuccess (String Message) {
        Toast.makeText(context,Message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError (String Message) {
        Toast.makeText(context,Message,Toast.LENGTH_SHORT).show();
    }
}