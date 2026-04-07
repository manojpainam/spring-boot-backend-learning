package com.learninghub.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public List<Student> getStudents() {
        return studentService.getStudentList();
    }

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/list")
    public List<Student> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("update/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
    
}
