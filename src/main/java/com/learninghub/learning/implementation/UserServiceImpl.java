package com.learninghub.learning.implementation;

import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learninghub.learning.exception.StudentExceptions;
import com.learninghub.learning.model.Role;
import com.learninghub.learning.model.User;
import com.learninghub.learning.repository.RoleRepository;
import com.learninghub.learning.repository.UserRepository;
import com.learninghub.learning.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User register(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new StudentExceptions("Email already registered");
        }

        Role userRole = roleRepository.findByName("USER")
        .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Set.of(userRole));

        return userRepository.save(user);
    }

    @Override
    public User login(String username, String password) {
        User  existingUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new StudentExceptions("Requested user doesn't exists"));

        if(!encoder.matches(password, existingUser.getPassword())) {
            throw new StudentExceptions("Password is Incorrect!");
        }

        return existingUser;
    }
}