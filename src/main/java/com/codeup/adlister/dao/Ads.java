package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    //delete a selected ad
    void delete(Long postId);

    void edit(Ad ad);

    List<Ad> search(String term);

    List<Ad> byId(long id);

    Ad getAdFromPostId(Long postId);

}
