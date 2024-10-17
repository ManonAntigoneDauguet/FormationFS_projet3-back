package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.service.JWTService;

@RestController
public class LoginController {

	@Autowired
	public JWTService jwtService;

	@PostMapping("/auth/login")
	public String getToken(Authentication authentication) {
		String token = jwtService.generateToken(authentication);
		return token;
	}
	
}
