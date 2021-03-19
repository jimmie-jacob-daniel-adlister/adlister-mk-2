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

@WebServlet(name = "PostServlet", urlPatterns = "/post")
public class PostServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 6442268910383688327L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String idInput = request.getParameter("id");
            long id = Long.valueOf(idInput);
    
    
            List<Ad> posts = DaoFactory.getAdsDao().byId( (long) id);
            for(Ad ad : posts){
                long postId=ad.getId();
                ArrayList<PostCategories> categories = DaoFactory.getPostsCategoriesDao().findByPostId(postId);
                ad.setCategories(categories);
                ArrayList<Image> images = DaoFactory.getImagesDao().findByPostId(postId);
                ad.setImages(images);
                int commentsId= (int) postId;
                List<Comment> comments=DaoFactory.getCommentsDao().all(commentsId);
                ad.setComments(comments);
            };
    
            request.setAttribute("post", posts.get(0));
            
    
            request.getRequestDispatcher("/WEB-INF/post.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("error", "Post not found");
            request.getRequestDispatcher("/WEB-INF/post.jsp").forward(request, response);
        }
        
    }
}
