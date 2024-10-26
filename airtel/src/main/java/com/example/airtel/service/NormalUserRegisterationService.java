package com.example.airtel.service;

import com.example.airtel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service

public class NormalUserRegisterationService implements RegisterationService {
    @Autowired
    User normalUser;
    @Override
    public Boolean registerUser(String name, String plan,Integer number) {
        normalUser.createUser(name,plan,number);
        return normalUser.saveUserDetails();
    }

    @Override
    public User getNewUser() {
        return normalUser;
    }
}
