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

import com.example.instaappanalitycs.api.ApiServices;
import com.example.instaappanalitycs.model.api.media.ResponseMedia;
import com.example.instaappanalitycs.model.api.userinfo.ResponseUserInfoA1;
import com.example.instaappanalitycs.model.user.User;
import com.example.instaappanalitycs.ui.login.FLContract;
import com.example.instaappanalitycs.ui.worker.ICContract;
import com.example.instaappanalitycs.ui.worker.InternetConnection;

import java.util.ArrayList;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InfoPresenter implements ICContract, InfoContract.Presenter {

    private static String TAG = InfoPresenter.class.getName();

    private Context _context;
    private InfoContract.View _view;
    private Realm mRealm;
    private ConnectivityManager connMgr;
    private InternetConnection workerInternet;
    private View _snackView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InfoPresenter(Context context, InfoContract.View view, View snackView) {

        _context = context;
        _view = view;
        _snackView = snackView;
        mRealm = Realm.getDefaultInstance();
        workerInternet = new InternetConnection(context, this, snackView);
    }

    @Override
    public void getData() {
        Observable.create(e ->{
            User user = mRealm.where(User.class).findFirstAsync();
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
                                getFeed("");
                                String s = "";
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
        });

    }

    @Override
    public void getFeed(String next) {
        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");

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
                            //String resp = responseBody.string();
                            ResponseMedia resp = responseBody;

                            String s = "";
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
