package com.learninghub.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.model.User;
import com.learninghub.learning.service.ProfileService;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    private ProfileService profle;
    
    @GetMapping
    public ApiResponse<User> getUserProfile() {
        User user = profle.getUserProfile();
        return new ApiResponse<>(false, "User fetched successfully", user);
    }
}
