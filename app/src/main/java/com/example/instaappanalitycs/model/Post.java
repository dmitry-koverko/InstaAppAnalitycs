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

    @SerializedName("list_comments")
    @Expose
    private List<Owner> list_comments = new ArrayList<>();

    @SerializedName("list_likers")
    @Expose
    private List<Owner> list_likers = new ArrayList<>();


    public Post(Node__ node) {
        this.node = node;
        list_comments = new ArrayList<>();
        list_likers = new ArrayList<>();
    }

    public Node__ getNode() {
        return node;
    }

    public void setNode(Node__ node) {
        this.node = node;
    }


    @Override
    public void getComments(String after) {
        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        VariableUserMedia variableUserMedia = new VariableUserMedia();
        variableUserMedia.setFirst(50);
        variableUserMedia.setShortcode(node.getShortcode());
        variableUserMedia.setAfter(after);
        String json_variable = gson.toJson(variableUserMedia);

        Observable<ResponseMediaComments> observable = new ApiServices().getApi().GetMediaComments("bc3296d1ce80a24b1b6e40b1e72903f5",
                json_variable, cookie);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseMediaComments>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseMediaComments responseMediaComments) {
                        ResponseMediaComments resp = responseMediaComments;
                        Page_info page_info = resp.getData().getShortcodeMedia().getEdgeMediaToParentComment().getPageInfo();

                        for (EdgeComment edge: resp.getData().getShortcodeMedia().getEdgeMediaToParentComment().getEdges()
                        ) {
                            Log.d(TAG, edge.getNode().getText() + "  " + edge.getNode().getOwner().getUsername());
                        }

                        if(page_info.isHas_next_page()){
                            getComments(page_info.getEnd_cursor());
                        }
                    }
                });
    }

    @Override
    public void getLikers(String after) throws IOException {

        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        VariableUserMedia variableUserMedia = new VariableUserMedia();
        variableUserMedia.setFirst(50);
        variableUserMedia.setShortcode(node.getShortcode());
        variableUserMedia.setAfter(after);
        String json_variable = gson.toJson(variableUserMedia);

        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        Call<List<Post>> call = gitHubService.repoContributors("square", "retrofit");
        List<Post> result = call.execute().body();

        Observable<ResponseMediaComments> observable = new ApiServices().getApi().GetMediaComments("d5d763b1e2acf209d62d22d184488e57",
                json_variable, cookie);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseMediaComments>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseMediaComments responseMediaComments) {
                        ResponseMediaComments resp = responseMediaComments;
                        Page_info page_info = resp.getData().getShortcodeMedia().getEdgeLikedBy().getPageInfo();

                        for (Edge edge: resp.getData().getShortcodeMedia().getEdgeLikedBy().getEdges()
                        ) {
                            Log.d(TAG, "liked post  "+ edge.getNode().getShortcode() + "  " + edge.getNode().getOwner().getUsername());
                        }

                        if(page_info.isHas_next_page()){
                            try {
                                getLikers(page_info.getEnd_cursor());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    @Override
    public List<Owner> getCommentsList() {
        return list_comments;
    }

    @Override
    public List<Owner> getLikersList() {
        return list_likers;
    }
}
