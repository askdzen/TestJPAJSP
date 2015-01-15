package com.epam.ad.testJPA.crud;

import com.epam.ad.testJPA.entity.UserEntity;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.*;
import java.util.List;
@Stateful
@Named
public class JPAService {
@Inject
    public EntityManager em;

    public UserEntity add(UserEntity userEntity){

        UserEntity carFromDB = em.merge(userEntity);
        return carFromDB;
    }


    public void delete(int id){
        em.remove(get(id));

    }

    public UserEntity get(int id){
        return em.find(UserEntity.class, id);
    }

    public void update(UserEntity userEntity){
        em.merge(userEntity);

    }

    public List<UserEntity> getAll(){
        TypedQuery<UserEntity> namedQuery = em.createNamedQuery("User.getAll", UserEntity.class);
        return namedQuery.getResultList();
    }

    public UserEntity getBuId(int id){
        return (UserEntity) em.createNamedQuery("User.findById").setParameter("uid", id).getSingleResult();
    }
}
