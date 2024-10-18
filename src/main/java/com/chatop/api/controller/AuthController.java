package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.apiRequest.LoginRequest;
import com.chatop.api.model.apiResponse.ApiMessageResponse;
import com.chatop.api.model.apiResponse.ApiResponse;
import com.chatop.api.model.apiResponse.ApiTokenResponse;
import com.chatop.api.model.database.User;
import com.chatop.api.service.JWTService;
import com.chatop.api.service.UserService;

@RestController
public class AuthController {

	@Autowired
	public JWTService jwtService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

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
	 * Try to login the user with his email and password. Returns a token in case of
	 * success
	 * 
	 * @param authentication
	 * @return token
	 */
	@PostMapping("/auth/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest) {
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

			String token = jwtService.generateToken(authentication);
			return ResponseEntity.ok(new ApiTokenResponse(token));

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiMessageResponse("error"));
		}
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
