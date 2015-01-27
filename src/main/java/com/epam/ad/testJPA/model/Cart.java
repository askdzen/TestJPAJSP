package com.epam.ad.testJPA.model;

import com.epam.ad.testJPA.crud.OrderJPAService;
import com.epam.ad.testJPA.crud.Order_ItemJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.Order;
import org.jboss.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Named
@SessionScoped
public class Cart implements Serializable {
    @Inject
    Logger logger;
    @Inject
    Order order;
    @Inject
    OrderJPAService service;
    @Inject
    Order_ItemJPAService order_itemJPAService;
    int itemIndexOf;
    private List<Item> userCartList = new ArrayList<>();

    public void addCart(Item item) {

        userCartList.add(item);
    }
    public boolean unicOrderItem (int orderId,int itemId){
        try {
            order_itemJPAService.getOrderItemByKey(orderId,itemId);
        }catch (Exception e){
            return true;
        }
        return false;
    }

    public List<Item> getUserCartList() {
        return userCartList;
    }

    public void userCartRemove() {
        userCartList.removeAll(userCartList);

    }

    public void deleteItemFromCart(int itemId, int orderId) {
        logger.info("Item_id in the Cart methods: " + itemId);
        for (Item item1 : userCartList) {
            if (item1.getId() == (itemId)) {
                itemIndexOf = userCartList.indexOf(item1);
            }
        }
        if (userCartList.size() > 0)
            userCartList.remove(itemIndexOf);
        order_itemJPAService.delete(orderId,itemId);

    }

    public Order getOrder() {
        return order;
    }
}
