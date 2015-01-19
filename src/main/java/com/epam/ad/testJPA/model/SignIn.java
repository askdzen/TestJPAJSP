package com.epam.ad.testJPA.model;


import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.UserEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
@Named
public class SignIn {

    @Inject
    UserJPAService userJPAService;
    @Inject
    UserEntity user;

    public boolean signIn(String username,String password){
        if (userJPAService.usernameIs(username)){
           user = userJPAService.getUserByUsername(username);
            if (user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
