package com.pokedex.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginSignUpController {
	
	@RequestMapping(value="/login/", method= RequestMethod.GET)
	public String getLoginPage() {
		return "LoginPage";
	}
	
	@RequestMapping(value="/signup/", method= RequestMethod.GET)
	public String getSignUpPage() {
		return "SignUpPage";
	}
	
}
