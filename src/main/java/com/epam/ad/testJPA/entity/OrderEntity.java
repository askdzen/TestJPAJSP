package com.epam.ad.testJPA.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "order", schema = "", catalog = "test")
@NamedQuery(name = "OrderEntity.getAll", query = "SELECT a from OrderEntity a")
public class OrderEntity {
    private int id;
    private String cost;
    private Date date;
    private UserEntity userid;

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
    @Column(name = "cost")
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (cost != null ? !cost.equals(that.cost) : that.cost != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id", nullable = false)
    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userByUserid) {
        this.userid = userByUserid;
    }


}
