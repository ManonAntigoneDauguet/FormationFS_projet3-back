package com.chatop.api.service;

import java.time.LocalDateTime;

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
	
	public User register(User user) {
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public Iterable<User> getUsers() { // Remove more later
		return userRepository.findAll();
	}
}
