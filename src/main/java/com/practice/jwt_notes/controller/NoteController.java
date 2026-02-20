package com.practice.jwt_notes.controller;

import com.practice.jwt_notes.entity.Note;
import com.practice.jwt_notes.entity.User;
import com.practice.jwt_notes.service.NoteService;
import com.practice.jwt_notes.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;
    private final UserService userService;

    @PostMapping
    public Note create(@RequestBody Note note, Authentication authentication) {

        String username = authentication.getName();

        User user = userService.findByUsername(username);

        note.setUser(user);

        return noteService.create(note);
    }

    @GetMapping
    public List<Note> getUserNotes(Authentication authentication) {

        String username = authentication.getName();

        User user = userService.findByUsername(username);

        return noteService.getUserNotes(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        noteService.delete(id);
        return "Deleted successfully";
    }
}
