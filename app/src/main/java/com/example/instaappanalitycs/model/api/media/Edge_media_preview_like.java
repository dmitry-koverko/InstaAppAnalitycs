package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edge_media_preview_like {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("edges")
    @Expose
    private Edge edges;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Edge getEdges() {
        return edges;
    }

    public void setEdges(Edge edges) {
        this.edges = edges;
    }
}
