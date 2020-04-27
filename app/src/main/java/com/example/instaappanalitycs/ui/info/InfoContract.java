package com.example.instaappanalitycs.ui.info;

import com.example.instaappanalitycs.model.Post;
import com.example.instaappanalitycs.model.PostListObject;
import com.example.instaappanalitycs.model.TopComments;

import java.util.List;

public interface InfoContract {

    interface View{

    }

    interface Presenter{

        void getFeed(String next, int countMedia);
        void generatePosts();
        void getTop(PostListObject postListObject);
        void getCountsInfo();
        void addToRealmTopLikers(List<TopComments> listLikers);
        void addToRealmTopCommetns(List<TopComments> listComments);
    }
}
