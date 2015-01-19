package com.epam.ad.testJPA.entity;

import javax.persistence.*;

@Entity
@Table(name = "userinfo", schema = "", catalog = "test")
@NamedQueries({
        @NamedQuery(name = "UserInfoEntity.getAll", query = "SELECT u from UserInfoEntity u"),
        @NamedQuery(name = "UserInfoEntity.findById", query = "SELECT u from UserInfoEntity u WHERE u.id =:uinfoid")
})
public class UserInfoEntity {

    private int id;
    private int user_id;
    private String firstName;
    private String lastName;
    private String email;
    private UserEntity userid;

    //    @OneToOne
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
//    private UserEntity user;
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
    @Column(name = "user_id")
    public int getUserId() {
        return user_id;
    }

    public void setUserId(int user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastname")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoEntity that = (UserInfoEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }


//    public UserEntity getUserByUserid() {
//        return user;
//    }
//
//    public void setUserByUserid(UserEntity userid) {
//        this.user = userid;
//    }


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userByUserid) {
        this.userid = userByUserid;
    }
}
