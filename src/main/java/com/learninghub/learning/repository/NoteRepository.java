package com.learninghub.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learninghub.learning.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(Integer userId);  
}