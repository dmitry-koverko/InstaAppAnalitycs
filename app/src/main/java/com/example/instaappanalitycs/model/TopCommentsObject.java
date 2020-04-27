package com.example.instaappanalitycs.model;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class TopCommentsObject extends RealmObject{

    private RealmList<TopComments> topComments;

    public TopCommentsObject(){

    }

    public RealmList<TopComments> getTopComments() {
        return topComments;
    }

    public void setTopComments(RealmList<TopComments> topComments) {
        this.topComments = topComments;
    }
}
