package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EdgeText {

    @SerializedName("node")
    @Expose
    private NodeText node;

    public NodeText getNode() {
        return node;
    }

    public void setNode(NodeText node) {
        this.node = node;
    }
}
