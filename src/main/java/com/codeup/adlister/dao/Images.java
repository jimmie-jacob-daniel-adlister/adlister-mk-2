package com.codeup.adlister.dao;

import com.codeup.adlister.models.Image;

import java.util.ArrayList;
import java.util.List;

public interface Images {
    ArrayList<Image> findByPostId(long postId);
    Long insert(Image image);
    void edit(Image image);
}
