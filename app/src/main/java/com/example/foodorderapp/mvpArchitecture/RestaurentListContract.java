package com.example.foodorderapp.mvpArchitecture;

public class RestaurentListContract {
    public interface View {

        void init();

        int addToCart();

        int removeFromCart();

    }


    interface Presenter {
        void start();

    }
}
