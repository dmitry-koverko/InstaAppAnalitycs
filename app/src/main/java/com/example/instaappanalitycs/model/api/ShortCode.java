package com.example.instaappanalitycs.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShortCode {

    @SerializedName("code")
    @Expose
    private String code;

    public ShortCode(String code) {
        this.code = code;
    }
    public ShortCode() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
