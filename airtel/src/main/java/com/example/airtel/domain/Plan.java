package com.example.airtel.domain;

public interface Plan {
    public Boolean savePlanDetails();
    public void createPlan(Integer data,Integer duration,String Speed,String calls);
}
