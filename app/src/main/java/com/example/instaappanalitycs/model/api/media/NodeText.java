package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NodeText {

    @SerializedName("text")
    @Expose
    private String __typename;

    public String getText() {
        return __typename;
    }

    public void setText(String __typename) {
        this.__typename = __typename;
    }
}
