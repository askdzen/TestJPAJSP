package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.UserEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Stateless
@Named
public class UserJPAService extends JPAService<UserEntity> {

    public UserJPAService() {
        super(UserEntity.class);
    }

private EntityManager entityManager=getEm();

}
