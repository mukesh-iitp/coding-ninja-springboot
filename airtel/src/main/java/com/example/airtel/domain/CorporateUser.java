package com.example.airtel.domain;

import com.example.airtel.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorporateUser implements User {
    @Autowired
    DAO<CorporateUser> corporateUserDAO;
    String name;
    Integer number;
    String plan;

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Boolean saveUserDetails() {
        corporateUserDAO.save(this);
        System.out.println("new user added corporate  " + this.name +" "+ this.number);
        return true;
    }

    @Override
    public void createUser(String name, String plan, Integer number) {
        this.setName(name);
        this.setPlan(plan);
        this.setNumber(number);
    }
}
