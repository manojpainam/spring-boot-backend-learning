package com.learninghub.learning.implementation;

import org.springframework.stereotype.Service;

import com.learninghub.learning.model.Student;
import com.learninghub.learning.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
    public String greetStudent(String name) {
        return "Welcome " + name;
    }

    public Student getStudent() {
        Student student = new Student("Manoj", 24);
        return student;
    }

    public Student createStudent(Student student) {
        return student;
    }
}
