package com.example.airtel.repository;

import com.example.airtel.domain.NormalUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class normalUserDAO implements DAO<NormalUser> {
    private List<NormalUser> normalUserList = new ArrayList<>();

    @Override
    public int save(NormalUser normalUser) {
       int normalUserid=normalUserList.size();
        normalUser.setId(normalUserid);
        normalUserList.add(normalUser);
        System.out.println("user saved");
        return normalUserid;
    }
}
