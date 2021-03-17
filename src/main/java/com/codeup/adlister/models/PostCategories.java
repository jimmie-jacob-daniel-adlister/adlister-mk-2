package com.codeup.adlister.models;

public class PostCategories {
    private long postId;
    private long categoryId;



    private String category;

    public PostCategories(){};
    public PostCategories(long postId, long categoryId, String category){
        this.postId=postId;
        this.categoryId=categoryId;
        this.category=category;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



}
