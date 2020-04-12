package com.example.instaappanalitycs.ui.worker;

public abstract class Presenter {
    abstract void checkInternetConnection();
    abstract void initListenerInternetConnection();
    abstract void connectionFailed();
    abstract void conectionSuccess();
}
