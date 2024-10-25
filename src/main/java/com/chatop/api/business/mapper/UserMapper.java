package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.User;
import com.chatop.api.service.DTO.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    /**
     * Converts a UserDTO object into a User object
     *
     * @param userDTO as the UserDTO to convert
     * @return User
     */
    public User convertToEntity(UserDTO userDTO) {
        if (userDTO == null) return null;

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    /**
     * Converts a User object into a UserDTO object
     *
     * @param user as the user to convert
     * @return UserDTO
     */
    public UserDTO convertToDTO(User user) {
        if (user == null) return null;

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

}
