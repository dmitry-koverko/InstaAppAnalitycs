package com.example.instaappanalitycs.ui.media;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.instaappanalitycs.R;

public class MediaFragment extends Fragment implements MediaContract.View{

    private View root;
    private MediaPresenter _presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        if(_presenter == null) _presenter = new MediaPresenter(getContext(), this);
        return root;
    }
}