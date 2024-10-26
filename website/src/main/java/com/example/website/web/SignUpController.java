package com.example.website.web;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.website.domain.StudentUser;
import com.example.website.domain.User;
import com.example.website.service.UserService;

@Controller
public class SignUpController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/signUp")
	public String getSignupPage(Model uiModel){
		User user=userService.getUser();
		uiModel.addAttribute("user", user);
		return "signup";
	}
	
	@RequestMapping("/registerUser")
	public String createUser(@ModelAttribute(value = "user") StudentUser studentUser) {
		int userId = userService.signUp(studentUser.getName(), studentUser.getGender(), studentUser.getLocation(), studentUser.getCollege());
		if(userId != -1) {
			//to redirect the user and change the url parameter
			ModelAndView modelAndView = new ModelAndView("redirect:welcome?id="+userId);
			//return "welcome";
			return modelAndView.getViewName();
		}

		else
			return "signup";
	}
	
	@RequestMapping("/welcome")
	public String showWelcomePage(@RequestParam("id") String userID, ModelMap map) {
		map.addAttribute("userID", userID);
		return "welcome";
	}
	
	@RequestMapping("instructors")
	public String showInstructors(ModelMap map) {
		//Instructors using HashMap
		HashMap<String, Object> instructor1 = new HashMap<String, Object>();
		instructor1.put("name", "Rahul");
		instructor1.put("age", 23);
		instructor1.put("id", 243);
		
		HashMap<String, Object> instructor2 = new HashMap<String, Object>();
		instructor2.put("name", "Mukesh");
		instructor2.put("age", 34);
		instructor2.put("id", 244);
		
		//Array list of instructors
		ArrayList<HashMap<String, Object>> listOfInstructor = new ArrayList<HashMap<String,Object>>();
		
		listOfInstructor.add(instructor1);
		listOfInstructor.add(instructor2);
		
		//sending key value pair to the view
		map.addAttribute("instructor", listOfInstructor);
		return "instructors";
	}
	
	@RequestMapping("/profile/{profileID}")
	public String showProfile(@PathVariable("profileID") String profileID, ModelMap map) {
		map.addAttribute("profileID",profileID);
		return "profile";
	}

}
