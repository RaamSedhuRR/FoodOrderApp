package com.example.lifecycleapp.mvpArchitecture;

public interface LoginContract {

    interface View{
        void onSuccess(String Message);
        void onError(String Message);
    }

    interface Presenter{
        void doLogin(String eMail,String password);
    }
}
