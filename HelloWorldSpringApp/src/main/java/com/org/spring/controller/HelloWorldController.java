package com.org.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/hello-world") /*http://localhost:8080/helloworld-springapp/myapp.com/hello-world */
	public String showHelloWorld() {
		return "Hello world from normal Spring mvc web app...";
	}

}
