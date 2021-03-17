package com.codeup.adlister.models;

public class Image {
    private long id;
    private long postId;
    private String url;
    private String description;

    public Image(){};
    public Image(long id, long postId, String url, String description){
        this.id=id;
        this.postId=postId;
        this.url=url;
        this.description=description;
    }
    public Image( long postId, String url, String description){
        this.postId=postId;
        this.url=url;
        this.description=description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
