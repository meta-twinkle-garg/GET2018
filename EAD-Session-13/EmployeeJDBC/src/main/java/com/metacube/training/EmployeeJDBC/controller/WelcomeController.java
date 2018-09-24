package com.metacube.training.EmployeeJDBC.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("Hello");
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "login";
	}
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login(ModelMap model) {

		
		return "login";
	}
	@RequestMapping(value="/invalid",method = RequestMethod.GET)
	public String invalid(ModelMap model) {
	
		return "invalid";
	}
	@GetMapping("/dashboard")
	public String login(HttpServletRequest request) {
		if(request.isUserInRole("ROLE_ADMIN")){
			return "admin/dashboard";
		}else{
			return "employee/dashboard";
		}
		
	}
}

