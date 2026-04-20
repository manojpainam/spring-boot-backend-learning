package com.learninghub.learning.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
