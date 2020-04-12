package com.example.instaappanalitycs.ui.login;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.example.instaappanalitycs.R;
import com.example.instaappanalitycs.model.api.AuthUser;
import com.google.android.material.snackbar.Snackbar;

public class FragmentLogin extends Fragment implements FLContract.View {
    private static String TAG = FragmentLogin.class.getName();
    private FLPresenter _presenter;


    private WebView webView;
    private  View root;
    private CoordinatorLayout constraintLayout;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_login, container, false);
        constraintLayout = (CoordinatorLayout) root.findViewById(R.id.cl);
        webView = root.findViewById(R.id.wv);
        webView.setVisibility(View.VISIBLE);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);


        if(_presenter == null) _presenter = new FLPresenter(this.getContext(), this);
        _presenter.checkInternetConnection();

        return root;
    }


    @Override
    public void loadWebView() {
        Log.d(TAG, "start load webview");
        webView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
            }

            public void onPageFinished(WebView view, String url) {

                String cookie = CookieManager.getInstance().getCookie(url);
                if (cookie == null || !cookie.contains("sessionid")) {
                    String cookies = CookieManager.getInstance().getCookie(url);
                    Log.d(TAG, "userr is not authorized");
                    webView.setVisibility(View.VISIBLE);

                } else {
                    webView.loadUrl("https://instagram.com/koverko_dev");
                    CookieSyncManager.getInstance().sync();
                    String cookies = CookieManager.getInstance().getCookie(url);
                    Log.d(TAG, "All the cookies in a string:" + cookies);
                    AuthUser user = new AuthUser(cookie);
                    _presenter.getUname(user.getDs_user_id());
                    webView.setVisibility(View.GONE);
                    webView.destroy();
                    webView.onPause();
                    return;
                }


            }
        });
        webView.loadUrl("https://instagram.com/accounts/login/?hl-ru");
    }

    @Override
    public void connectionFailed() {
        Log.d(TAG, "connection failed");
        Snackbar.make(constraintLayout, constraintLayout.getContext().getString(R.string.err_connection_internet), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void conectionSuccess() {
        Log.d(TAG, "connection success");
        Snackbar.make(constraintLayout, constraintLayout.getContext().getString(R.string.suc_connection_internet), Snackbar.LENGTH_SHORT).show();
    }
}