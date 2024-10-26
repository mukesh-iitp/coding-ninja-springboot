package com.example.airtel.service;

import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.NormalUser;
import com.example.airtel.domain.Plan;

public interface PlanRegisterationService {
    public Boolean registerPlan(Integer data,Integer duration,String speed,String calls);
    public Plan getNewNormalPlan();
}
