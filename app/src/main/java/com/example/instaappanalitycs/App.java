package com.example.instaappanalitycs;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        try{
            Realm.init(this);
            RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
            Realm.deleteRealm(realmConfiguration);
            Realm.setDefaultConfiguration(realmConfiguration);

        }catch (Exception e){

        }
    }
}
