package com.example.airtel.service;

import com.example.airtel.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class corporateUserRegisterationService implements RegisterationService {

    @Autowired
    User corporateUser;
    @Override
    public Boolean registerUser(String name, String plan, Integer number) {
        corporateUser.createUser(name,plan,number);
        return corporateUser.saveUserDetails();
    }

    @Override
    public User getNewUser() {
        return corporateUser;
    }
}
