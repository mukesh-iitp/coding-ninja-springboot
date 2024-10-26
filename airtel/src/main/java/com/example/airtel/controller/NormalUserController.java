package com.example.airtel.controller;

import com.example.airtel.domain.NormalUser;
import com.example.airtel.domain.User;
import com.example.airtel.service.NormalUserRegisterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class NormalUserController {
    @Autowired
    NormalUserRegisterationService registerationService;

    @RequestMapping("normaluser")
    String getNormalUserPage(){
        return "normaluserselect";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)

    public String getSignupPage(Model normalUserModel) {
        User user = registerationService.getNewUser();
        normalUserModel.addAttribute("user",user);
        return "normaluserform";
    }

    @RequestMapping("/register")
    public String getnormalUserSelect(@ModelAttribute("user") NormalUser normalUser ){
        if(registerationService.registerUser(normalUser.getName(),normalUser.getPlan(),normalUser.getNumber())){
            return "normaluserplan";
        }
        return "normaluserselect";
    }
}
