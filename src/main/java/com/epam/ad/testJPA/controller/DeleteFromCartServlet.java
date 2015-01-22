package com.epam.ad.testJPA.controller;

import com.epam.ad.testJPA.crud.ItemJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.model.Cart;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("deleteFromCartServlet")
public class DeleteFromCartServlet extends HttpServlet {
    @Inject
    ItemJPAService service;
    @Inject
    Cart cart;
    @Inject
    Logger logger;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Item deleteItem = service.getById(Integer.parseInt(id), "iid");
        logger.info("Item id in the DeleteFromCartServlet "+deleteItem.getId());
        cart.deleteItemFromCart(deleteItem);
        request.setAttribute("userCart",cart.getUserCartList());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/shopcart.jsp");
        requestDispatcher.forward(request, response);
    }
}
