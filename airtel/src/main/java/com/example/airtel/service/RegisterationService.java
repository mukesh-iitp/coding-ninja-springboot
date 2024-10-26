package com.example.airtel.service;

import com.example.airtel.domain.User;

public interface RegisterationService {
    public Boolean registerUser(String name,String plan,Integer number);
    public User getNewUser();
}
