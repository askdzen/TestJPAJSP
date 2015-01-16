package com.epam.ad.testJPA.entity;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "user", schema = "", catalog = "test")
@NamedQueries({
        @NamedQuery(name = "UserEntity.getAll", query = "SELECT u from UserEntity u"),
        @NamedQuery(name = "UserEntity.findById", query ="SELECT u from UserEntity u WHERE u.id =:uid")
})
public class UserEntity {
    private String username;
    private String password;
    private int id;
    private Collection<OrderEntity> ordersById;

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (id != that.id) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    @OneToMany(mappedBy = "userByUserid",fetch = FetchType.EAGER)
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById =ordersById;
    }

    @Override
    public String toString() {
        return "User {"+
                "id="+id+
                ", username="+ username +'\''+
                ", password="+password+'}';
    }
}
