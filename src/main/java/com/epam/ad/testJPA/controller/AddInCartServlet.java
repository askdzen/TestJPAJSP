package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.ItemJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.User;
import com.epam.ad.testJPA.model.Cart;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("addCartServlet")

public class AddInCartServlet extends HttpServlet {
    @Inject
    Cart cart;
    @Inject
    ItemJPAService itemJPAService;
    @Inject
    User us;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("userCart", cart.getUserCartList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/shopcart.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cart.addCart(itemJPAService.getById(Integer.parseInt(request.getParameter("id")), "iid"));
        List<Item> list = itemJPAService.getAll();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
        requestDispatcher.forward(request, response);
    }

}
