package com.java.springmvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.java.springmvc.controller.dao.EmployeeDAO;
import com.java.springmvc.model.Employee;

@Controller
public class FrontController {	
	
	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		dao.addEmployee(employee);
		return "result";
	}
	
	@GetMapping("getEmployees")
	public String getEmployees(Model m) {
		m.addAttribute("employees", dao.getEmployees());		
		return "showEmployees";
	}
	
	@GetMapping("getEmployee")
	public String getEmployee(@RequestParam("eId") int eId, Model m) {
		m.addAttribute("employee", dao.getEmployee(eId));
		return "result";
	}
	
	/* @ModelAttribute
	public void generalData(Model m) {
		m.addAttribute("name", "Alien");
	}
	 
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		int num3 = i+j;	
		m.addAttribute("num3", num3);
		return "result";
	} */
}
