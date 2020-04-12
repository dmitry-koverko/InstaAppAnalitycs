package com.example.instaappanalitycs.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reel {
    @SerializedName("__typename")
    @Expose
    private String typename;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("expiring_at")
    @Expose
    private Integer expiringAt;
    @SerializedName("has_pride_media")
    @Expose
    private Object hasPrideMedia;
    @SerializedName("latest_reel_media")
    @Expose
    private Object latestReelMedia;
    @SerializedName("seen")
    @Expose
    private Object seen;
    @SerializedName("user")
    @Expose
    private User_ user;
    @SerializedName("owner")
    @Expose
    private Owner owner;

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getExpiringAt() {
        return expiringAt;
    }

    public void setExpiringAt(Integer expiringAt) {
        this.expiringAt = expiringAt;
    }

    public Object getHasPrideMedia() {
        return hasPrideMedia;
    }

    public void setHasPrideMedia(Object hasPrideMedia) {
        this.hasPrideMedia = hasPrideMedia;
    }

    public Object getLatestReelMedia() {
        return latestReelMedia;
    }

    public void setLatestReelMedia(Object latestReelMedia) {
        this.latestReelMedia = latestReelMedia;
    }

    public Object getSeen() {
        return seen;
    }

    public void setSeen(Object seen) {
        this.seen = seen;
    }

    public User_ getUser() {
        return user;
    }

    public void setUser(User_ user) {
        this.user = user;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
