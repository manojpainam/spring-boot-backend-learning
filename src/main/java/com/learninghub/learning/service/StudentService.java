package com.learninghub.learning.service;

import com.learninghub.learning.model.Student;

public interface StudentService {
    public String greetStudent(String name);
    
    public Student getStudent();

    public Student createStudent(Student student);
}
