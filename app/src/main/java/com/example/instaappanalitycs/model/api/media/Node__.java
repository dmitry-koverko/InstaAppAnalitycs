package com.example.instaappanalitycs.model.api.media;

import com.example.instaappanalitycs.model.api.Owner;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Node__ {

    @SerializedName("__typename")
    @Expose
    private String __typename;


    @SerializedName("video_view_count")
    @Expose
    private Integer video_view_count;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("display_url")
    @Expose
    private String display_url;

    @SerializedName("edge_media_preview_like")
    @Expose
    private Edge_media_preview_like edge_media_preview_like;

    @SerializedName("edge_media_to_comment")
    @Expose
    private Edge_media_to_comment edge_media_to_comment;

    public Edge_media_to_comment getEdge_media_to_comment() {
        return edge_media_to_comment;
    }

    public void setEdge_media_to_comment(Edge_media_to_comment edge_media_to_comment) {
        this.edge_media_to_comment = edge_media_to_comment;
    }

    //    @SerializedName("display_resources")
//    @Expose
//    private Display_resources display_resources;

    @SerializedName("is_video")
    @Expose
    private boolean is_video;

    @SerializedName("tracking_token")
    @Expose
    private String tracking_token;

    @SerializedName("shortcode")
    @Expose
    private String shortcode;

    @SerializedName("taken_at_timestamp")
    @Expose
    private long taken_at_timestamp;

    @SerializedName("media_preview")
    @Expose
    private String media_preview;

    @SerializedName("owner")
    @Expose
    private Owner owner;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("thumbnail_src")
    @Expose
    private String thumbnail_src;

//    @SerializedName("thumbnail_resources")
//    @Expose
//    private Thumbnail_resources thumbnail_resources;


    public Edge_media_preview_like getEdge_media_preview_like() {
        return edge_media_preview_like;
    }

    public void setEdge_media_preview_like(Edge_media_preview_like edge_media_preview_like) {
        this.edge_media_preview_like = edge_media_preview_like;
    }

    public String get__typename() {
        return __typename;
    }

    public void set__typename(String __typename) {
        this.__typename = __typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }

//    public Display_resources getDisplay_resources() {
//        return display_resources;
//    }
//
//    public void setDisplay_resources(Display_resources display_resources) {
//        this.display_resources = display_resources;
//    }

    public boolean isIs_video() {
        return is_video;
    }

    public void setIs_video(boolean is_video) {
        this.is_video = is_video;
    }

    public String getTracking_token() {
        return tracking_token;
    }

    public void setTracking_token(String tracking_token) {
        this.tracking_token = tracking_token;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public long getTaken_at_timestamp() {
        return taken_at_timestamp;
    }

    public void setTaken_at_timestamp(long taken_at_timestamp) {
        this.taken_at_timestamp = taken_at_timestamp;
    }

    public String getMedia_preview() {
        return media_preview;
    }

    public void setMedia_preview(String media_preview) {
        this.media_preview = media_preview;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getThumbnail_src() {
        return thumbnail_src;
    }

    public void setThumbnail_src(String thumbnail_src) {
        this.thumbnail_src = thumbnail_src;
    }

//    public Thumbnail_resources getThumbnail_resources() {
//        return thumbnail_resources;
//    }
//
//    public void setThumbnail_resources(Thumbnail_resources thumbnail_resources) {
//        this.thumbnail_resources = thumbnail_resources;
//    }

    public Integer getVideo_view_count() {
        return video_view_count;
    }

    public void setVideo_view_count(Integer video_view_count) {
        this.video_view_count = video_view_count;
    }

}
