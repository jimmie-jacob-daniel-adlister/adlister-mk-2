package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Comment;
import com.codeup.adlister.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "CreateCommentServlet", urlPatterns = "/create-comment")
public class CreateCommentServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        request.getRequestDispatcher("/WEB-INF/create-comment.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        Comment newComment = new Comment(
                user.getId(),
                user.getId(),
                request.getParameter("content")
        );
        DaoFactory.getCommentsDao().addComment(newComment);
        response.sendRedirect("/ads");
    }
}