package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);
    List<Ad> allUserAds(Long UserId);
    String findByUserId(Long userId);
}

