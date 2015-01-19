package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.RoleJPAService;
import com.epam.ad.testJPA.entity.RoleEntity;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/",
        "admin"})
public class StartServlet extends HttpServlet {
    @Inject
    RoleEntity roleEntity;
    @Inject
    RoleJPAService service;
    @Inject
    Logger logger;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (request.getServletPath().equals("/admin")){
           List<RoleEntity> roles = service.getAll();
           request.setAttribute("roles",roles);
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
           requestDispatcher.forward(request, response);
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info(request.getContextPath());

        if (request.getServletPath().equals("/")){
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        requestDispatcher.forward(request, response);
    }

    }
        }
