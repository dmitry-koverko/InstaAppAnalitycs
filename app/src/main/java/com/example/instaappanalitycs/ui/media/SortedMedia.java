package com.example.instaappanalitycs.ui.media;

import com.example.instaappanalitycs.model.media.Media;

import java.util.Comparator;

public class SortedMedia implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        return 0;
    }

    public Long compareLikes(Media o1, Media o2){
        return o1.getCount_like() - o2.getCount_like();
    }

    public Long compareLikesReverse(Media o1, Media o2){
        return o2.getCount_like() - o1.getCount_like();
    }

}
