package com.java.springboot;

import com.java.springboot.model.Employee;
import com.java.springboot.repository.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootJdbcApplication.class, args);
		Employee emp = context.getBean(Employee.class);
		emp.setId(101);
		emp.setName("Leela");
		emp.setTech("Java");

		Employee emp1 = context.getBean(Employee.class);
		emp1.setId(102);
		emp1.setName("Hema");
		emp1.setTech("Selenium");

		EmployeeRepository empRepo = context.getBean(EmployeeRepository.class);
		empRepo.save(emp);
		empRepo.save(emp1);
		System.out.println(empRepo.fetchAll());

		System.out.println(empRepo.fecthId(102));
		empRepo.delete(102);
		System.out.println(empRepo.fetchAll());
	}

}
