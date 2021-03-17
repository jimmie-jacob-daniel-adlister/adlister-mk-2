package com.codeup.adlister.dao;

import com.codeup.adlister.models.Comment;

import java.util.List;

public interface Comments {
    List<Comment> all(int postId);
//    all comments made on an ad

    Comment addComment(Comment newComment);
}
