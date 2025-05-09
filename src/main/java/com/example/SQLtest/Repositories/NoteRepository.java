package com.example.SQLtest.Repositories;

import com.example.SQLtest.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Custom query methods can be defined here if needed
    List<Note> findByTitleContainingIgnoreCase(String title);
    List<Note> findByContentContaining(String keywords);
    List<Note> findByTagsContaining(String keyword);
    List<Note> findByTitleContainingIgnoreCaseAndTagsContaining(String title, String keyword);
    List<Note> findByTitleContainingIgnoreCaseAndContentContaining(String title, String content);
}
