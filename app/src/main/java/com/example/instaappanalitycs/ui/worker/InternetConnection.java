package com.example.instaappanalitycs.ui.worker;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;

import com.example.instaappanalitycs.R;
import com.google.android.material.snackbar.Snackbar;

public class InternetConnection extends Presenter{

    private static String TAG = InternetConnection.class.getName();

    private ConnectivityManager connMgr;
    private Context _context;
    private View _snackView;
    private ICContract _view;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InternetConnection(Context context, ICContract view, View snackView) {

        _context = context;
        _view = view;
        _snackView = snackView;
        checkInternetConnection();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    void checkInternetConnection() {
        connMgr = (ConnectivityManager)
                _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if(networkInfo != null && networkInfo.isConnected()) _view.getData();
        else initListenerInternetConnection();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    void initListenerInternetConnection() {
        connectionFailed();
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                conectionSuccess();
                _view.getData();
            }

            @Override
            public void onLost(Network network) {
                connectionFailed();
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
    void connectionFailed() {
        Log.d(TAG, "connection failed");
        Snackbar.make(_snackView, _snackView.getContext().getString(R.string.err_connection_internet), Snackbar.LENGTH_SHORT).show();
    }

    @Override
    void conectionSuccess() {
        Log.d(TAG, "connection success");
        Snackbar.make(_snackView, _snackView.getContext().getString(R.string.suc_connection_internet), Snackbar.LENGTH_SHORT).show();
    }
}
