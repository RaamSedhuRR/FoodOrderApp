package com.example.lifecycleapp.mvpArchitecture;

public class LoginPresenter implements LoginContract.Presenter{

    LoginContract.View view;

    public LoginPresenter (LoginContract.View view) {
        this.view=view;
    }

    @Override
    public void doLogin (String eMail,String password) {
        if(eMail.equals("rrr@gmail.com") && password.equals("1234")){
            view.onSuccess("Login Successful");
        }else{
            view.onError("Login Failed. Check Fields");
        }
    }
}
