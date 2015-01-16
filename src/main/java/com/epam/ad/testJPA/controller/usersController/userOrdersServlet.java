package com.epam.ad.testJPA.controller.usersController;

import com.epam.ad.testJPA.crud.JPAService;
import com.epam.ad.testJPA.crud.OrderJPAService;
import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.OrderEntity;
import com.epam.ad.testJPA.entity.UserEntity;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


@WebServlet("userOrderServlet")
public class userOrdersServlet extends HttpServlet {
    @Inject
    UserJPAService service;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserEntity userEntity=service.get(Integer.parseInt(id));
        List<OrderEntity> orderEntities= (List<OrderEntity>) service.getById(Integer.parseInt(id), "uid").getOrdersById();
        request.setAttribute("list",orderEntities);
        request.setAttribute("id",id);
        request.setAttribute("username",userEntity.getUsername());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/orders.jsp");
        requestDispatcher.forward(request, response);

    }
}
