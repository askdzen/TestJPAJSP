package com.epam.ad.testJPA.controller;


import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.UserEntity;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("registration")
public class registrationServlet extends HttpServlet {
    @Inject
    UserJPAService service;
    @Inject
    UserEntity userEntity;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userEntity.setUsername(request.getParameter("username"));
        userEntity.setPassword(request.getParameter("password"));
        userEntity.setFirstName(request.getParameter("firstName"));
        userEntity.setLastName(request.getParameter("lastName"));
        userEntity.setEmail(request.getParameter("email"));
        service.add(userEntity);
        request.setAttribute("successfully","You have successfully registered!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
        requestDispatcher.forward(request, response);
    }
}
