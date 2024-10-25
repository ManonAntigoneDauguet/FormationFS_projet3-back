package com.chatop.api.business.service;

import java.time.LocalDateTime;

import com.chatop.api.business.mapper.UserMapper;
import com.chatop.api.service.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatop.api.business.entity.User;
import com.chatop.api.service.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.Data;

@Data
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	/**
	 * Saves the new user
	 * 
	 * @param userDTO as the new user to save
	 */
	public void register(UserDTO userDTO) {
		User user = userMapper.convertToEntity(userDTO);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userRepository.save(user);
	}

	/**
	 * Finds the user by id
	 * 
	 * @param id as the user id
	 * @return user
	 */
	public User getUserById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
	}
	
	/**
	 * Find the connected user
	 * @return user
	 */
//	public User getProfile() {
//		return ...
//	}

}
