package com.learninghub.learning.implementation;

import org.springframework.stereotype.Service;

import com.learninghub.learning.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    public String greetStudent(String name) {
        return "Welcome " + name;
    }
}
