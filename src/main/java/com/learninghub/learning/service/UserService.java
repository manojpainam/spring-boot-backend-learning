package com.learninghub.learning.service;

import com.learninghub.learning.model.User;

public interface UserService {
    User register(User user);

    public User login(String username, String password);
}