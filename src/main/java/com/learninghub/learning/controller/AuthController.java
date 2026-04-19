package com.learninghub.learning.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.dto.AuthResponse;
import com.learninghub.learning.model.User;
import com.learninghub.learning.security.JwtUtil;
import com.learninghub.learning.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ApiResponse<User> register(@Valid @RequestBody User user) {

        User savedUser = userService.register(user);

        return new ApiResponse<>(
                false,
                "User registered successfully",
                savedUser
        );
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(String username, String password) {
        User user = userService.login(username, password);

        String token = jwtUtil.generateToken(user);

        return new ApiResponse<>(false, "Login Successful", new AuthResponse(token));
    }
}