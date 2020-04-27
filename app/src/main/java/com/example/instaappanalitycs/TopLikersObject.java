package com.example.instaappanalitycs;

import com.example.instaappanalitycs.model.TopComments;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Required;

public class TopLikersObject  extends RealmObject{

//
    private RealmList<TopComments> topComments;


    public TopLikersObject(){

    }

    public RealmList<TopComments> getTopComments() {
        return topComments;
    }

    public void setTopComments(RealmList<TopComments> topComments) {
        this.topComments = topComments;
    }
}
