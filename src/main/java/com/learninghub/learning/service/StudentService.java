package com.learninghub.learning.service;

import org.springframework.data.domain.Page;

import com.learninghub.learning.model.Student;

public interface StudentService {

    public Student createStudent(Student student);

    public Page<Student> getStudentList(int page, int size, String sortBy, boolean ascending, String search);

    public Student getStudent(int id);

    public Student updateStudent(int id, Student student);

    public String deleteStudent(int id);
}
