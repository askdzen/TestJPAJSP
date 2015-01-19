package com.epam.ad.testJPA.model;

import com.epam.ad.testJPA.crud.RoleJPAService;
import com.epam.ad.testJPA.entity.RoleEntity;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Stateless
@Named
public class SelectRole {
    @Inject
    RoleEntity roleEntity;
    @Inject
    RoleJPAService service;

    public List<RoleEntity> getRoleList(){
        return service.getAll();
    }

    public int getRoleIdByName(String roleName){
        return service.getRoleByName(roleName).getId();
    }
}
