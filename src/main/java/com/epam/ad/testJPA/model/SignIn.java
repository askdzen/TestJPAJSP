package com.epam.ad.testJPA.model;



import com.epam.ad.testJPA.crud.UserJPAService;
import com.epam.ad.testJPA.entity.Item;
import com.epam.ad.testJPA.entity.Role;
import com.epam.ad.testJPA.entity.User;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Stateful
@Named
@SessionScoped
public class SignIn implements Serializable {

    @Inject
    UserJPAService userJPAService;

    public User user;

    public User getSessionUser() {
        return user;
    }


    public boolean signIn(String username, String password) {
        if (userJPAService.usernameIs(username)) {
            user = userJPAService.getUserByUsername(username);
            if (user.getPassword().equals(password))

                return true;
        }
        return false;
    }

    public boolean signInAdmin(String username) {
        user = userJPAService.getUserByUsername(username);
        Role role = user.getRole();
        if (role.getName().equals("admin")) {
            return true;
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    @PostConstruct
    public void initNewUser() {

        user = new User();


    }
}
