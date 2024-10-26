package com.example.airtel.domain;

import com.example.airtel.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NormalUser implements User{
    @Autowired
    DAO<NormalUser> normalUserDAO;
    String name;
    Integer id;
    String Plan;

    Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public  void setId(Integer id) {
        this.id = id;
    }

    public String getPlan() {
        return Plan;
    }

    public void setPlan(String plan) {
        Plan = plan;
    }

    @Override
    public Boolean saveUserDetails() {
        if(name!=null) {
            normalUserDAO.save(this);
            System.out.println("new user added  " + this.name +" "+ this.number);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void createUser(String name, String plan,Integer number) {
        this.setName(name);
        this.setPlan(plan);
        this.setNumber(number);
    }
}
