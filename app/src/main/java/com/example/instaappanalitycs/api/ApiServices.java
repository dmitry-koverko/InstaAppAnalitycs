package com.example.instaappanalitycs.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServices {

    final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build();

    Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.instagram.com/")
            .client(okHttpClient)
            .build();

    Retrofit retrofitMy = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://192.168.1.103/")
            .client(okHttpClient)
            .build();

    public IInstagramApi getApi(){

        IInstagramApi api = retrofit.create(IInstagramApi.class);
        return api;
    }

    public IMyApi getMyApi(){

        IMyApi api = retrofitMy.create(IMyApi.class);
        return api;
    }

}