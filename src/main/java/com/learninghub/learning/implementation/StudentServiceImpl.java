package com.learninghub.learning.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learninghub.learning.model.Student;
import com.learninghub.learning.repository.StudentRepository;
import com.learninghub.learning.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public String greetStudent(String name) {
        return "Welcome " + name;
    }

    @Override
    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepository.findAll();
    }
}
