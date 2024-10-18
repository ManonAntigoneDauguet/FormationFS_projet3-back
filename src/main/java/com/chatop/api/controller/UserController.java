package com.chatop.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.User;
import com.chatop.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Returns the user's informations
	 * 
	 * @param id
	 * @return user's informations
	 */
	@GetMapping("/user/:id")
	public Optional<User> getUserById(@PathVariable("id") final Long id) {
		Optional<User> user = userService.getUserById(id);
		return user.isPresent() ? user : null;
	}

	@GetMapping("/users") // Remove more later
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
}
