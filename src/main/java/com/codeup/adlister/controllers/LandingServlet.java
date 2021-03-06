package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Comment;
import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.PostCategories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "LandingServlet", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Ad> ads = DaoFactory.getAdsDao().all();
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

        String category = request.getParameter("category");
        ArrayList<Ad> filteredAds= new ArrayList<>();
        if (category!= null){
            if (category.equalsIgnoreCase("all")){
                for (Ad ad : ads){
                    filteredAds.add(ad);
                }
            } else {
                for (Ad ad : ads) {
                    ArrayList<PostCategories> adCategories = ad.getCategories();
                    int counter = 0;
                    for (PostCategories categories : adCategories) {
                        if (categories.getCategory().equalsIgnoreCase(category)) {
                            counter++;
                        }
                    }
                    if (counter > 0) {
                        System.out.println(ad.getTitle());
                        filteredAds.add(ad);
                    }
                }
            }
        } else{
            for (Ad ad : ads){
                filteredAds.add(ad);
            }
        }


        request.setAttribute("ads", filteredAds);
        request.setAttribute("categories", categoriesList);
        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);

    }
}
