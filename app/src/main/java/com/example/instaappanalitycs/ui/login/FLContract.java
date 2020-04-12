package com.example.instaappanalitycs.ui.login;

import android.net.ConnectivityManager;

import com.example.instaappanalitycs.model.user.User;

public interface FLContract {

    interface View {

        void loadWebView();
        void connectionFailed();
        void conectionSuccess();
    }

    interface Presenter{
        void getUname(String uid);
        void checkInternetConnection();
        void initListenerInternetConnection();
        void loginSuccess(User user);
        void clouseAll();
    }
}
