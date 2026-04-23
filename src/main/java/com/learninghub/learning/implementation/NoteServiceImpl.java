package com.learninghub.learning.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.learninghub.learning.exception.StudentExceptions;
import com.learninghub.learning.model.Note;
import com.learninghub.learning.model.User;
import com.learninghub.learning.repository.NoteRepository;
import com.learninghub.learning.repository.UserRepository;
import com.learninghub.learning.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository notesRepo;

    @Autowired
    private UserRepository userRepo;

    public List<Note> getNotes(Integer userId){
        List<Note> note = notesRepo.findAllByUserId(userId);
        return note;
    }

    public Note createNote(Note note) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepo.findByUsername(auth.getName())
             .orElseThrow(() -> new StudentExceptions("Requested user doesn't exists"));

        note.setUser(user);

        return notesRepo.save(note);
    }

    public Note updateNote(Integer id, Note note) {

        User user = getCurrentUser();

        Note existingNote = notesRepo.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new StudentExceptions("Note not found or not owned by user"));

        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());

        return existingNote;
    }

    public void deleteNotes(Integer id) {

        User user = getCurrentUser();

        Note existingNote = notesRepo.findByIdAndUserId(id, user.getId())
                .orElseThrow(() -> new StudentExceptions("Note not found or not owned by user"));

        notesRepo.delete(existingNote);
    }

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return userRepo.findByUsername(auth.getName())
                .orElseThrow(() -> new StudentExceptions("User not found"));
    }

    public Page<Note> getAllNotes(int page, int size, String sortBy, boolean ascending, String search) {
        Sort sort = ascending ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        if(search == null || search.trim().isEmpty()) {
            return notesRepo.findAll(pageable);
        }

        return notesRepo.searchNotes(search, pageable);

    }
}
