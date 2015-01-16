package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.OrderEntity;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class OrderJPAService extends JPAService<OrderEntity>{
    public OrderJPAService() {
        super(OrderEntity.class);
    }

}
