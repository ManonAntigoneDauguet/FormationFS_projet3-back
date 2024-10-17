package com.chatop.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class LoginRequest {
	
	private String email;
	
	private String password;
}
