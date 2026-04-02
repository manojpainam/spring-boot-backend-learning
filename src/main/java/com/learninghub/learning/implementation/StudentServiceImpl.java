package com.learninghub.learning.implementation;

import java.util.ArrayList;
import java.util.List;

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

    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Manoj", 24));
        students.add(new Student("Vamshi", 20));
        return students;
    }
}
