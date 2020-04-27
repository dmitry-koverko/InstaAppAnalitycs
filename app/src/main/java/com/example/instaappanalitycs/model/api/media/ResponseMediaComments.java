package com.example.instaappanalitycs.model.api.media;

import com.example.instaappanalitycs.model.api.media.comments.DataComment;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseMediaComments {

    @SerializedName("data")
    @Expose
    private DataComment data;
    @SerializedName("status")
    @Expose
    private String status;

    public DataComment getData() {
        return data;
    }

    public void setData(DataComment data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
