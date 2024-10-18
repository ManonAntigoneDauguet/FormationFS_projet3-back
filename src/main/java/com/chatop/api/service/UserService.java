package com.chatop.api.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatop.api.model.User;
import com.chatop.api.repository.UserRepository;

import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	/**
	 * Saves the new user
	 * 
	 * @param user
	 * @return // Must to return a simple response
	 */
	public User register(User user) {
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	/**
	 * Finds the user by id
	 * 
	 * @param id
	 * @return user
	 */
	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	/**
	 * Find the connected user
	 * @return
	 */
//	public User getProfile() {
//		return ...
//	}

	public Iterable<User> getUsers() { // Remove more later
		return userRepository.findAll();
	}
}
