package com.kingdee.bean;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
public class User implements Serializable {
    private static final long serialVersionUID = 2684609809780170734L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name="name",columnDefinition = "varchar(50) comment '用户名'")
    private String name;

    @Column(name = "password",columnDefinition = "varchar(50) comment '密码'")
    private String password;

    @Column(name = "gender",columnDefinition = "int default 0 comment '性别(0男1女)'")
    private Integer gender;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
