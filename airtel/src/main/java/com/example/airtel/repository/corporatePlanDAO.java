package com.example.airtel.repository;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.NormalPlan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class corporatePlanDAO implements DAO<CorporatePlan> {
    private List<CorporatePlan> corporatePlanList=new ArrayList<>();

    @Override
    public int save(CorporatePlan corporatePlan) {
        int corporatePlanId= corporatePlanList.size();
        corporatePlan.setPlanId(corporatePlanId);
        corporatePlanList.add(corporatePlan);
        System.out.println("plan saved");
        return corporatePlanId;

    }
}
