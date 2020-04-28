package com.example.instaappanalitycs.model.media;

import io.realm.RealmList;
import io.realm.RealmObject;

public class FeedObject extends RealmObject {

    private RealmList<Media> mediaRealmList;

    public FeedObject(){}

    public RealmList<Media> getMediaRealmList() {
        return mediaRealmList;
    }

    public void setMediaRealmList(RealmList<Media> mediaRealmList) {
        this.mediaRealmList = mediaRealmList;
    }
}
