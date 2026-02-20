package com.practice.jwt_notes.repository;

import com.practice.jwt_notes.entity.Note;
import com.practice.jwt_notes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);
}
