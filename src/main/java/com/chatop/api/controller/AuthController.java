package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.User;
import com.chatop.api.service.JWTService;
import com.chatop.api.service.UserService;

@RestController
public class AuthController {

	@Autowired
	public JWTService jwtService;

	@Autowired
	private UserService userService;

	/**
	 * Allow to add a new user
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("auth/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	/**
	 * Allows to login a user with a token in return
	 * 
	 * @param authentication
	 * @return token
	 */
	@PostMapping("/auth/login")
	public String getToken(Authentication authentication) {
//		String token = jwtService.generateToken(authentication);
		String token = jwtService.generateToken();
		return token;
	}

	/**
	 * Allows to access at the connected profile
	 * 
	 * @return user's informations
	 */
//	@PostMapping("/auth/me")
//	public User getProfile() {
//
//	}

}
