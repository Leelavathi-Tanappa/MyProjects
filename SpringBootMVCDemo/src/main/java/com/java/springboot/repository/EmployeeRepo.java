package com.java.springboot.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.java.springboot.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	//List<Employee> findByEnameOrderByEage(String eName);

	@Query("from Employee where ename = :name")
	List<Employee> findByName(@Param("name") String eName);
}
