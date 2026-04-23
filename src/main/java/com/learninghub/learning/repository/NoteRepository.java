package com.learninghub.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learninghub.learning.model.Note;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllByUserId(Integer userId);
    
    Optional<Note> findByIdAndUserId(Integer id, Integer userId);

    @Query(
        "SELECT n FROM Note n WHERE " + 
        "LOWER (n.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
        "LOWER(n.content) LIKE LOWER(CONCAT('%', :search, '%'))"
    )
    Page<Note> searchNotes(String search, Pageable page);
}