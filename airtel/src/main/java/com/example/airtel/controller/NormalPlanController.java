package com.example.airtel.controller;

import com.example.airtel.domain.NormalPlan;
import com.example.airtel.domain.Plan;
import com.example.airtel.service.NormalPlanRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NormalPlanController {
    @Autowired
    NormalPlanRegisterationService planRegisterationService;

    @RequestMapping("/done")
    public String getNormalUserPage(Model normalplanModel){
        Plan plan = planRegisterationService.getNewNormalPlan();
        normalplanModel.addAttribute("normalplan",plan);
        return "normaluserplandetails";
    }
    @RequestMapping("/registernormalplan")
    public String getNormalUserDonePage(@ModelAttribute("donenormaluser") NormalPlan normalPlan){
        if(planRegisterationService.registerPlan(normalPlan.getData(), normalPlan.getDuration(), normalPlan.getSpeed(),normalPlan.getCalls())){
            return "success";
        }
        return "normaluserplandetails";
    }
}
