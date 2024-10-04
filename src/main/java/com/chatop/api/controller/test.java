package com.chatop.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

	@GetMapping("/")
	public String home() {
		return "Hello world !";
	}
	
	@GetMapping("/secur")
	public String secur() {
		return "Il faut être authentifié pour accéder à ceci !";
	}
}
