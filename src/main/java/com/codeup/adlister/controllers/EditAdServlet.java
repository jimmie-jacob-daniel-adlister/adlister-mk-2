package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        Long adNumber= (Long) request.getSession().getAttribute("edit");
        Ad ad = DaoFactory.getAdsDao().getAdFromPostId(adNumber);
        long postId=ad.getId();
        System.out.println(postId);
        ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
        ad.setCategories(categories);
        ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
        ad.setImages(images);
        request.setAttribute("ad", ad);
        request.setAttribute("action", "Edit");
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                Double.parseDouble(request.getParameter("price"))
        );
        Long postId=DaoFactory.getAdsDao().insert(ad);
        Image image = new Image(
                postId,
                request.getParameter("imageURL"),
                request.getParameter("imageDescription")
        );
        DaoFactory.getImagesDao().insert(image);
        response.sendRedirect("/");
    }




}
