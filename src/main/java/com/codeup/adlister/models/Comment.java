package com.codeup.adlister.models;

public class Comment {
    private int id;
    private int userId;
    private int postId;
    private String content;

    Comment(){

    }

    public Comment(int id, int userId, int postId, String content) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }

    public Comment(int userId, int postId, String content) {
        this.userId = userId;
        this.postId = postId;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return this.id;
    }

    public int getUserId() {
        return this.userId;
    }

    public int getPostId() {
        return this.postId;
    }

    public String getContent() {
        return this.content;
    }
}