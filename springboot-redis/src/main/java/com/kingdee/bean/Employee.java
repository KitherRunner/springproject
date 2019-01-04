package com.kingdee.bean;

import java.io.Serializable;

public class Employee implements Serializable {

    private Integer id;
    private String name;
    private Double salary;
    private Double common;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, Double common) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.common = common;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getCommon() {
        return common;
    }

    public void setCommon(Double common) {
        this.common = common;
    }
}
