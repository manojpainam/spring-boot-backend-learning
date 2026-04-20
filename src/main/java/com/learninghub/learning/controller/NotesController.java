package com.learninghub.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.model.Note;
import com.learninghub.learning.service.NoteService;

@RestController
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;
    
    @GetMapping
    public ApiResponse<List<Note>> getNotes(@RequestParam Integer userId) {
        List<Note> notes = noteService.getNotes(userId);
        return new ApiResponse<List<Note>>(false, "Notes fetched successfully", notes);
    }

    @PostMapping
    public ApiResponse<Note> createNotes(@RequestBody Note note) {
        Note savedNote = noteService.createNote(note);
        return new ApiResponse<>(false, "Created a new note", savedNote);
    }
}
