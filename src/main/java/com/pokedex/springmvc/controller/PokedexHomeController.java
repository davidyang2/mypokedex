package com.pokedex.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class PokedexHomeController {
	@RequestMapping(value="/mypokedexhome", method= RequestMethod.GET)
	public String getLoginPage() {
		return "PokedexPage";
	}
	
	@RequestMapping(value="/mypokedex/create", method= RequestMethod.GET)
	public String getSignUpPage() {
		return "PokedexCreator";
	}
}
