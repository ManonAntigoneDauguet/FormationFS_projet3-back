package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.User;
import com.chatop.api.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("auth/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}
	
    @GetMapping("/users") // Remove more later
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }
}
