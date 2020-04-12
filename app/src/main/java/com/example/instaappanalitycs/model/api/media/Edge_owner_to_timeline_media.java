package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Edge_owner_to_timeline_media {

    @SerializedName("count")
    @Expose
    private int count;

    @SerializedName("page_info")
    @Expose
    private Page_info page_info;

    @SerializedName("edges")
    @Expose
    private List<Edge> edges;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //
    public Page_info getPage_info() {
        return page_info;
    }

    public void setPage_info(Page_info page_info) {
        this.page_info = page_info;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}

