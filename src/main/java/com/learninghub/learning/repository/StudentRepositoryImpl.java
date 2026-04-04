package com.learninghub.learning.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.learninghub.learning.model.Student;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private int counter = 1;

    private final List<Student> students = new ArrayList<>();
    public void save(Student student) {
        student.setId(counter++);
        students.add(student);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    public Student findStudentById(int id) {
        for (Student student : students) {
            if(student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
