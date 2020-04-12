package com.example.instaappanalitycs.model;

public class GetUname {

    private String user_id;
    private Boolean include_chaining;
    private Boolean include_reel;
    private Boolean include_suggested_users;
    private Boolean include_logged_out_extras;
    private Boolean include_highlight_reels;
    private Boolean include_related_profiles;

    public GetUname(){}

    public GetUname(String user_id, Boolean include_chaining, Boolean include_reel, Boolean include_suggested_users, Boolean include_logged_out_extras, Boolean include_highlight_reels, Boolean include_related_profiles) {
        this.user_id = user_id;
        this.include_chaining = include_chaining;
        this.include_reel = include_reel;
        this.include_suggested_users = include_suggested_users;
        this.include_logged_out_extras = include_logged_out_extras;
        this.include_highlight_reels = include_highlight_reels;
        this.include_related_profiles = include_related_profiles;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Boolean getInclude_chaining() {
        return include_chaining;
    }

    public void setInclude_chaining(Boolean include_chaining) {
        this.include_chaining = include_chaining;
    }

    public Boolean getInclude_reel() {
        return include_reel;
    }

    public void setInclude_reel(Boolean include_reel) {
        this.include_reel = include_reel;
    }

    public Boolean getInclude_suggested_users() {
        return include_suggested_users;
    }

    public void setInclude_suggested_users(Boolean include_suggested_users) {
        this.include_suggested_users = include_suggested_users;
    }

    public Boolean getInclude_logged_out_extras() {
        return include_logged_out_extras;
    }

    public void setInclude_logged_out_extras(Boolean include_logged_out_extras) {
        this.include_logged_out_extras = include_logged_out_extras;
    }

    public Boolean getInclude_highlight_reels() {
        return include_highlight_reels;
    }

    public void setInclude_highlight_reels(Boolean include_highlight_reels) {
        this.include_highlight_reels = include_highlight_reels;
    }

    public Boolean getInclude_related_profiles() {
        return include_related_profiles;
    }

    public void setInclude_related_profiles(Boolean include_related_profiles) {
        this.include_related_profiles = include_related_profiles;
    }
}
