package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Edge_media_to_comment {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("page_info")
    @Expose
    private PageInfoComment pageInfo;
    @SerializedName("edges")
    @Expose
    private List<EdgeComment> edges = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PageInfoComment getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoComment pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<EdgeComment> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeComment> edges) {
        this.edges = edges;
    }
}
