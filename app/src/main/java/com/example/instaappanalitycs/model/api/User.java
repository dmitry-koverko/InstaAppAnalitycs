package com.example.instaappanalitycs.model.api;

import com.example.instaappanalitycs.model.api.media.Edge_owner_to_timeline_media;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("reel")
    @Expose
    private Reel reel;

    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
    }

    @SerializedName("edge_owner_to_timeline_media")
    @Expose
    private Edge_owner_to_timeline_media edge_owner_to_timeline_media;

    public Edge_owner_to_timeline_media getEdge_owner_to_timeline_media() {
        return edge_owner_to_timeline_media;
    }

    public void setEdge_owner_to_timeline_media(Edge_owner_to_timeline_media edge_owner_to_timeline_media) {
        this.edge_owner_to_timeline_media = edge_owner_to_timeline_media;
    }
}