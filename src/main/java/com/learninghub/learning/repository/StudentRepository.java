package com.learninghub.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learninghub.learning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}