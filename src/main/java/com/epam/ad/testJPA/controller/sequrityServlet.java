package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.model.SignIn;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("sequrityServlet")
public class sequrityServlet extends HttpServlet {
@Inject
SignIn signIn;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (signIn.signIn(username,password)){

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
            requestDispatcher.forward(request,response);
        }else {
            request.setAttribute("nosign","Не верны имя пользователя или пароль");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            requestDispatcher.forward(request, response);
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
