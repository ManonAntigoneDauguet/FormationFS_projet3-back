package com.chatop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.api.model.database.User;
import com.chatop.api.service.UserService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * Returns the user's information
	 * 
	 * @param id as the user id
	 * @return user's information
	 */
	@GetMapping("/user/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable("id") final Long id) {
        try {
            User user = userService.getUserById(id);
            return  ResponseEntity.ok(user);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found");
        }
	}
}
