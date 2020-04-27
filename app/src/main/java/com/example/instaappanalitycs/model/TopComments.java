package com.example.instaappanalitycs.model;

import com.example.instaappanalitycs.model.api.Owner;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import io.realm.RealmObject;

public class TopComments extends RealmObject implements Comparable<TopComments>{

    private int count_comment;
    private Owner owner;

    public TopComments(){
        count_comment = 1;
        owner = null;
    }

    public void addOne(){
        this.count_comment = this.count_comment += 1;
    }

    public TopComments(Owner owner) {
        count_comment = 0;
        this.owner = owner;
    }

    public int getCount_comment() {
        return count_comment;
    }

    public void setCount_comment(int count_comment) {
        this.count_comment = count_comment;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString(){
        return owner.getUsername() + "   ---   " + count_comment;
    }


    @Override
    public int compareTo(TopComments o) {
        return o.getCount_comment() - this.count_comment;
    }



}
