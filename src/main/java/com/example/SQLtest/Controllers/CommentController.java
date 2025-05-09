package com.example.SQLtest.Controllers;

import com.example.SQLtest.Models.Comment;
import com.example.SQLtest.Services.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{noteId}")
    public Comment addComment(@PathVariable Long noteId, @RequestBody Comment comment) {
        return commentService.addComment(noteId, comment.getContent());
    }

    @GetMapping("/{noteId}")
    public List<Comment> getComments(@PathVariable Long noteId) {
        return commentService.getCommentsByNoteId(noteId);
    }
}
