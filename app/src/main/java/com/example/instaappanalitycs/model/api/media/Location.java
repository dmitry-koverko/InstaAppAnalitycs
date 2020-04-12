package com.example.instaappanalitycs.model.api.media;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("has_public_page")
    @Expose
    private boolean has_public_page;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("slug")
    @Expose
    private String slug;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isHas_public_page() {
        return has_public_page;
    }

    public void setHas_public_page(boolean has_public_page) {
        this.has_public_page = has_public_page;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}
