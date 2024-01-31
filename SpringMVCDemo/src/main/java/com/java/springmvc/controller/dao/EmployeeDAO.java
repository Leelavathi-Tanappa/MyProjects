package com.java.springmvc.controller.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.java.springmvc.model.Employee;

@Repository
public class EmployeeDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<Employee> getEmployees(){		
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
		return employees;
	}
	
	@Transactional
	public void addEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(emp);		
	}
	
	@Transactional
	public Employee getEmployee(int eId) {
		Session session = sessionFactory.getCurrentSession();
		Employee emp = session.get(Employee.class, eId);
		return emp;
	}
}
