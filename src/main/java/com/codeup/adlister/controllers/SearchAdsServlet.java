package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Comment;
import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.PostCategories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "SearchAdsServlet", urlPatterns = "/search")
public class SearchAdsServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String term = request.getParameter("term");
        
        List<Ad> ads = DaoFactory.getAdsDao().search(term);
        List<Category> categoriesList = DaoFactory.getCategoryDao().all();
        for(Ad ad : ads){
            long postId=ad.getId();
            ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
            ad.setCategories(categories);
            ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
            ad.setImages(images);
            int commentsId= (int) postId;
            List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
            ad.setComments(comments);
        };

        request.setAttribute("ads", ads);
        request.setAttribute("categories", categoriesList);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
