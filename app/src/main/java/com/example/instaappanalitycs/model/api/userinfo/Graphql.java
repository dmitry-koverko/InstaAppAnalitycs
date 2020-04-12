package com.example.instaappanalitycs.model.api.userinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Graphql {

    @SerializedName("user")
    @Expose
    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
