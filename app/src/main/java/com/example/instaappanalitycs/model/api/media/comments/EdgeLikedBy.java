package com.example.instaappanalitycs.model.api.media.comments;

import com.example.instaappanalitycs.model.api.media.Edge;
import com.example.instaappanalitycs.model.api.media.Page_info;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EdgeLikedBy {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("page_info")
    @Expose
    private Page_info pageInfo;
    @SerializedName("edges")
    @Expose
    private List<Edge> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Page_info getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(Page_info pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
