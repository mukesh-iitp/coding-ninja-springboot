package com.example.CarService.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SupportController {

    /**
     1. The method getSupportPage returns string "support" for support page.
     2. Also, the method accepts id of type String & object of type ModelMap as argument.
    **/

    @RequestMapping(value = "/support")
    public String getSupportPage(@RequestParam("id") String carID, ModelMap map) {
    	//map.addAttribute("message", "Welcome to support page "+carID);
    	map.addAttribute("carID", carID);
    	return "support";
     }
}
