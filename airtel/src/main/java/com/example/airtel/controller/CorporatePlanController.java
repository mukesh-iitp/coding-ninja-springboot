package com.example.airtel.controller;

import com.example.airtel.domain.CorporatePlan;
import com.example.airtel.domain.Plan;
import com.example.airtel.service.corporatePlanRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CorporatePlanController {

    @Autowired
    corporatePlanRegisterationService corporatePlanRegisterationService;

    @RequestMapping("/corporateplans")
    public String getCorporatePlanDetails(Model corporateplanModel){
        Plan plan = corporatePlanRegisterationService.getNewNormalPlan();
        corporateplanModel.addAttribute("corporateplan",plan);
        return "corporateuserplandetails";
    }

    @RequestMapping("/registercorporateplan")
    public String getCorporateUserDonePage(@ModelAttribute("donecorporateuser") CorporatePlan corporatePlan){
        if(corporatePlanRegisterationService.registerPlan(corporatePlan.getData(), corporatePlan.getDuration(), corporatePlan.getSpeed(),corporatePlan.getCalls())){
            return "success";
        }
        return "corporateuserplandetails";
    }
}
