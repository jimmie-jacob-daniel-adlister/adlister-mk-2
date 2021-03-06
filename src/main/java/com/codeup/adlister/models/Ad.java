package com.codeup.adlister.models;

import java.util.ArrayList;
import java.util.List;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;



    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    private ArrayList<PostCategories> categories;
    private List<Comment> comments;
    private ArrayList<Image> images;



    private double price;

    public Ad(long id, long userId, String title, String description) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
    public Ad(long id, long userId, String title, String description, double price) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price=price;
    }

    public Ad(long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }
    public Ad(long userId, String title, String description, double price) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.price=price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<PostCategories> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<PostCategories> categories) {
        this.categories = categories;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<Image> getImages() {
        return images;
    }
}
