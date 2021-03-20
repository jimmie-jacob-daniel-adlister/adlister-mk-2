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
        String username=request.getParameter("username");
        if (request.getSession().getAttribute("user") == null && username==null){
            response.sendRedirect("/login");
            return;
        }
        User user = new User();
        if (username!=null){
            user = DaoFactory.getUsersDao().findByUsername(username);
        } else {
             user = (User) request.getSession().getAttribute("user");
        }
        System.out.println(user.getUsername());
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action   = request.getParameter("action");
        String adNumber = request.getParameter("adNumber");
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
