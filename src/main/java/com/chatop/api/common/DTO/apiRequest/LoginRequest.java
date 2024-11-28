package com.chatop.api.common.DTO.apiRequest;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

	@NotBlank(message = "email is required")
	private String email;

	@NotBlank(message = "password is required")
	private String password;
}