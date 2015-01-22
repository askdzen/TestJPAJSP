package com.epam.ad.testJPA.controller.orderController;

import com.epam.ad.testJPA.crud.ItemJPAService;
import com.epam.ad.testJPA.crud.OrderJPAService;
import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.Order;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "orderAddServlet",
        "itemsAddServlet"
})
public class OrderAddServlet extends HttpServlet {

    @Inject
    ItemJPAService itemJPAService;
    @Inject
    OrderJPAService orderJPAService;
    @Inject
    UserJPAService userJPAService;
    @Inject
    Logger logger;
    @Inject
    Order order;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if (request.getServletPath().equals("/orderAddServlet")){
           String userid = request.getParameter("id");

       }

        Order findOrder;
        List<Item>items=new ArrayList<>();
        Item item1= itemJPAService.getById(14,"iid");
        Item item2= itemJPAService.getById(15,"iid");
        items.add(item1);
        items.add(item2);

        for (Item item : items) {
            logger.info("Item Name"+item.getName());
        }

//        order.setDate(Date.valueOf("15.01.2015"));
        findOrder=orderJPAService.getById(6,"oid");
        logger.info("Order for user"+findOrder.getUser().getUsername()+"Order id"+ findOrder.getId());
        findOrder.setItems(items);
        logger.info("findOrders param "+findOrder.getId()+", "+findOrder.getCost());
        for (Item item : findOrder.getItems()) {
            logger.info("Items in order"+item.getName());
        }

        orderJPAService.add(findOrder);
        request.setAttribute("update","База обновлена");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
        requestDispatcher.forward(request, response);

    }
}
