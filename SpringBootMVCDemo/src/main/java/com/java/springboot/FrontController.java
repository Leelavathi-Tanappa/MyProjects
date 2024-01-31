package com.java.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class FrontController {

	@Autowired
	EmployeeRepo repo;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@PostMapping("addEmployee")
	public String addEmployee(@ModelAttribute Employee employee) {
		repo.save(employee);
		return "result";
	}
	
	@GetMapping("getEmployees")
	public String getEmployees(Model m) {
		m.addAttribute("employees", repo.findAll());		
		return "showEmployees";
	}
	
	@GetMapping("getEmployee")
	public String getEmployee(@RequestParam("eId") int eId, Model m) {
		m.addAttribute("employee", repo.findById(eId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found")));
		return "result";
	}
	
	@GetMapping("getEmployeeByName")
	public String getEmployeeByName(@RequestParam("eName") String eName, Model m) {
		m.addAttribute("employee", repo.findByName(eName));
		return "result";
	}
	
	@GetMapping("deleteEmployee")
	public String removeEmployee(@RequestParam("eId") int eId, Model m) {		
		repo.deleteById(eId);
		return "result";
	}
	
	/* @RequestMapping(value="add", method=RequestMethod.POST)
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, ModelMap m) {
		int num3 = i+j;	
		m.addAttribute("num3", num3);
		return "result";
	}*/
}
