package com.chatop.api.service.DTO.apiRequest;

import lombok.Data;

@Data
public class LoginRequest {
	
	private String email;
	
	private String password;
}
