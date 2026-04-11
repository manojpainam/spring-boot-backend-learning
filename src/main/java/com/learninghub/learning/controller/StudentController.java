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
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.model.Student;
import com.learninghub.learning.service.StudentService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/students")
public class StudentController {
    
    @Autowired StudentService studentService;
    
    @GetMapping
    public ApiResponse<List<Student>> getStudents() {
        return new ApiResponse<>(false, "students fetched successfully", studentService.getStudentList());
    }

    @PostMapping
    public ApiResponse<Student> createStudent(@Valid @RequestBody Student student) {
        return new ApiResponse<Student>(false, "created sudent successfully", studentService.createStudent(student));
    }

    @GetMapping("/{id}")
    public ApiResponse<Student> getStudent(@PathVariable int id) {
        return new ApiResponse<Student>(false, "student fetched successfully", studentService.getStudent(id));
    }

    @PutMapping("{id}")
    public ApiResponse<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student student) {
        return new ApiResponse<Student>(false, "student updated successfully", studentService.updateStudent(id, student));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Student> deleteStudent(@PathVariable int id) {
        return new ApiResponse<Student>(false, studentService.deleteStudent(id), null) ;
    }
    
}
