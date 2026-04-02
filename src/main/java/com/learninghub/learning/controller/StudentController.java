package com.learninghub.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.model.Student;
import com.learninghub.learning.service.StudentService;


@RestController
@RequestMapping("api/students")
public class StudentController {
    
    @Autowired StudentService studentService;

    @GetMapping("/greet")
    public String greetStudent(@RequestParam(defaultValue = "Student") String name) {
        return studentService.greetStudent(name);
    }

    @GetMapping
    public Student getStudent() {
        return studentService.getStudent();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/list")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }
    
}
