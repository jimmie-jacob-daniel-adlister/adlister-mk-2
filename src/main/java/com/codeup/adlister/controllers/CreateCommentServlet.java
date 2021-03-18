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

@WebServlet (name = "CreateCommentServlet", urlPatterns = "/add-comment")
public class CreateCommentServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long postId = (Long)request.getSession().getAttribute("postId");
        System.out.println("get "+postId);
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = DaoFactory.getAdsDao().getAdFromPostId(postId);
        ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
        ad.setCategories(categories);
        ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
        ad.setImages(images);
        String postIdString=postId.toString();
        int commentId=Integer.parseInt(postIdString);
        List<Comment> comments=DaoFactory.getCommentsDao().all(commentId);
        ad.setComments(comments);
        request.setAttribute("ad", ad);

//        Comment newComment = new Comment(
//                user.getId(),
//                user.getId(),
//                request.getParameter("content")
//        );
//        DaoFactory.getCommentsDao().addComment(newComment);
        request.getRequestDispatcher("/WEB-INF/add-comment.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long postId=Long.parseLong(request.getParameter("postId"));
        request.getSession().setAttribute("postId", postId);
        System.out.println("post "+postId);



//        Comment newComment = new Comment(
//                user.getId(),
//                user.getId(),
//                request.getParameter("content")
//        );
//        DaoFactory.getCommentsDao().addComment(newComment);
       response.sendRedirect("/add-comment");
    }
}