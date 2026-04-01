package com.learninghub.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/student")
public class StudentController {
    
    @Autowired StudentService studentService;

    @GetMapping("/greet")
    public String greetStudent(@RequestParam(defaultValue = "Student") String name) {
        return studentService.greetStudent(name);
    }
    
}
