package com.learninghub.learning.service;

import java.util.List;

import com.learninghub.learning.model.Student;

public interface StudentService {
    public String greetStudent(String name);

    public Student createStudent(Student student);

    public List<Student> getStudentList();
}
