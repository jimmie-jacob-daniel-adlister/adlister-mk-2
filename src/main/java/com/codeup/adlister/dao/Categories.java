package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public interface Categories {
    Long insert(User user);
    List<Category> all();
}