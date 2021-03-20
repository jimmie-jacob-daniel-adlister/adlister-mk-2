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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.setAttribute("action", "Create");
        List<Category> categoriesList = DaoFactory.getCategoryDao().all();
        request.setAttribute("categories", categoriesList);
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action= request.getParameter("action");
        if (action.equals("Create")) {
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    Double.parseDouble(request.getParameter("price"))
            );
            Long postId = DaoFactory.getAdsDao().insert(ad);
            Image image = new Image(
                    postId,
                    request.getParameter("imageURL"),
                    request.getParameter("imageDescription")
            );
            DaoFactory.getImagesDao().insert(image);
            String[] categories=request.getParameterValues("categories");
            for (int i=0; i<categories.length; i++){
                PostCategories postCategories = new PostCategories(postId, (Long.parseLong(categories[i])+1));
                DaoFactory.getPostsCategoriesDao().insert(postCategories);
            }
            response.sendRedirect("/");
        } else{
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = new Ad(
                    Long.parseLong(request.getParameter("id")),
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description"),
                    Double.parseDouble(request.getParameter("price"))
            );
            Image image = new Image(
                    Long.parseLong(request.getParameter("imageId")),
                    Long.parseLong(request.getParameter("id")),
                    request.getParameter("imageURL"),
                    request.getParameter("imageDescription")
            );
            DaoFactory.getImagesDao().edit(image);
            DaoFactory.getAdsDao().edit(ad);

            String[] categories=request.getParameterValues("categories");
            Long postId= Long.parseLong(request.getParameter("id"));
            DaoFactory.getPostsCategoriesDao().delete(postId);
            for (int i=0; i<categories.length; i++){
                PostCategories postCategories = new PostCategories(postId, (Long.parseLong(categories[i])+1));
                DaoFactory.getPostsCategoriesDao().insert(postCategories);
            }
            response.sendRedirect("/profile");


        }
    }




}
