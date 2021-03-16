package com.codeup.adlister.dao;

import com.codeup.adlister.models.PostCategories;

import java.util.ArrayList;

public interface PostsCategories {
    ArrayList<PostCategories> findByPostId(long postId);
    long insert(PostCategories postCategories);
}
