package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.ItemJPAService;
import com.epam.ad.testJPA.crud.RoleJPAService;
import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.Role;
import com.epam.ad.testJPA.entity.User;
import com.epam.ad.testJPA.model.Cart;
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
    ItemJPAService itemJPAService;
    @Inject
    Cart cart;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getServletPath().equals("/checkUsernamePassword")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (signIn.signIn(username, password)) {
                if (signIn.signInAdmin(username)) {

                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
                    requestDispatcher.forward(request, response);
                } else {

//                    if (cart.getUserCartList().size()>0){
//                        cart.userCartRemove();
//                    }

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
            logger.info(signIn.getUser().getUsername());
            if (signIn.getUser().getUsername()==null) {

               request.setAttribute("user", "guest");
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
