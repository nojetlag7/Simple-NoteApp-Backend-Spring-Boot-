package com.example.SQLtest.Repositories;

import com.example.SQLtest.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    // Custom query methods can be defined here if needed
    List<Comment> findByNoteId(Long noteId);  // Find comments by note ID
}
