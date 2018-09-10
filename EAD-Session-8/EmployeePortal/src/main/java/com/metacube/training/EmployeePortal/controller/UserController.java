package com.metacube.training.EmployeePortal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.EmployeePortal.model.Employee;
import com.metacube.training.EmployeePortal.service.EmployeeService;


@Controller
@RequestMapping("/user")
public class UserController {


		private EmployeeService employeeService;

		@GetMapping("/login")
		public String login() {
			return "user/login";
		}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ModelAndView login(@RequestParam(name = "username") String username,
				@RequestParam(name = "password") String password) {
			int id=employeeService.checkLogin(username,password);
			if (id!=0) {
				return new ModelAndView("employee/dashboard", "id", id);
			}else{
				return new ModelAndView("employee/invalid");
			}
		}

		@RequestMapping(path = "/employee/edit", method = RequestMethod.GET)
		public String editEmployee(Model model, @RequestParam("id") int id) {
			model.addAttribute("employee", employeeService.getEmployeeById(id));
			return "admin/editEmployee";
		}
		
		@RequestMapping(path = "employee", method = RequestMethod.POST)
		public String saveProject(@ModelAttribute("employee") Employee employee) {

				employeeService.updateEmployee(employee);
			
			return "redirect:/user/dashboard";
		}

}
