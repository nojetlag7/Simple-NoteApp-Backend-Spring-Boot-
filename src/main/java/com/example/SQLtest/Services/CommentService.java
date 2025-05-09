package com.example.SQLtest.Services;

import com.example.SQLtest.Exceptions.NoteNotFoundException;
import com.example.SQLtest.Models.Comment;
import com.example.SQLtest.Models.Note;
import com.example.SQLtest.Repositories.CommentRepo;
import com.example.SQLtest.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private NoteRepository noteRepo;

    public Comment addComment(Long noteId, String content) {
        Note note = noteRepo.findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        Comment comment = new Comment();
        comment.setContent(content);
        comment.setNote(note);

        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsByNoteId(Long noteId) {
        return commentRepo.findByNoteId(noteId);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepo.findById(commentId)
                .orElseThrow(() -> new NoteNotFoundException(commentId));
        commentRepo.delete(comment);

    }

}
