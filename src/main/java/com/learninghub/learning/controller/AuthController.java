package com.learninghub.learning.controller;

import org.springframework.web.bind.annotation.*;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.model.User;
import com.learninghub.learning.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
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
}