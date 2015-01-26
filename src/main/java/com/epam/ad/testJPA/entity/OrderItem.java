package com.epam.ad.testJPA.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@IdClass(value = OrderItemPK.class)
public class OrderItem {
    @Id
    @Column(name = "order_id")
    private int order_id;
    @Id
    @Column(name = "item_id")
    private int item_id;
    @Column(name = "item_qty")
    private int itemQty;

    public int getOrderId() {
        return order_id;
    }

    public void setOrderId(int orderId) {
        this.order_id = orderId;
    }

    public int getItemId() {
        return item_id;
    }

    public void setItemId(int itemId) {
        this.item_id = itemId;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }
}
