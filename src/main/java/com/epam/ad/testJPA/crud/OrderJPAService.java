package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.Order;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Stateless
@Named
public class OrderJPAService extends JPAService<Order>{

    @Inject
    private EntityManager entityManager;
    public OrderJPAService() {
        super(Order.class);
    }

}
