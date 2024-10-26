package com.example.airtel.domain;

import com.example.airtel.repository.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class NormalPlan implements Plan {

    @Autowired
    DAO<NormalPlan> normalPlanDAO;
    Integer data;
    Integer duration;
    String speed;
    String calls;

    Integer planId;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCalls() {
        return calls;
    }

    public void setCalls(String calls) {
        this.calls = calls;
    }

    @Override
    public Boolean savePlanDetails() {
        normalPlanDAO.save(this);
        System.out.println("new plan created "+this.data+" "+this.calls+" "+this.speed+" "+this.duration);
        return true;
    }

    @Override
    public void createPlan(Integer data, Integer duration, String Speed, String calls) {
        this.setCalls(calls);
        this.setData(data);
        this.setDuration(duration);
        this.setSpeed(Speed);
    }
}
