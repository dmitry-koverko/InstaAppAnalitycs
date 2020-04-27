package com.example.instaappanalitycs.api;

import com.example.instaappanalitycs.model.api.GetUnameResponse;
import com.example.instaappanalitycs.model.api.media.ResponseMedia;
import com.example.instaappanalitycs.model.api.media.ResponseMediaComments;
import com.example.instaappanalitycs.model.api.userinfo.ResponseUserInfoA1;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface IInstagramApi {

    @GET("/graphql/query/")
    Observable<GetUnameResponse> GetUserName(@Query("query_hash") String query_hash, @Query("variables") String variables, @Header("Cookie") String cookie);

    @GET("/{username}/?__a=1")
    Observable<ResponseUserInfoA1> GetUserInfo(@Path("username") String username, @Header("Cookie") String cookie);

    @GET("/graphql/query/")
    Observable<ResponseMedia> GetUserMedia(@Query("query_hash") String query_hash, @Query("variables") String variables, @Header("Cookie") String cookie);

    @GET("/graphql/query/")
    Observable<ResponseMediaComments> GetMediaComments(@Query("query_hash") String query_hash, @Query("variables") String variables, @Header("Cookie") String cookie);

    @GET("/graphql/query/")
    Observable<ResponseMedia> GetMediaLikes(@Query("query_hash") String query_hash, @Query("variables") String variables, @Header("Cookie") String cookie);
}
