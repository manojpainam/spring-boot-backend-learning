package com.learninghub.learning.implementation;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learninghub.learning.exception.StudentExceptions;
import com.learninghub.learning.model.User;
import com.learninghub.learning.repository.UserRepository;
import com.learninghub.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new StudentExceptions("Email already registered");
        }

        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}