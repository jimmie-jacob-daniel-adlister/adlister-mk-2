package com.codeup.adlister.models;

public class Comment {
    private long id;
    private long userId;
    private long postId;
    private String content;

    Comment(){

    }

    public Comment(long id, long userId, long postId, String content) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }


    public Comment(long userId, long postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }


    public void setId(long id) {
        this.id = id;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return this.id;
    }

    public long getUserId() {
        return this.userId;
    }

    public long getPostId() {
        return this.postId;
    }

    public String getContent() {
        return this.content;
    }

}


