package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String register = request.getParameter("register");
        if (register==null){
            register="";
        }
        if (register.equals("register")){
            response.sendRedirect("/register");
            return;
        }
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }
        Boolean validRegister=false;
        User user=DaoFactory.getUsersDao().findByUsername(username);
            if (user==null){
                System.out.println("password: "+password);
                String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt());
                System.out.println("hashedPassword: "+hashedPassword);
                User newUser=new User(username, email, hashedPassword);
                DaoFactory.getUsersDao().insert(newUser);
                validRegister=true;
            }
            if (validRegister){
                response.sendRedirect("/login");
            } else{
                request.getSession().setAttribute("invalid", "Username taken, try again!");
                response.sendRedirect("/register");            }
        }

//        // create and save a new user
//        User user = new User(username, email, password);
//        DaoFactory.getUsersDao().insert(user);
//        response.sendRedirect("/login");


        //String username = request.getParameter("username");
        //        String email = request.getParameter("email");
        //        String password = request.getParameter("password");
        //        String passwordConfirmation = request.getParameter("confirm_password");
        //
        //        // validate input
        //        boolean inputHasErrors = username.isEmpty()
        //            || email.isEmpty()
        //            || password.isEmpty()
        //            || (! password.equals(passwordConfirmation));
        //
        //        if (inputHasErrors) {
        //            response.sendRedirect("/register");
        //            return;
        //        }
        //
        //        // create and save a new user
        //        String hashedPassword= BCrypt.hashpw(password, BCrypt.gensalt());
        //        User user = new User(username, email, hashedPassword);
        //        DaoFactory.getUsersDao().insert(user);
        //        response.sendRedirect("/login");
}
