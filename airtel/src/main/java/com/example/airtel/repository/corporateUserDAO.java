package com.example.airtel.repository;

import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.NormalUser;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class corporateUserDAO implements DAO<CorporateUser>{
    private List<CorporateUser> corporateUserList = new ArrayList<>();
    @Override
    public int save(CorporateUser corporateUser) {
        int corporateUserid=corporateUserList.size();
        corporateUser.setId(corporateUserid);
        corporateUserList.add(corporateUser);
        System.out.println("user saved");
        return corporateUserid;
    }
}
