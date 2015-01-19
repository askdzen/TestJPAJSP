package com.epam.ad.testJPA.entity;


import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "role", schema = "", catalog = "test")
@NamedQueries({
        @NamedQuery(name = "RoleEntity.getAll", query = "SELECT r from RoleEntity r"),
        @NamedQuery(name = "RoleEntity.findById", query ="SELECT r from RoleEntity r WHERE r.id =:rid"),
        @NamedQuery(name = "RoleEntity.findByName", query ="SELECT r from RoleEntity r WHERE r.role =:rname")
})
public class RoleEntity {
    private int id;
    private String role;
    private Collection<UserEntity> rolesById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @OneToMany(mappedBy = "role",fetch = FetchType.EAGER)
    public Collection<UserEntity> getRolesById() {
        return rolesById;
    }

    public void setRolesById(Collection<UserEntity> rolesById) {
        this.rolesById = rolesById;
    }
}
