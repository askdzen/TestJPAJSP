package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.User;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;


@Stateless
@Named
public class UserJPAService extends JPAService<User> {

    @Inject
    Logger logger;
    @Inject
    User user;
    @Inject
    private EntityManager entityManager;

    public UserJPAService() {
        super(User.class);
    }

    public User getUserByUsername(String username) {
        user = (User) entityManager.createNamedQuery("User.findByUsername").setParameter("uname", username).getSingleResult();
        logger.info("Пользователь с именем существует: " + user.getUsername());
        return user;
    }

    public boolean usernameIs(String username) {
        try {
            user = (User) entityManager.createNamedQuery("User.findByUsername").setParameter("uname", username).getSingleResult();
            logger.info("Пользователь с именем существует: " + user.getUsername());
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
