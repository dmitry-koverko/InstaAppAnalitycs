package com.example.instaappanalitycs.model.api.media.comments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataComment {

    @SerializedName("shortcode_media")
    @Expose
    private ShortcodeMedia shortcodeMedia;

    public ShortcodeMedia getShortcodeMedia() {
        return shortcodeMedia;
    }

    public void setShortcodeMedia(ShortcodeMedia shortcodeMedia) {
        this.shortcodeMedia = shortcodeMedia;
    }

}