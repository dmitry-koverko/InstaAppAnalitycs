package com.example.instaappanalitycs.ui.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.instaappanalitycs.R;

public class InfoFragment extends Fragment implements InfoContract.View{

    private  View root;
    private View snackView;
    private InfoPresenter _presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_info, container, false);
        snackView = root.findViewById(R.id.info_cl);
        if(_presenter == null) _presenter = new InfoPresenter(getContext(), this, snackView);
        return root;
    }
}