package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Edge_media_to_caption {

    @SerializedName("edges")
    @Expose
    private List<EdgeText> edges;

    public List<EdgeText> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeText> edges) {
        this.edges = edges;
    }
}
