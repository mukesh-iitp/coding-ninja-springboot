package com.example.CarService.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 1. getAttendent method returns string "attendent" for Attendent page.
 2. Also, it accepts attendentId of type String and object of type ModelMap as argument.
 3. Use @PathVariable annotation accordingly.
**/

@Controller
public class attendentController {
    
  @GetMapping("/attendent/{attendentId}")
    public String getAttendent(@PathVariable("attendentId") String attendentId, ModelMap map){
      //Write your Logic here
	  map.addAttribute("attendentId", attendentId);
      map.addAttribute("name", "TEST 123");
      map.addAttribute("work","Engine,BodyShop");
	  return "attendent";
    }

}
