package com.epam.ad.testJPA.crud;


import com.epam.ad.testJPA.entity.Item;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@Stateless
@Named

public class ItemJPAService extends JPAService<Item> {
    @Inject
    private EntityManager entityManager;
    public ItemJPAService() {
        super(Item.class);
    }



}
