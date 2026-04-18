package com.learninghub.learning.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.learninghub.learning.exception.StudentExceptions;
import com.learninghub.learning.model.User;
import com.learninghub.learning.repository.UserRepository;
import com.learninghub.learning.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private UserRepository userRepository;
    
    public User getUserProfile() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User  user = userRepository.findByUsername(username)
                .orElseThrow(() -> new StudentExceptions("Requested user doesn't exists"));
        return user;
    }
}
