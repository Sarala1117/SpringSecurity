package com.spring.jdbc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
	
	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");	
	}
	
	@GetMapping("/maker")
	public String maker() {
		return ("<h1>Welcome Maker</h1>");
	}
	
	@GetMapping("/checker")
	public String checker() {
		return ("<h1>Welcome Checker</h1>");
	}

}
