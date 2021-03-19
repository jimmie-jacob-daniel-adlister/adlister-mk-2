package com;

import java.util.List;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Category;

public class cat {
    public static void main(String[] args) {
        List<Category> ads = DaoFactory.getCategoryDao().all();
        System.out.println(ads);
    }
}
