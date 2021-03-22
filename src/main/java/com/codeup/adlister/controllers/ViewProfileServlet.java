package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.*;
import com.mysql.cj.api.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //checks if user was passed in
        if(request.getParameter("username") != null){
            request.setAttribute("error", "No user specified");
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }

        //checks if youre not logged in
        if (request.getSession().getAttribute("user") == null ){
            request.setAttribute("error", "You are not logged in");
            response.sendRedirect("/login");
        }

        String username = request.getParameter("username");
        
        try{
            User user = DaoFactory.getUsersDao().findByUsername(username);

            List<Ad> ads = DaoFactory.getUsersDao().allUserAds(user.getId());
            for(Ad ad : ads){
                long postId=ad.getId();
                System.out.println(postId);
                ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
                ad.setCategories(categories);
                ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
                ad.setImages(images);
                int commentsId= (int) postId;
                List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
                ad.setComments(comments);
            };
            request.setAttribute("ads", ads);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

        }catch(Exception e){
            request.setAttribute("error", e.toString());
            //if the request fails to grab a profile by a username, fallback to your own user
            if(request.getSession().getAttribute("user") != null){
                //sets the user session to be the attribute for user. 
                request.setAttribute("user", request.getSession().getAttribute("user"));

                List<Ad> ads = DaoFactory.getUsersDao().allUserAds(user.getId());
                for(Ad ad : ads){
                    long postId=ad.getId();
                    System.out.println(postId);
                    ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
                    ad.setCategories(categories);
                    ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
                    ad.setImages(images);
                    int commentsId= (int) postId;
                    List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
                    ad.setComments(comments);
                };
                request.setAttribute("ads", ads);
                request.setAttribute("user", user);
                request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
            }
        }

        
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String action   = request.getParameter("action");
        String adNumber = request.getParameter("adNumber");

        if(action == null || adNumber == null){
            request.setAttribute("error", "Error with request, ad not found.");
            request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
        }

        //checks the action and ad you are working on
        if (action.equalsIgnoreCase("delete")){
            DaoFactory.getAdsDao().delete(Long.parseLong(adNumber));
        } else if (action.equalsIgnoreCase("edit")){
            request.getSession().setAttribute("edit", Long.parseLong(adNumber));
            System.out.println("Sending it over to edit");
            response.sendRedirect("/edit");
            return;
        }
        System.out.println(action+" " + adNumber);
        response.sendRedirect("/profile");
    }
}
