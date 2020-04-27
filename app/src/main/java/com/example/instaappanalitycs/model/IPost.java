package com.example.instaappanalitycs.model;

import com.example.instaappanalitycs.model.api.Owner;

import java.io.IOException;
import java.util.List;

public interface IPost {
    void getComments(String after);
    void getLikers(String after) throws IOException;
    List<Owner> getCommentsList();
    List<Owner> getLikersList();
}
