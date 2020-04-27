package com.example.instaappanalitycs.model;

import com.example.instaappanalitycs.model.api.ShortCode;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PostListObject{

    @SerializedName("id")
    @Expose
    private String id = "";

    @SerializedName("list")
    @Expose
    private List<ShortCode> list = null;

    public List<ShortCode> getList() {
        return list;
    }

    public void setList(List<ShortCode> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
