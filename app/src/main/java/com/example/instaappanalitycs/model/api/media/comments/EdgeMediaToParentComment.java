package com.example.instaappanalitycs.model.api.media.comments;


import com.example.instaappanalitycs.model.api.media.Page_info;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EdgeMediaToParentComment {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("page_info")
    @Expose
    private Page_info pageInfo;
    @SerializedName("edges")
    @Expose
    private List<EdgeComment> edges = null;

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

    public List<EdgeComment> getEdges() {
        return edges;
    }

    public void setEdges(List<EdgeComment> edges) {
        this.edges = edges;
    }

}