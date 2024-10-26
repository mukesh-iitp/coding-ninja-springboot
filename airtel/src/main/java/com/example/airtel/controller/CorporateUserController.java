package com.example.airtel.controller;

import com.example.airtel.domain.CorporateUser;
import com.example.airtel.domain.User;
import com.example.airtel.service.corporateUserRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CorporateUserController {

    @Autowired
    corporateUserRegisterationService corporateUserRegisterationService;
    @RequestMapping("corporateuser")
    String getCorporateUserPage(){
        return "corporateuserselect";
    }

    @RequestMapping("/signup-corporate")
    public String getCorporateSignupPage(Model corporateUserModel) {
       User user = corporateUserRegisterationService.getNewUser();
        corporateUserModel.addAttribute("corporate",user);
        return "corporateuserform";
    }
    @RequestMapping("/corporateregister")
    public String getcorporateUserSelect(@ModelAttribute("user")CorporateUser corporateUser){
        if(corporateUserRegisterationService.registerUser(corporateUser.getName(),corporateUser.getPlan(),corporateUser.getNumber())){
            return "corporateuserplan";
        }
        return "corporateuserform";
    }
}
