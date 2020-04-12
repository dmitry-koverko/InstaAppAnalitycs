package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

class EdgeComment {

    @SerializedName("node")
    @Expose
    private NodeComment node;

    public NodeComment getNode() {
        return node;
    }

    public void setNode(NodeComment node) {
        this.node = node;
    }
}
