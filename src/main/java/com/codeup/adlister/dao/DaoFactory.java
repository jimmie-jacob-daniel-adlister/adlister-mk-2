package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.*;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Comments commentsDao;
    private static Config config = new Config();
    private static Images imagesDao;
    private static PostsCategories postsCategoriesDao;
    private static Categories categoryDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    public static Categories getCategoryDao() {
        if (categoryDao == null) {
            categoryDao = new MySQLCategoriesDao(config);
        }
        return categoryDao;
    }

    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Comments getCommentsDao() {
        if (commentsDao == null) {
            commentsDao = new MySQLCommentsDao(config);
        }
        return commentsDao;
    }

    public static Images getImagesDao() {
        if (imagesDao == null) {
            imagesDao = new MySQLImagesDao(config);
        }
        return imagesDao;
    }

    public static PostsCategories getPostsCategoriesDao(){
        if (postsCategoriesDao==null){
            postsCategoriesDao= new MySQLPostsCategoriesDao(config);
        }
        return postsCategoriesDao;
    }

}
