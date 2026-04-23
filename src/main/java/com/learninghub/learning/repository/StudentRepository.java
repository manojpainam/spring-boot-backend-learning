package com.learninghub.learning.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learninghub.learning.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
    @Query("SELECT s FROM Student s WHERE " +
       "LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Student> searchStudent(@Param("search") String search, Pageable pageable);
}