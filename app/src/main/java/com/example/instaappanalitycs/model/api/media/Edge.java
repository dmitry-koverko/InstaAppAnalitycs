package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Edge {

    @SerializedName("node")
    @Expose
    private Node__ node;

    public Node__ getNode() {
        return node;
    }

    public void setNode(Node__ node) {
        this.node = node;
    }
}
