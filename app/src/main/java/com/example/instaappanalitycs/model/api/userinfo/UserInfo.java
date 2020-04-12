package com.example.instaappanalitycs.model.api.userinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {

    @SerializedName("biography")
    @Expose
    private String biography;
    @SerializedName("blocked_by_viewer")
    @Expose
    private Boolean blockedByViewer;
    @SerializedName("restricted_by_viewer")
    @Expose
    private Boolean restrictedByViewer;
    @SerializedName("country_block")
    @Expose
    private Boolean countryBlock;
    @SerializedName("external_url")
    @Expose
    private Object externalUrl;
    @SerializedName("external_url_linkshimmed")
    @Expose
    private Object externalUrlLinkshimmed;
    @SerializedName("edge_followed_by")
    @Expose
    private EdgeFollowedBy edgeFollowedBy;
    @SerializedName("followed_by_viewer")
    @Expose
    private Boolean followedByViewer;
    @SerializedName("edge_follow")
    @Expose
    private EdgeFollow edgeFollow;
    @SerializedName("follows_viewer")
    @Expose
    private Boolean followsViewer;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("has_channel")
    @Expose
    private Boolean hasChannel;
    @SerializedName("has_blocked_viewer")
    @Expose
    private Boolean hasBlockedViewer;
    @SerializedName("highlight_reel_count")
    @Expose
    private Integer highlightReelCount;
    @SerializedName("has_requested_viewer")
    @Expose
    private Boolean hasRequestedViewer;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("is_business_account")
    @Expose
    private Boolean isBusinessAccount;
    @SerializedName("is_joined_recently")
    @Expose
    private Boolean isJoinedRecently;
    @SerializedName("business_category_name")
    @Expose
    private String businessCategoryName;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("overall_category_name")
    @Expose
    private Object overallCategoryName;
    @SerializedName("is_private")
    @Expose
    private Boolean isPrivate;
    @SerializedName("is_verified")
    @Expose
    private Boolean isVerified;
    @SerializedName("edge_mutual_followed_by")
    @Expose
    private EdgeMutualFollowedBy edgeMutualFollowedBy;
    @SerializedName("profile_pic_url")
    @Expose
    private String profilePicUrl;
    @SerializedName("profile_pic_url_hd")
    @Expose
    private String profilePicUrlHd;
    @SerializedName("requested_by_viewer")
    @Expose
    private Boolean requestedByViewer;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("connected_fb_page")
    @Expose
    private Object connectedFbPage;
    @SerializedName("edge_felix_combined_post_uploads")
    @Expose
    private EngeGeneral edgeFelixCombinedPostUploads;
    @SerializedName("edge_felix_combined_draft_uploads")
    @Expose
    private EngeGeneral edgeFelixCombinedDraftUploads;
    @SerializedName("edge_felix_video_timeline")
    @Expose
    private EngeGeneral edgeFelixVideoTimeline;
    @SerializedName("edge_felix_drafts")
    @Expose
    private EngeGeneral edgeFelixDrafts;
    @SerializedName("edge_felix_pending_post_uploads")
    @Expose
    private EngeGeneral edgeFelixPendingPostUploads;
    @SerializedName("edge_felix_pending_draft_uploads")
    @Expose
    private EngeGeneral edgeFelixPendingDraftUploads;
    @SerializedName("edge_owner_to_timeline_media")
    @Expose
    private EngeGeneral edgeOwnerToTimelineMedia;
    @SerializedName("edge_saved_media")
    @Expose
    private EngeGeneral edgeSavedMedia;
    @SerializedName("edge_media_collections")
    @Expose
    private EngeGeneral edgeMediaCollections;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Boolean getBlockedByViewer() {
        return blockedByViewer;
    }

    public void setBlockedByViewer(Boolean blockedByViewer) {
        this.blockedByViewer = blockedByViewer;
    }

    public Boolean getRestrictedByViewer() {
        return restrictedByViewer;
    }

    public void setRestrictedByViewer(Boolean restrictedByViewer) {
        this.restrictedByViewer = restrictedByViewer;
    }

    public Boolean getCountryBlock() {
        return countryBlock;
    }

    public void setCountryBlock(Boolean countryBlock) {
        this.countryBlock = countryBlock;
    }

    public Object getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(Object externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Object getExternalUrlLinkshimmed() {
        return externalUrlLinkshimmed;
    }

    public void setExternalUrlLinkshimmed(Object externalUrlLinkshimmed) {
        this.externalUrlLinkshimmed = externalUrlLinkshimmed;
    }

    public EdgeFollowedBy getEdgeFollowedBy() {
        return edgeFollowedBy;
    }

    public void setEdgeFollowedBy(EdgeFollowedBy edgeFollowedBy) {
        this.edgeFollowedBy = edgeFollowedBy;
    }

    public Boolean getFollowedByViewer() {
        return followedByViewer;
    }

    public void setFollowedByViewer(Boolean followedByViewer) {
        this.followedByViewer = followedByViewer;
    }

    public EdgeFollow getEdgeFollow() {
        return edgeFollow;
    }

    public void setEdgeFollow(EdgeFollow edgeFollow) {
        this.edgeFollow = edgeFollow;
    }

    public Boolean getFollowsViewer() {
        return followsViewer;
    }

    public void setFollowsViewer(Boolean followsViewer) {
        this.followsViewer = followsViewer;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getHasChannel() {
        return hasChannel;
    }

    public void setHasChannel(Boolean hasChannel) {
        this.hasChannel = hasChannel;
    }

    public Boolean getHasBlockedViewer() {
        return hasBlockedViewer;
    }

    public void setHasBlockedViewer(Boolean hasBlockedViewer) {
        this.hasBlockedViewer = hasBlockedViewer;
    }

    public Integer getHighlightReelCount() {
        return highlightReelCount;
    }

    public void setHighlightReelCount(Integer highlightReelCount) {
        this.highlightReelCount = highlightReelCount;
    }

    public Boolean getHasRequestedViewer() {
        return hasRequestedViewer;
    }

    public void setHasRequestedViewer(Boolean hasRequestedViewer) {
        this.hasRequestedViewer = hasRequestedViewer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getIsBusinessAccount() {
        return isBusinessAccount;
    }

    public void setIsBusinessAccount(Boolean isBusinessAccount) {
        this.isBusinessAccount = isBusinessAccount;
    }

    public Boolean getIsJoinedRecently() {
        return isJoinedRecently;
    }

    public void setIsJoinedRecently(Boolean isJoinedRecently) {
        this.isJoinedRecently = isJoinedRecently;
    }

    public String getBusinessCategoryName() {
        return businessCategoryName;
    }

    public void setBusinessCategoryName(String businessCategoryName) {
        this.businessCategoryName = businessCategoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Object getOverallCategoryName() {
        return overallCategoryName;
    }

    public void setOverallCategoryName(Object overallCategoryName) {
        this.overallCategoryName = overallCategoryName;
    }

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public EdgeMutualFollowedBy getEdgeMutualFollowedBy() {
        return edgeMutualFollowedBy;
    }

    public void setEdgeMutualFollowedBy(EdgeMutualFollowedBy edgeMutualFollowedBy) {
        this.edgeMutualFollowedBy = edgeMutualFollowedBy;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getProfilePicUrlHd() {
        return profilePicUrlHd;
    }

    public void setProfilePicUrlHd(String profilePicUrlHd) {
        this.profilePicUrlHd = profilePicUrlHd;
    }

    public Boolean getRequestedByViewer() {
        return requestedByViewer;
    }

    public void setRequestedByViewer(Boolean requestedByViewer) {
        this.requestedByViewer = requestedByViewer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getConnectedFbPage() {
        return connectedFbPage;
    }

    public void setConnectedFbPage(Object connectedFbPage) {
        this.connectedFbPage = connectedFbPage;
    }

    public EngeGeneral getEdgeFelixCombinedPostUploads() {
        return edgeFelixCombinedPostUploads;
    }

    public void setEdgeFelixCombinedPostUploads(EngeGeneral edgeFelixCombinedPostUploads) {
        this.edgeFelixCombinedPostUploads = edgeFelixCombinedPostUploads;
    }

    public EngeGeneral getEdgeFelixCombinedDraftUploads() {
        return edgeFelixCombinedDraftUploads;
    }

    public void setEdgeFelixCombinedDraftUploads(EngeGeneral edgeFelixCombinedDraftUploads) {
        this.edgeFelixCombinedDraftUploads = edgeFelixCombinedDraftUploads;
    }

    public EngeGeneral getEdgeFelixVideoTimeline() {
        return edgeFelixVideoTimeline;
    }

    public void setEdgeFelixVideoTimeline(EngeGeneral edgeFelixVideoTimeline) {
        this.edgeFelixVideoTimeline = edgeFelixVideoTimeline;
    }

    public EngeGeneral getEdgeFelixDrafts() {
        return edgeFelixDrafts;
    }

    public void setEdgeFelixDrafts(EngeGeneral edgeFelixDrafts) {
        this.edgeFelixDrafts = edgeFelixDrafts;
    }

    public EngeGeneral getEdgeFelixPendingPostUploads() {
        return edgeFelixPendingPostUploads;
    }

    public void setEdgeFelixPendingPostUploads(EngeGeneral edgeFelixPendingPostUploads) {
        this.edgeFelixPendingPostUploads = edgeFelixPendingPostUploads;
    }

    public EngeGeneral getEdgeFelixPendingDraftUploads() {
        return edgeFelixPendingDraftUploads;
    }

    public void setEdgeFelixPendingDraftUploads(EngeGeneral edgeFelixPendingDraftUploads) {
        this.edgeFelixPendingDraftUploads = edgeFelixPendingDraftUploads;
    }

    public EngeGeneral getEdgeOwnerToTimelineMedia() {
        return edgeOwnerToTimelineMedia;
    }

    public void setEdgeOwnerToTimelineMedia(EngeGeneral edgeOwnerToTimelineMedia) {
        this.edgeOwnerToTimelineMedia = edgeOwnerToTimelineMedia;
    }

    public EngeGeneral getEdgeSavedMedia() {
        return edgeSavedMedia;
    }

    public void setEdgeSavedMedia(EngeGeneral edgeSavedMedia) {
        this.edgeSavedMedia = edgeSavedMedia;
    }

    public EngeGeneral getEdgeMediaCollections() {
        return edgeMediaCollections;
    }

    public void setEdgeMediaCollections(EngeGeneral edgeMediaCollections) {
        this.edgeMediaCollections = edgeMediaCollections;
    }

}
