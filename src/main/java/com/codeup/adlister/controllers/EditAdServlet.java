package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "EditAdServlet", urlPatterns = "/edit-ad")
public class EditAdServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        request.getRequestDispatcher("/WEB-INF/edit-ad.jsp");
    }
}
