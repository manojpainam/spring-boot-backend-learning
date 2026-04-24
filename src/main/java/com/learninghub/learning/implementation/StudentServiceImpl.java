package com.learninghub.learning.implementation;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.learninghub.learning.exception.StudentExceptions;
import com.learninghub.learning.model.Student;
import com.learninghub.learning.repository.StudentRepository;
import com.learninghub.learning.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String greetStudent(String name) {
        return "Welcome " + name;
    }

    @Override
    public Student createStudent(Student student) {
        student.setCreatedAt(LocalDateTime.now());
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudentList(int page, int size, String sortBy, boolean ascending, String search) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        if(search == null || search.trim().isEmpty()) {
            return studentRepository.findAll(pageable);
        }
        return studentRepository.searchStudent(search, pageable);
    }

    @Override
    public Student getStudent(int id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentExceptions("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(int id, Student student) {
        Student existingStudent = getStudent(id);

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());

        return studentRepository.save(existingStudent);
    }

    @Override
    public String deleteStudent(int id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentExceptions("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return "student deleted";
    }
}