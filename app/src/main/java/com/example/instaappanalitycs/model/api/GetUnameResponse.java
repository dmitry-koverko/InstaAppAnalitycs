package com.example.instaappanalitycs.model.api;

import com.example.instaappanalitycs.model.user.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetUnameResponse {
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status")
    @Expose
    private String status;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User copyToUser(){
        User user = new User();
        if(data != null){
            if(data.getUser() != null){
                if(data.getUser().getReel() != null){
                    if (data.getUser().getReel().getOwner() != null){
                        Owner owner = data.getUser().getReel().getOwner();
                        if(owner.getUsername() != null) user.setUname(owner.getUsername());
                        if(owner.getId() != null) user.setUid(Long.valueOf(owner.getId()));
                        if(owner.getProfilePicUrl() != null) user.setProfile_pic(owner.getProfilePicUrl());
                    }
                }
            }
        }

        return user;
    }
}