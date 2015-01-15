package com.epam.ad.testJPA.controller;


import com.epam.ad.testJPA.crud.JPAService;
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


@WebServlet("userEditServlet")
public class UserEditServlet extends HttpServlet {
    @Inject
    JPAService service;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String id = request.getParameter("id");
        UserEntity user =service.getBuId(Integer.parseInt(id));
        user.setUsername(username);
        user.setPassword(password);
        service.update(user);
        response.sendRedirect(request.getContextPath());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
//        UserEntity user = (UserEntity) service.em.createNamedQuery("User.findById").setParameter("userid", id).getSingleResult();
        UserEntity user = service.getBuId(Integer.parseInt(id));
        request.setAttribute("username",user.getUsername());
        request.setAttribute("password",user.getPassword());
        request.setAttribute("id",user.getId());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/userEdit.jsp");
        requestDispatcher.forward(request, response);
    }
}
