package com.example.instaappanalitycs.model;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import com.example.instaappanalitycs.api.ApiServices;
import com.example.instaappanalitycs.api.GitHubService;
import com.example.instaappanalitycs.model.api.Owner;
import com.example.instaappanalitycs.model.api.media.Edge;
import com.example.instaappanalitycs.model.api.media.Node__;
import com.example.instaappanalitycs.model.api.media.Page_info;
import com.example.instaappanalitycs.model.api.media.ResponseMediaComments;
import com.example.instaappanalitycs.model.api.media.comments.EdgeComment;
import com.example.instaappanalitycs.model.media.Media;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Post implements IPost{

    private static String TAG = Post.class.getName();

    @SerializedName("node")
    @Expose
    private Node__ node;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @SerializedName("text")
    @Expose
    private String text;


    public Post(Node__ node, String _text) {
        this.node = node;
        this.text = _text;
    }


    public Node__ getNode() {
        return node;
    }

    public void setNode(Node__ node) {
        this.node = node;
    }


    @Override
    public Media convertToMedia() {
        Media media = new Media();

        media.setDate(node.getTaken_at_timestamp());
        media.setCount_like(node.getEdge_media_preview_like().getCount());
        if(node.getVideo_view_count() != null) media.setCount_views(node.getVideo_view_count());
        media.setCount_comments(node.getEdge_media_to_comment().getCount());
        media.setText(text);
        media.setPic_url(node.getDisplay_url());
        media.setShortCode(node.getShortcode());

        return media;
    }
}
