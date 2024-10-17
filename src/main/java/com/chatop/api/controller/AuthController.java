package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.service.AuthService;

@RestController
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@GetMapping("auth/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("auht/register")
	public String register() {
		return "register";
	}
}
