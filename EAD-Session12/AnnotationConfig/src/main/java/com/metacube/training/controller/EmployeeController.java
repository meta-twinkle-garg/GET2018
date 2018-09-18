package com.metacube.training.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeServiceInterface;
import com.metacube.training.service.EmployeeSkillsServiceInterface;
import com.metacube.training.service.SkillServiceInterface;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceInterface employeeService;
	
	@Autowired
	private EmployeeSkillsServiceInterface employeeSkillsService;
	
	@Autowired
	private SkillServiceInterface skillService;

	@GetMapping("/login")
	public String login() {
		return "employee/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {

		Employee employee=employeeService.checkLogin(username,password);
		if(employee!=null){
			return new ModelAndView("employee/dashboard","employee", employee);
		}else{
			return new ModelAndView("employee/invalid");
		}
	}

	@RequestMapping(path = "/employees/edit", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id)); 

		return "employee/editEmployee";
	}
	
	@RequestMapping(path = "/employees/skills", method = RequestMethod.GET)
	public String employeeSkills(Model model, @RequestParam("id") int id) {
		
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		List<Integer> skillIds=employeeSkillsService.getEmployeeSkillsById(id);
		List<Skill> listOfSkills=new ArrayList<>();
		for(Integer skill:skillIds){
			listOfSkills.add(skillService.getSkillById(skill));
		}
		model.addAttribute("skills", listOfSkills); 
		
		return "employee/skills";
	}
	
	@RequestMapping(path = "update", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute("employee") Employee employee) {

			employeeService.updateEmployee(employee);
			return new ModelAndView("employee/dashboard","employee",employee);
	}
	
	@RequestMapping(path = "/employees/addSkills", method = RequestMethod.GET)
	public String updateSkill(Model model, @RequestParam("id") int id) {
		
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		
		model.addAttribute("otherSkills", skillService.getAllSkills()); 

		return "employee/addSkills";
	}
	
	@RequestMapping(path = "updateSkills", method = RequestMethod.POST)
	public String addSkills(Model model, @RequestParam(name = "skill") int skill, @RequestParam(name = "id") int id) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		employeeSkillsService.addEmployeeSkill(skill,id);

		return "employee/dashboard";
	}
	@RequestMapping(path = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
	
		return "welcome";
	}


}
