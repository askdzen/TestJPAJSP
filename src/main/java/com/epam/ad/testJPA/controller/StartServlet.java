package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.ItemJPAService;
import com.epam.ad.testJPA.crud.RoleJPAService;
import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.Role;
import com.epam.ad.testJPA.entity.User;
import com.epam.ad.testJPA.model.SignIn;
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
        "checkUsernamePassword"})
public class StartServlet extends HttpServlet {

    @Inject
    UserJPAService service;
    @Inject
    SignIn signIn;
    @Inject
    Logger logger;
    @Inject
    User user;
    @Inject
    RoleJPAService roleJPAService;
    @Inject
    Item item;
    @Inject
    ItemJPAService itemJPAService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getServletPath().equals("/checkUsernamePassword")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (signIn.signIn(username, password)) {
                if (signIn.signInAdmin(username)) {
                    List<Role> roleEntities = roleJPAService.getAll();
                    List<User> userEntities= service.getAll();
                    request.setAttribute("roles",roleEntities);
                    request.setAttribute("list",userEntities);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    List<Item> list = itemJPAService.getAll();
                    request.setAttribute("list",list);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
                    requestDispatcher.forward(request, response);
                }
            } else {
                request.setAttribute("nosign", "Не верны имя пользователя или пароль");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
                requestDispatcher.forward(request, response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info(request.getContextPath());

        if (request.getServletPath().equals("/")) {

            if (user!=null) {

                request.getSession().setAttribute("user", signIn.getSessionUser().getUsername());

            }else {
            request.setAttribute("user", "guest");}
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
