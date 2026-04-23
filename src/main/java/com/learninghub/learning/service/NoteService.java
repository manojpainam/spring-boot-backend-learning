package com.learninghub.learning.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.learninghub.learning.model.Note;

public interface NoteService {
    List<Note> getNotes(Integer userId);

    Note createNote(Note note);

    Note updateNote(Integer id, Note note);

    void deleteNotes(Integer id);

    Page<Note> getAllNotes(int page, int size, String sortBy, boolean ascending, String search);
}
