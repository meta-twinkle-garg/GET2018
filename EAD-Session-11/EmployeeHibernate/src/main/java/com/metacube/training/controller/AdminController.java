package com.metacube.training.controller;


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
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;


@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobService jobService;
	@Autowired
	private SkillService skillService;

	@GetMapping("/login")
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		if ("admin".equals(username) && "admin".equals(password)) {
			return new ModelAndView("admin/dashboard", "username", username);
		}else{
			return new ModelAndView("admin/invalid");
		}
	}

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createProject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "/employees/add", method = RequestMethod.GET)
	public String createEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "admin/editEmployee";
	}

	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skill", new Skill());
		return "admin/editSkill";
	}

	@RequestMapping(path = "/jobs/add", method = RequestMethod.GET)
	public String createJob(Model model) {
		model.addAttribute("job", new Job());
		return "admin/editJob";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute("project") Project project) {
			if(project!=null && project.getId()==0){
				projectService.createProject(project);
			}else{
				projectService.updateProject(project);
			}
			
		
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/employees", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		if(employee!=null && employee.getId()==0){	
			employeeService.createEmployee(employee);
		}else{
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/employees";
	}

	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skill") Skill skill) {
			if(skill!=null && skill.getId()==0){
				skillService.createSkill(skill);
			}else{
				skillService.updateSkill(skill);
			}
			

		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/jobs", method = RequestMethod.POST)
	public String saveJob(@ModelAttribute("job") Job job) {
		if(job!=null && job.getId()==0){
			jobService.createJob(job);
		}else{
			jobService.updateJob(job);
		}
		return "redirect:/admin/jobs";
	}

	@RequestMapping(path = "projects", method = RequestMethod.GET)
	public String getAllProjects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "logout", method = RequestMethod.GET)
	public String logout(Model model) {
		
		return "welcome";
	}
	@RequestMapping(path = "employees", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "admin/employee";
	}

	@RequestMapping(path = "skills", method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skills", skillService.getAllSkills());
		return "admin/skills";
	}

	@RequestMapping(path = "jobs", method = RequestMethod.GET)
	public String getAllJobs(Model model) {
		model.addAttribute("jobs", jobService.getAllJobs());
		return "admin/jobs";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editProject(Model model, @RequestParam("id") int id) {
		model.addAttribute("project", projectService.getProjectById(id));
		return "admin/editProject";
	}

	@RequestMapping(path = "/employees/edit", method = RequestMethod.GET)
	public String editEmployee(Model model, @RequestParam("id") int id) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "admin/editEmployee";
	}

	@RequestMapping(path = "/skills/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("id") int id) {
		model.addAttribute("skill", skillService.getSkillById(id));
		return "admin/editSkill";
	}

	@RequestMapping(path = "/jobs/edit", method = RequestMethod.GET)
	public String editJob(Model model, @RequestParam("id") int id) {
		model.addAttribute("job", jobService.getJobById(id));
		return "admin/editJob";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteProject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/employees/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam("id") int id) {
		employeeService.deleteEmployee(id);
		return "redirect:/admin/employees";
	}

	@RequestMapping(path = "/skills/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("id") int id) {
		skillService.deleteSkill(id);
		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/jobs/delete", method = RequestMethod.GET)
	public String deleteJob(@RequestParam("id") int id) {
		jobService.deleteJob(id);
		return "redirect:/admin/jobs";
	}
}