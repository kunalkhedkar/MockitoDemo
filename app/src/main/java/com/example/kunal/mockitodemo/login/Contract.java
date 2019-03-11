package com.example.kunal.mockitodemo.login;


import com.example.kunal.mockitodemo.login.data.LoginCredentials;

public interface Contract {

    interface LoginView {

        void onSuccess();

        void onFailed(String message);

    }

    interface Presenter {

        void login(LoginCredentials loginCredentials);

    }

}
