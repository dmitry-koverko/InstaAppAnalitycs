package com.example.instaappanalitycs.api;

import com.example.instaappanalitycs.model.Post;
import com.example.instaappanalitycs.model.PostListObject;
import com.example.instaappanalitycs.model.api.GetUnameResponse;
import com.example.instaappanalitycs.model.api.media.ResponseMedia;
import com.example.instaappanalitycs.model.api.media.ResponseMediaComments;
import com.example.instaappanalitycs.model.api.userinfo.ResponseUserInfoA1;

import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface IMyApi {


        @POST("/top/comments/")
        Observable<String> getTopComments(@Body PostListObject postListObject);

        @POST("/top/likers/")
        Observable<String> getTopLikers(@Body PostListObject postListObject);}
