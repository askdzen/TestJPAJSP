package com.epam.ad.testJPA.model;

import com.epam.ad.testJPA.entity.Item;
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
    private List<Item> userCartList=new ArrayList<>();

    public void addCart(Item item){
        userCartList.add(item);

    }

    public List<Item> getUserCartList() {
        return userCartList;
    }

    public void userCartRemove(){
        userCartList.removeAll(userCartList);

    }
    public void deleteItemFromCart(Item item){
        logger.info("Item_id in the Cart methods: "+item.getId());
       userCartList.remove(item);

    }

}
