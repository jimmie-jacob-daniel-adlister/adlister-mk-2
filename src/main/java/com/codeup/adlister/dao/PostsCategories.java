package com.codeup.adlister.dao;

import com.codeup.adlister.models.PostCategories;

import java.util.ArrayList;

public interface PostsCategories {
    ArrayList<PostCategories> findByPostId(long postId);
    void insert(PostCategories postCategories);
    void delete(Long postId);

}
