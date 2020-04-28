package com.example.instaappanalitycs.ui.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import androidx.annotation.RequiresApi;

import com.example.instaappanalitycs.TopLikersObject;
import com.example.instaappanalitycs.api.ApiServices;
import com.example.instaappanalitycs.model.Post;
import com.example.instaappanalitycs.model.PostListObject;
import com.example.instaappanalitycs.model.Progress;
import com.example.instaappanalitycs.model.TopComments;
import com.example.instaappanalitycs.model.TopCommentsObject;
import com.example.instaappanalitycs.model.VariableUserMedia;
import com.example.instaappanalitycs.model.api.ShortCode;
import com.example.instaappanalitycs.model.api.media.Edge;
import com.example.instaappanalitycs.model.api.media.Page_info;
import com.example.instaappanalitycs.model.api.media.ResponseMedia;
import com.example.instaappanalitycs.model.api.media.ResponseMediaComments;
import com.example.instaappanalitycs.model.api.userinfo.ResponseUserInfoA1;
import com.example.instaappanalitycs.model.media.FeedObject;
import com.example.instaappanalitycs.model.media.Media;
import com.example.instaappanalitycs.model.user.User;
import com.example.instaappanalitycs.model.user.UserInfo;
import com.example.instaappanalitycs.ui.login.FLContract;
import com.example.instaappanalitycs.ui.worker.ICContract;
import com.example.instaappanalitycs.ui.worker.InternetConnection;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InfoPresenter implements ICContract, InfoContract.Presenter {

    private static String TAG = InfoPresenter.class.getName();
    private int progress_media;
    private List<Post> postList;

    private Context _context;
    private InfoContract.View _view;
    private Realm mRealm;
    private ConnectivityManager connMgr;
    private InternetConnection workerInternet;
    private View _snackView;
    private UserInfo userInfo;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference progress_comments;
    private DatabaseReference progress_likers;
    private DatabaseReference top_likers;
    private DatabaseReference top_comments;
    private DatabaseReference info_user;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InfoPresenter(Context context, InfoContract.View view, View snackView) {
        Log.d(TAG, "start constructor " + TAG);
        progress_media = 0;
        postList = new ArrayList<>();
        _context = context;
        _view = view;
        _snackView = snackView;
        mRealm = Realm.getDefaultInstance();
        workerInternet = new InternetConnection(context, this, snackView);
        userInfo = new UserInfo();
    }

    @Override
    public void getData() {

        User user = mRealm.where(User.class).findFirst();
        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");

        Observable<ResponseUserInfoA1> observable = new ApiServices().getApi().GetUserInfo(user.getUname(), cookie);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseUserInfoA1>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseUserInfoA1 responseBody) {
                        try {
                            ResponseUserInfoA1 resp = responseBody;
                            getFeed("", resp.getGraphql().getUser().getEdgeOwnerToTimelineMedia().getCount());
                            userInfo.setCount_following(resp.getGraphql().getUser().getEdgeFollow().getCount());
                            userInfo.setCount_followers(resp.getGraphql().getUser().getEdgeFollowedBy().getCount());
                            String s = "";
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    @Override
    public void clouse() {
        mRealm.close();
    }

    @Override
    public void addListenersFirebase() {
        User user = mRealm.where(User.class).findFirst();

        ValueEventListener listenerProgress_comments = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Progress progress = dataSnapshot.getValue(Progress.class);
                if(progress.isProgress()) Log.d(TAG, "progress comments = " + progress.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        progress_comments = database.getReference("users/"+  user.getUid()+ "/top_comments");
        progress_comments.addValueEventListener(listenerProgress_comments);

        ValueEventListener listenerProgress_likes = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Progress progress = dataSnapshot.getValue(Progress.class);
                if(progress.isProgress()) Log.d(TAG, "progress likes = " + progress.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        progress_likers = database.getReference("users/"+  user.getUid()+ "/top_likers");
        progress_likers.addValueEventListener(listenerProgress_likes);

        List<TopComments> listtopLikers = new ArrayList<>();
        ValueEventListener listenerProgress_top_likers = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot usersSnapshot : dataSnapshot.getChildren()){

                    TopComments object = usersSnapshot.getValue(TopComments.class);
                    if(object != null)
                    {
                        listtopLikers.add(object);
                    }
                }

                addToRealmTopLikers(listtopLikers);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        top_likers = database.getReference("users/"+  user.getUid()+ "/info/top_likers");
        top_likers.addValueEventListener(listenerProgress_top_likers);

        List<TopComments> listtopComments = new ArrayList<>();
        ValueEventListener listenerProgress_top_comments = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot usersSnapshot : dataSnapshot.getChildren()){
                    TopComments object = usersSnapshot.getValue(TopComments.class);
                    if(object != null)
                    {
                        listtopComments.add(object);
                    }
                }

                addToRealmTopCommetns(listtopComments);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };

        top_comments = database.getReference("users/"+  user.getUid()+ "/info/top_comments");
        top_comments.addValueEventListener(listenerProgress_top_comments);


    }

    @Override
    public void addDataToRealm() {
        mRealm.beginTransaction();
        UserInfo realm_userInfo = mRealm.createObject(UserInfo.class);
        realm_userInfo.convert(userInfo);
        mRealm.commitTransaction();
        testUI();
    }

    private void testUI(){
        UserInfo user_i = mRealm.where(UserInfo.class).findFirst();
        String d = "";
        Log.d(TAG, "                     -----------------------------     " + user_i.getCount_comments());
    }

    @Override
    public void getFeed(String next, int countMedia) {

        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");
        User user = mRealm.where(User.class).findFirst();

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        VariableUserMedia variableUserMedia = new VariableUserMedia();
        variableUserMedia.setId(String.valueOf(user.getUid()));
        //variableUserMedia.setId("313212819"); // izzi
        //variableUserMedia.setId("5356749985"); club
        //variableUserMedia.setId("3081775318"); //kristy
        //variableUserMedia.setId("1365290021"); //vika
        variableUserMedia.setFirst(50);
        variableUserMedia.setAfter(next);
        String json_variable = gson.toJson(variableUserMedia);

        Observable<ResponseMedia> observable = new ApiServices().getApi().GetUserMedia("6305d415e36c0a5f0abb6daba312f2dd",
                json_variable, cookie);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseMedia>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ResponseMedia responseBody) {
                        try {
                            ResponseMedia resp = responseBody;

                            Page_info page_info = resp.getData().getUser().getEdge_owner_to_timeline_media().getPage_info();
                            progress_media += resp.getData().getUser().getEdge_owner_to_timeline_media().getEdges().size();


                            for (Edge edge: responseBody.getData().getUser().getEdge_owner_to_timeline_media().getEdges()
                                 ) {
                                String text = "";
                                if(edge.getNode().getEdge_media_to_caption() != null && edge.getNode().getEdge_media_to_caption().getEdges().size() != 0)
                                     text = edge.getNode().getEdge_media_to_caption().getEdges().get(0).getNode().getText();
                                Post post = new Post(edge.getNode(), text);
                                postList.add(post);
                            }

                            Log.d(TAG, "progres media = " + progress_media + "  from  " + countMedia);
                            if(page_info.isHas_next_page()){
                                getFeed(page_info.getEnd_cursor(), countMedia);
                            }else {
                                Log.d(TAG, "-------FINISH--------");
                                generatePosts();
                                getCountsInfo();
                            }

                            String s = "";
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

    }

    @Override
    public void generatePosts() {
        int count_cmts = 0;
        PostListObject postListObject = new PostListObject();
        List<ShortCode> list = new ArrayList<>();
        User user = mRealm.where(User.class).findFirst();
        List<Media> mediaList = new ArrayList<>();

        for (Post p : postList
        ) {
            count_cmts += p.getNode().getEdge_media_to_comment().getCount();
            ShortCode shortCode = new ShortCode(p.getNode().getShortcode());
            Media m = p.convertToMedia();
            mediaList.add(m);
            Log.d(TAG, "media text = " + m.getText());
            list.add(shortCode);
        }
        addFeedToDB(mediaList);
        Log.d(TAG, "count commenta all =  " +count_cmts);
        postListObject.setId(String.valueOf(user.getUid()));
        postListObject.setList(list);

        getTop(postListObject);

    }

    @Override
    public void getTop(PostListObject postListObject) {

        addListenersFirebase();

        new Thread(new Runnable() {
            public void run() {
                Log.d(TAG, "run thread 1");
                Observable<String> observable = new ApiServices().getMyApi().getTopComments(postListObject);
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String responseMediaComments) {
                                String d = responseMediaComments;
                            }
                        });
            }
         }).start();

        new Thread(new Runnable() {
            public void run() {
                Log.d(TAG, "run thread 2");
                Observable<String> observable1 = new ApiServices().getMyApi().getTopLikers(postListObject);
                observable1.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Subscriber<String>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onNext(String responseMediaComments) {
                                String d = responseMediaComments;
                            }
                        });
            }
        }).start();
    }

    @Override
    public void getCountsInfo() {

        int count_view = 0;
        int count_likes = 0;
        int count_comments = 0;

        int count_photo = 0;
        int count_video = 0;
        int count_slider = 0;

        for (Post p : postList
        ) {
            try{

                count_likes += p.getNode().getEdge_media_preview_like().getCount();
                count_comments += p.getNode().getEdge_media_to_comment().getCount();
                if(p.getNode().getVideo_view_count() != null) count_view += p.getNode().getVideo_view_count();

                String type = p.getNode().get__typename();

                if(type.contains("GraphImage")) count_photo +=1;
                else if(type.contains("GraphSidecar")) count_slider += 1;
                else count_video += 1;

            }catch (Exception e){

            }

        }

        Log.d(TAG, "count_v = " + count_view + "  --- count_l = " + count_likes + "  -- count_c = " + count_comments);
        Log.d(TAG, "count_v = " + count_video + "  --- count_p = " + count_photo + "  -- count_s = " + count_slider);

        userInfo.setCount_comments(count_comments);
        userInfo.setCount_likes(count_likes);
        userInfo.setCount_views(count_view);
        userInfo.setCount_video(count_video);
        userInfo.setCount_photo(count_photo);
        userInfo.setCount_slider(count_slider);

        addDataToRealm();

    }

    @Override
    public void addToRealmTopLikers(List<TopComments> listLikers) {
        mRealm.beginTransaction();
        TopLikersObject realm_top_comments = mRealm.createObject(TopLikersObject.class);
        for (TopComments top: listLikers
             ) {
            final TopComments t = mRealm.copyToRealm(top);
            realm_top_comments.getTopComments().add(t);
        }
        mRealm.commitTransaction();
        testRTL();
    }

    private void testRTL() {
        TopLikersObject top = mRealm.where(TopLikersObject.class).findFirst();
        String d = "";
        Log.d(TAG, "       testRTL              -----------------------------     " + top.getTopComments().get(0));
    }

    @Override
    public void addToRealmTopCommetns(List<TopComments> listComments) {
        mRealm.beginTransaction();
        TopCommentsObject realm_top_comments = mRealm.createObject(TopCommentsObject.class);
        for (TopComments top: listComments
             ) {
            final TopComments t = mRealm.copyToRealm(top);
            realm_top_comments.getTopComments().add(t);
        }
        mRealm.commitTransaction();
        testRTC();
    }

    @Override
    public void addFeedToDB(List<Media> mediaList) {
        mRealm.beginTransaction();
        FeedObject feedObject = mRealm.createObject(FeedObject.class);

        for (Media m: mediaList
             ) {
            Media media  = mRealm.copyToRealm(m);
            feedObject.getMediaRealmList().add(media);
        }
        mRealm.commitTransaction();
    }



    private void testRTC() {
        TopCommentsObject top = mRealm.where(TopCommentsObject.class).findFirst();
        String d = "";
        Log.d(TAG, "          testRTC           -----------------------------     " + top.getTopComments().get(0));
    }

}
