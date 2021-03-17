package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (name = "LandingServlet", urlPatterns = "/")
public class LandingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        request.getRequestDispatcher("/WEB-INF/index.jsp");
    }
}
