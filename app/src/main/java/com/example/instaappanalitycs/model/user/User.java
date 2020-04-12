package com.example.instaappanalitycs.model.user;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class User extends RealmObject {
    @Required
    private String uname;
    @Required
    private String profile_pic;
    @Required
    private Long uid;

    public User(){

    }
    public User(String uname,String profile_pic, Long uid) {
        this.uname = uname;
        this.profile_pic = profile_pic;
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public Long getUid() {
        return uid;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
