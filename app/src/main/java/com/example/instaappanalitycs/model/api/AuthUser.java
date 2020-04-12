package com.example.instaappanalitycs.model.api;

import android.util.Log;

public class AuthUser {
    private static String TAG = AuthUser.class.getName();

    private String ds_user_id;
    private String csrftoken;
    private String sesid;
    private String mid;
    private String urlgen;

    public AuthUser(String cookie) {
        try{
            mid = cookie.split("mid=")[1].split(";")[0];
            urlgen = cookie.split("urlgen=")[1];
            urlgen = urlgen.split(":")[3];
            urlgen = urlgen.substring(0, urlgen.length()-2);
            csrftoken = cookie.split("csrftoken=")[1].split(";")[0];
            ds_user_id = cookie.split("ds_user_id=")[1].split(";")[0];
            sesid = cookie.split("sessionid=")[1].split(";")[0];

        }catch (Exception e){
            Log.e(TAG, e.getMessage());
            ds_user_id = "0";
        }
    }

    public String getDs_user_id() {
        return ds_user_id;
    }
}
