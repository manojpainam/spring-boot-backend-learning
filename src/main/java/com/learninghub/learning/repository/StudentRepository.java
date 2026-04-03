package com.learninghub.learning.repository;

import java.util.List;

import com.learninghub.learning.model.Student;

public interface StudentRepository {
    public void save(Student student);

    public List<Student> findAll();
}
