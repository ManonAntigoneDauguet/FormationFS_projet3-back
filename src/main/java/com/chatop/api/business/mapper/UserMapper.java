package com.chatop.api.business.mapper;

import com.chatop.api.business.entity.User;
import com.chatop.api.service.DTO.apiRequest.UserRequestDTO;
import com.chatop.api.service.DTO.apiResponse.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    /**
     * Converts a UserDTO object into a User object
     *
     * @param userRequestDTO as the UserDTO to convert
     * @return User
     */
    public User convertToEntity(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }

    /**
     * Converts a User object into a UserResponseDTO object
     *
     * @param user as the User to convert
     * @return UserResponseDTO
     */
    public UserResponseDTO convertToResponseDTO(User user) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setId(user.getId());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setCreatedAt(user.getCreatedAt());
        responseDTO.setUpdatedAt(user.getUpdatedAt());

        return responseDTO;
    }

}
