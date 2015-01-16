package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.UserInfoEntity;

import javax.ejb.Stateless;
import javax.inject.Named;

@Stateless
@Named
public class UserInfoJPAService extends JPAService<UserInfoEntity>{
    public UserInfoJPAService() {
        super(UserInfoEntity.class);
    }
}
