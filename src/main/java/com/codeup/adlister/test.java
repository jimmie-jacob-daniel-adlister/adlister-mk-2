package com.codeup.adlister;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Comment;
import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
//        User jimmie = new User("jimmie", "jimmie@gmail.com", "password");
//        DaoFactory.getUsersDao().insert(jimmie);
        User user=DaoFactory.getUsersDao().findByUsername("jimmie");
        System.out.println(user.getUsername());
//        Ad ad = new Ad(1, "Couch for sale!", "Used leather couch, still in good shape", 49.99);
//        System.out.println(DaoFactory.getAdsDao().insert(ad));
        List<Ad> ads = DaoFactory.getAdsDao().all();
        for(Ad ad : ads){
            System.out.println(ad.getTitle());
            System.out.println(ad.getDescription());
            System.out.println(ad.getUserId());
            System.out.println(ad.getPrice());
        };
        Comment comment = new Comment(1,1, "Looks dope, can we meet up?");
        DaoFactory.getCommentsDao().addComment(comment);










    }
}
