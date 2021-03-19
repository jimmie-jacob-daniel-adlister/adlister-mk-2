package com.codeup.adlister.models;

public class Category {
    private long id;
    private String category;

    public Category(long id, String category){
        this.id = id;
        this.category = category;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}