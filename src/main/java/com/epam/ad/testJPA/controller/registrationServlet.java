package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.UserInfoJPAService;
import com.epam.ad.testJPA.entity.UserInfoEntity;

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
    UserInfoJPAService service;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfoEntity> list=service.getAll();
        UserInfoEntity userInfoEntity=new UserInfoEntity();
        userInfoEntity.setFirstName("Askar");
        userInfoEntity.setLastName("Dzen");
        userInfoEntity.setEmail("ffdg");
        service.add(userInfoEntity);
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
        requestDispatcher.forward(request, response);
    }
}
