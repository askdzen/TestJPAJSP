package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.UserEntity;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Stateless
@Named
public class UserJPAService extends JPAService<UserEntity> {

    @Inject
    Logger logger;
    @Inject
    private UserEntity userEntity;
    @Inject
    private EntityManager entityManager;

    public UserJPAService() {
        super(UserEntity.class);
    }

    public UserEntity getUserByUsername(String username) {
        userEntity = (UserEntity) entityManager.createNamedQuery("UserEntity.findByUsername").setParameter("uname", username).getSingleResult();
        logger.info("Пользователь с именем существует: " + userEntity.getUsername());
        return userEntity;
    }

    public boolean usernameIs(String username) {
        try {
            userEntity = (UserEntity) entityManager.createNamedQuery("UserEntity.findByUsername").setParameter("uname", username).getSingleResult();
            logger.info("Пользователь с именем существует: " + userEntity.getUsername());
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
