package com.java.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepo;

@RestController
public class ControllerRest {

	@Autowired
	EmployeeRepo repo;
	
	@GetMapping(path="employees", produces={"application/xml"})
	public List<Employee> getEmployees(){		
		List<Employee> employees = repo.findAll();
		return employees;
	}
	
	@GetMapping("employee/{eId}")
	public Employee getEmployee(@PathVariable("eId")int eId) {
		Employee emp = repo.findById(eId).orElse(new Employee());
		return emp;
	}
	
	//@PostMapping(path="employee", consumes = {MediaType.APPLICATION_JSON_VALUE})
	@PostMapping(path="employee", consumes = {"application/json"})
	public Employee addEmployee(@RequestBody Employee emp) {
		repo.save(emp);	
		return emp;
	}
}
