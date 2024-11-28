package com.chatop.api.controller;

import com.chatop.api.service.UserService;
import com.chatop.api.common.DTO.apiRequest.LoginRequest;
import com.chatop.api.common.DTO.apiRequest.UserRequestDTO;
import com.chatop.api.common.DTO.apiResponse.ApiTokenResponse;
import com.chatop.api.common.DTO.apiResponse.UserResponseDTO;
import com.chatop.api.configuration.security.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<ApiTokenResponse> register(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        userService.register(userRequestDTO);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword(userRequestDTO.getPassword());
        loginRequest.setEmail(userRequestDTO.getEmail());

        return login(loginRequest);
    }

    /**
     * Try to login the user with his email and password. Returns a token in case of success
     *
     * @param loginRequest as LoginRequest
     * @return token
     */
    @PostMapping("/auth/login")
    public ResponseEntity<ApiTokenResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        String token = jwtService.generateToken(authentication);

        return ResponseEntity.ok(new ApiTokenResponse(token));
    }

    /**
     * Allows to access at the connected profile
     *
     * @return user's information
     */
    @GetMapping("/auth/me")
    public ResponseEntity<UserResponseDTO> getProfile() {
        UserResponseDTO user = userService.getUserByAuthentication();
        return ResponseEntity.ok(user);
    }

}
