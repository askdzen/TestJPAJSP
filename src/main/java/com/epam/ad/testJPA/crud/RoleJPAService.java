package com.epam.ad.testJPA.crud;


import com.epam.ad.testJPA.entity.RoleEntity;
import org.jboss.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Stateless
@Named
public class RoleJPAService extends JPAService<RoleEntity> {
    @Inject
    Logger logger;
    @Inject
    private RoleEntity roleEntity;
    @Inject
    private EntityManager entityManager;


    public RoleJPAService() {
        super(RoleEntity.class);
    }
    public RoleEntity getRoleByName(String roleName){
        return (RoleEntity) entityManager.createNamedQuery("RoleEntity.findByName").setParameter("rname",roleName).getSingleResult();
    }
}
