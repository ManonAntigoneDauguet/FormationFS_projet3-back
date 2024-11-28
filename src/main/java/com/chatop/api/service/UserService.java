package com.chatop.api.service;

import com.chatop.api.business.entity.User;
import com.chatop.api.business.mapper.UserMapper;
import com.chatop.api.common.DTO.apiRequest.UserRequestDTO;
import com.chatop.api.common.DTO.apiResponse.UserResponseDTO;
import com.chatop.api.repository.UserRepository;
import com.chatop.api.configuration.security.UserDetailsImpl;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

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
     * @return UserResponseDTO
     */
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.convertToResponseDTO(user);
    }

    /**
     * Finds the user by eamil
     *
     * @param email as String
     * @return UserResponseDTO
     */
    public UserResponseDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("User not found"));
        return userMapper.convertToResponseDTO(user);
    }

    /**
     * Finds the user by Authentication
     *
     * @return UserResponseDTO
     */
    public UserResponseDTO getUserByAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String email = userDetails.getEmail();
        return getUserByEmail(email);
    }
}
