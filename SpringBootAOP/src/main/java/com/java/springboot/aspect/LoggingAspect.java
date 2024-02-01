package com.java.springboot.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.java.springboot.ControllerRest.getEmployees())")
	public void logBefore() {
		LOGGER.info("Before execution of GetEmployees() method using logger and aspect....");
	}
	
	@After("execution(public * com.java.springboot.ControllerRest.getEmployees())")
	public void logAfter() {
		LOGGER.info("After execution of GetEmployees() method using logger and aspect....");
	}
	
	@AfterReturning("execution(public * com.java.springboot.ControllerRest.getEmployees())")
	public void logAfterReturn() {
		LOGGER.info("After Successful execution of GetEmployees() method.....");
	}
	
	@AfterThrowing("execution(public * com.java.springboot.ControllerRest.getEmployees())")
	public void logAfterThrow() {
		LOGGER.info("After Catching execption in GetEmployees() method.....");
	}
}
