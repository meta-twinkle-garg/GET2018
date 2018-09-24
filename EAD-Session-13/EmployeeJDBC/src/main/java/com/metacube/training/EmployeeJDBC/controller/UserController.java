package com.metacube.training.EmployeeJDBC.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeeJDBC.model.Employee;

import com.metacube.training.EmployeeJDBC.service.EmployeeService;


@Controller
@RequestMapping("/employee")
public class UserController {

@Autowired
private EmployeeService employeeService;

@SuppressWarnings("unused")
private Employee user;
		@GetMapping("/login")
		public String login() {
			return "employee/login";
		}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ModelAndView login(@RequestParam(name = "username") String username,
				@RequestParam(name = "password") String password) {
			Employee employee=employeeService.checkLogin(username,password);
			if(employee.getId()>0){
				user=employee;
				return new ModelAndView("employee/dashboard","employee", employee);
			}else{
				return new ModelAndView("employee/invalid");
			}
		}

		@RequestMapping(path = "/employee/edit", method = RequestMethod.GET)
		public String editEmployee(Model model) {
			model.addAttribute("employee", user);
			return "employee/editEmployee";
		}
		
		@RequestMapping(path = "employee/profile", method = RequestMethod.POST)
		public String saveProject(@ModelAttribute("employee") Employee employee) {

				employeeService.updateEmployee(employee);
			
			return "redirect:/employee/dashboard";
		}

}
