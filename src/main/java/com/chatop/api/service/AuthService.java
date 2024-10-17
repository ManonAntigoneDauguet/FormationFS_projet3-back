package com.chatop.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chatop.api.repository.AuthRepository;

import lombok.Data;

@Data
@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
}
