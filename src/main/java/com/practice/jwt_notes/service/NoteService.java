package com.practice.jwt_notes.service;

import com.practice.jwt_notes.entity.Note;
import com.practice.jwt_notes.entity.User;
import com.practice.jwt_notes.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public List<Note> getUserNotes(User user) {
        return noteRepository.findByUser(user);
    }

    public void delete(Long id) {
        noteRepository.deleteById(id);
    }
}
