package com.example.instaappanalitycs.model.media;

import java.util.Comparator;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Media extends RealmObject {

    private long date;
    private long count_like;
    private long count_views;
    private long count_comments;
    @Required
    private String text;
    @Required
    private String pic_url;
    @Required
    private String shortCode;

    public Media(){}

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getCount_like() {
        return count_like;
    }

    public void setCount_like(long count_like) {
        this.count_like = count_like;
    }

    public long getCount_views() {
        return count_views;
    }

    public void setCount_views(long count_views) {
        this.count_views = count_views;
    }

    public long getCount_comments() {
        return count_comments;
    }

    public void setCount_comments(long count_comments) {
        this.count_comments = count_comments;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public static Comparator<Media> MediaLikeComparator = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getCount_like();
            Long l2 = t1.getCount_like();
            return l2.compareTo(l1);

        }
    };

    public static Comparator<Media> MediaLikeComparatorReverse = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getCount_like();
            Long l2 = t1.getCount_like();
            return l1.compareTo(l2);

        }
    };

    public static Comparator<Media> MediaCommentsComparator = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getCount_comments();
            Long l2 = t1.getCount_comments();
            return l2.compareTo(l1);

        }
    };

    public static Comparator<Media> MediaCommentsComparatorReverse = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getCount_comments();
            Long l2 = t1.getCount_comments();
            return l1.compareTo(l2);

        }
    };

    public static Comparator<Media> MediaDateComparator = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getDate();
            Long l2 = t1.getDate();
            return l2.compareTo(l1);

        }
    };

    public static Comparator<Media> MediaDateComparatorReverse = new Comparator<Media>() {
        @Override
        public int compare(Media mediaObject, Media t1) {

            Long l1 = mediaObject.getDate();
            Long l2 = t1.getDate();
            return l1.compareTo(l2);

        }
    };

}
