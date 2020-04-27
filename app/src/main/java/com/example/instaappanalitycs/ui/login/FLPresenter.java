package com.example.instaappanalitycs.ui.login;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import androidx.annotation.RequiresApi;

import com.example.instaappanalitycs.MainActivity;
import com.example.instaappanalitycs.R;
import com.example.instaappanalitycs.api.ApiServices;
import com.example.instaappanalitycs.model.GetUname;
import com.example.instaappanalitycs.model.api.GetUnameResponse;
import com.example.instaappanalitycs.model.user.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.Realm;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FLPresenter implements FLContract.Presenter {

    private static String TAG = FLPresenter.class.getName();
    private ConnectivityManager connMgr;
    private Context _context;
    private FLContract.View _view;
    private Realm mRealm;

    private MainActivity activity;

    public FLPresenter(Context context, FLContract.View view) {

        _context = context;
        activity = (MainActivity) context;
        _view = view;
        mRealm = Realm.getDefaultInstance();
    }

    @Override
    public void getUname(String uid) {
        //получаем информауию о пользователе по ари инстаграм
        if (!isConnect()) return;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        GetUname getUname = new GetUname();
        getUname.setUser_id(uid);
        getUname.setInclude_chaining((false));
        getUname.setInclude_reel((true));
        getUname.setInclude_suggested_users(false);
        getUname.setInclude_logged_out_extras(false);
        getUname.setInclude_highlight_reels(false);
        getUname.setInclude_related_profiles(false);

        String json_variable = gson.toJson(getUname);
        CookieSyncManager.getInstance().sync();
        String cookie = CookieManager.getInstance().getCookie("https://www.instagram.com/");

        Observable<GetUnameResponse> observable = new ApiServices().getApi().GetUserName("c9100bf9110dd6361671f113dd02e7d6",
                json_variable, cookie);
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<GetUnameResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        //TODO  нужно бужкт обработать отсутствие интернета
                    }

                    @Override
                    public void onNext(GetUnameResponse responseBody) {
                        try {
                            User user = responseBody.copyToUser();
                            loginSuccess(user);
                        } catch (Exception e) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                });

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void checkInternetConnection() {
        if(isConnect()) _view.loadWebView();
        else initListenerInternetConnection();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void initListenerInternetConnection() {
        // создаем листенер для отслеживания подключения к интернету
        _view.connectionFailed();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                _view.conectionSuccess();
                _view.loadWebView();
            }

            @Override
            public void onLost(Network network) {
                _view.connectionFailed();
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connMgr.registerDefaultNetworkCallback(networkCallback);
        } else {
            NetworkRequest request = new NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET).build();
            connMgr.registerNetworkCallback(request, networkCallback);
        }

    }

    @Override
    public void loginSuccess(User user) {
        Log.d(TAG, "login success  " + user.getUname());
        mRealm.beginTransaction();
        User realm_user = mRealm.createObject(User.class);
        realm_user.setProfile_pic(user.getProfile_pic());
        realm_user.setUid(user.getUid());
        realm_user.setUname(user.getUname());
        mRealm.commitTransaction();

        activity.startFragment(R.id.nav_gallery);
    }

    @Override
    public void clouseAll() {
        mRealm.close();
    }

    private boolean isConnect() {
        // проверяеи на подключение к интернету
        connMgr = (ConnectivityManager)
                _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo == null) return false;
        else return networkInfo.isConnected();
    }

}
