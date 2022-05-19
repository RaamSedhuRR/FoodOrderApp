package com.example.foodorderapp.mvpArchitecture;

public class RestaurentListPresenter implements RestaurentListContract.Presenter{

    RestaurentListContract.View view;

    public RestaurentListPresenter (RestaurentListContract.View view){
        this.view = view;
    }

    @Override
    public void start () {
        view.init();
        view.addToCart();
        view.removeFromCart();
    }

}
