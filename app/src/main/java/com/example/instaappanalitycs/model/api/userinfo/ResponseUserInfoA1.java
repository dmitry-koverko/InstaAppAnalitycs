package com.example.instaappanalitycs.model.api.userinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseUserInfoA1 {

    @SerializedName("logging_page_id")
    @Expose
    private String loggingPageId;
    @SerializedName("show_suggested_profiles")
    @Expose
    private Boolean showSuggestedProfiles;
    @SerializedName("show_follow_dialog")
    @Expose
    private Boolean showFollowDialog;
    @SerializedName("graphql")
    @Expose
    private Graphql graphql;
    @SerializedName("toast_content_on_load")
    @Expose
    private Object toastContentOnLoad;

    public String getLoggingPageId() {
        return loggingPageId;
    }

    public void setLoggingPageId(String loggingPageId) {
        this.loggingPageId = loggingPageId;
    }

    public Boolean getShowSuggestedProfiles() {
        return showSuggestedProfiles;
    }

    public void setShowSuggestedProfiles(Boolean showSuggestedProfiles) {
        this.showSuggestedProfiles = showSuggestedProfiles;
    }

    public Boolean getShowFollowDialog() {
        return showFollowDialog;
    }

    public void setShowFollowDialog(Boolean showFollowDialog) {
        this.showFollowDialog = showFollowDialog;
    }

    public Graphql getGraphql() {
        return graphql;
    }

    public void setGraphql(Graphql graphql) {
        this.graphql = graphql;
    }

    public Object getToastContentOnLoad() {
        return toastContentOnLoad;
    }

    public void setToastContentOnLoad(Object toastContentOnLoad) {
        this.toastContentOnLoad = toastContentOnLoad;
    }

}
