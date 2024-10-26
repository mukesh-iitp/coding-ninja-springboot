package com.example.airtel.domain;

public interface User {
    public Boolean saveUserDetails();
    public void createUser(String name,String plan,Integer number);
}
