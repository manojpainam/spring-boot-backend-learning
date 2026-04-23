package com.learninghub.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/user")
    public ApiResponse<List<Note>> getNotes(@RequestParam Integer userId) {
        List<Note> notes = noteService.getNotes(userId);
        return new ApiResponse<List<Note>>(false, "Notes fetched successfully", notes);
    }

    @PostMapping
    public ApiResponse<Note> createNotes(@RequestBody Note note) {
        Note savedNote = noteService.createNote(note);
        return new ApiResponse<>(false, "Created a new note", savedNote);
    }

    @PutMapping("/{id}")
    public ApiResponse<Note> updateNotes(@PathVariable Integer id, @RequestBody Note note) {
        Note updatedNote = noteService.updateNote(id, note);
        return new ApiResponse<Note>(false, "Updated Notes successfully", updatedNote);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Note> deleteNotes(@PathVariable Integer id) {
        noteService.deleteNotes(id);
        return new ApiResponse<Note>(false, "Notes deleted successfully", null);
    }

    @GetMapping
    public ApiResponse<Page<Note>> getAllNotes(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "true") boolean ascending,
        @RequestParam(defaultValue = "") String search
    ) {
        return new ApiResponse<Page<Note>>(false, "Notes deleted successfully", noteService.getAllNotes(page, size, sortBy, ascending, search));
    }
}
