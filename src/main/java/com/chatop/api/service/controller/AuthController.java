package com.chatop.api.service.controller;

import com.chatop.api.business.service.UserService;
import com.chatop.api.service.DTO.apiRequest.UserRequestDTO;
import com.chatop.api.service.DTO.apiRequest.LoginRequest;
import com.chatop.api.service.DTO.apiResponse.ApiMessageResponse;
import com.chatop.api.service.DTO.apiResponse.ApiResponse;
import com.chatop.api.service.DTO.apiResponse.ApiTokenResponse;
import com.chatop.api.service.service.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    public JWTService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * Allows to add a new user
     *
     * @param userRequestDTO as the user to create
     * @return JWT token
     */
    @PostMapping("auth/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.register(userRequestDTO);
        return ResponseEntity.ok(new ApiMessageResponse("REGISTRER !")); // Must to return a token
    }

    /**
     * Try to login the user with his email and password. Returns a token in case of success
     *
     * @param loginRequest
     * @return token
     */
    @PostMapping("/auth/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            String token = jwtService.generateToken(authentication);
            return ResponseEntity.ok(new ApiTokenResponse(token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiMessageResponse("error"));
        }
    }

    /**
     * Allows to access at the connected profile
     *
     * @return user's informations
     */
//	@PostMapping("/auth/me")
//	public User getProfile() {
//
//	}

}
