package com.chatop.api.business.service;

import java.util.Date;

import com.chatop.api.business.mapper.UserMapper;
import com.chatop.api.service.DTO.apiRequest.UserRequestDTO;
import com.chatop.api.service.DTO.apiResponse.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Saves the new user
	 * 
	 * @param userRequestDTO as the new user to save
	 */
	public void register(UserRequestDTO userRequestDTO) {
		Date today = Date.from(new Date().toInstant());

		User user = userMapper.convertToEntity(userRequestDTO);
		user.setCreatedAt(today);
		user.setUpdatedAt(today);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	/**
	 * Finds the user by id
	 *
	 * @param id as the user id
	 * @return user
	 */
	public UserResponseDTO getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
		return userMapper.convertToResponseDTO(user);
	}
	
	/**
	 * Find the connected user
	 * @return user
	 */
//	public User getProfile() {
//		return ...
//	}

}
