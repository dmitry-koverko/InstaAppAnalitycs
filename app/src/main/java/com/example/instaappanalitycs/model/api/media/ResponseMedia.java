package com.example.instaappanalitycs.model.api.media;

import com.example.instaappanalitycs.model.api.Data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMedia {

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



}