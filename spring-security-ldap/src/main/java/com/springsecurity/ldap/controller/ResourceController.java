package com.springsecurity.ldap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@GetMapping("/")
	public String home() {
		return ("<h1>Welcome</h1>");

	}

}
