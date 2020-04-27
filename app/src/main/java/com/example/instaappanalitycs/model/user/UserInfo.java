package com.example.instaappanalitycs.model.user;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class UserInfo extends RealmObject {

    @Required
    private Long count_followers;

    @Required
    private Long count_following;

    @Required
    private Long count_photo;

    @Required
    private Long count_video;

    @Required
    private Long count_slider;

    @Required
    private Long count_likes;

    @Required
    private Long count_comments;

    @Required
    private Long count_views;

    public UserInfo(){}

    public UserInfo(long count_followers, long count_following, long count_photo, long count_video, long count_slider, long count_likes, long count_comments, long count_views) {
        this.count_followers = count_followers;
        this.count_following = count_following;
        this.count_photo = count_photo;
        this.count_video = count_video;
        this.count_slider = count_slider;
        this.count_likes = count_likes;
        this.count_comments = count_comments;
        this.count_views = count_views;
    }

    public long getCount_followers() {
        return count_followers;
    }

    public void setCount_followers(long count_followers) {
        this.count_followers = count_followers;
    }

    public long getCount_following() {
        return count_following;
    }

    public void setCount_following(long count_following) {
        this.count_following = count_following;
    }

    public long getCount_photo() {
        return count_photo;
    }

    public void setCount_photo(long count_photo) {
        this.count_photo = count_photo;
    }

    public long getCount_video() {
        return count_video;
    }

    public void setCount_video(long count_video) {
        this.count_video = count_video;
    }

    public long getCount_slider() {
        return count_slider;
    }

    public void setCount_slider(long count_slider) {
        this.count_slider = count_slider;
    }

    public long getCount_likes() {
        return count_likes;
    }

    public void setCount_likes(long count_likes) {
        this.count_likes = count_likes;
    }

    public long getCount_comments() {
        return count_comments;
    }

    public void setCount_comments(long count_comments) {
        this.count_comments = count_comments;
    }

    public long getCount_views() {
        return count_views;
    }

    public void setCount_views(long count_views) {
        this.count_views = count_views;
    }

    public void convert(UserInfo _info){
        setCount_slider(_info.getCount_slider());
        setCount_photo(_info.getCount_photo());
        setCount_video(_info.getCount_video());
        setCount_views(_info.getCount_views());
        setCount_likes(_info.getCount_likes());
        setCount_comments(_info.getCount_comments());
        setCount_followers(_info.getCount_followers());
        setCount_following(_info.getCount_following());
    }
}
