package com.example.instaappanalitycs.ui.media;

import android.content.Context;
import android.util.Log;

import com.example.instaappanalitycs.model.media.FeedObject;
import com.example.instaappanalitycs.model.media.Media;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.realm.Realm;

public class MediaPresenter implements MediaContract.Presenter{

    private static String TAG = MediaPresenter.class.getName();

    private Context _context;
    private MediaContract.View _view;
    private Realm mRealm;
    private List<Media> mediaList;
    private List<Media> mediaListForRV;
    private TypeSortMedia _typeSort = TypeSortMedia.LIKE;

    public MediaPresenter(Context context, MediaContract.View view) {
        this._context = context;
        this._view = view;
        mRealm = Realm.getDefaultInstance();
        mediaList = new ArrayList<>();
        mediaListForRV = new ArrayList<>();
        getListFromRealm();

    }


    @Override
    public void getListFromRealm() {
        FeedObject feedObject = mRealm.where(FeedObject.class).findFirst();
        for(int i = 0; i < feedObject.getMediaRealmList().size(); i++){
            mediaList.add(feedObject.getMediaRealmList().get(i));
        }
        getData(0);
        getData(mediaListForRV.size());
        _typeSort = TypeSortMedia.LIKEREVERSE;
        getData(0);
    }

    @Override
    public void getData(int after) {
        Log.d(TAG, "type sort = " + _typeSort.name());

        if(after == 0) mediaListForRV.clear();

        switch (_typeSort){
            case LIKE:
                Collections.sort(mediaList, Media.MediaLikeComparator);
                break;
            case LIKEREVERSE:
                Collections.sort(mediaList, Media.MediaLikeComparatorReverse);
                break;
            case DATE:
                Collections.sort(mediaList, Media.MediaDateComparator);
                break;
            case DATEREVERSE:
                Collections.sort(mediaList, Media.MediaDateComparatorReverse);
                break;
            case COMMENTS:
                Collections.sort(mediaList, Media.MediaCommentsComparator);
                break;
            case COMMENTSREVERSE:
                Collections.sort(mediaList, Media.MediaCommentsComparatorReverse);
                break;
        }

        for(int i = after; i < after + 12; i++){
            if(i < mediaList.size()) mediaListForRV.add(mediaList.get(i));
        }

        for(Media m : mediaListForRV){
            Log.d(TAG, "media = " + m.getShortCode() + "  count likes = " + m.getCount_like());
        }
        Log.d(TAG, " --------------------------------------------");

    }

    @Override
    public void close() {

    }

    @Override
    public void setTypeSort(TypeSortMedia type) {
        this._typeSort = type;
    }


}
