package com.example.SQLtest.Controllers;

import com.example.SQLtest.DTOs.NoteDTO;
import com.example.SQLtest.Models.Note;
import com.example.SQLtest.Services.NoteService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Marks this class as a REST controller
@RequestMapping("/notes")  // Base URL for all endpoints in this controller
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping  // Endpoint to retrieve all notes
    public List<Note> getAllNotes() {
        return noteService.getALlNotes();
    }

    @GetMapping("/{id}")  // Endpoint to retrieve a note by its ID
    public Note getNoteById(@Valid @PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping  // Endpoint to create a new note
    public Note createNote(@Valid @RequestBody NoteDTO note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}")  // Endpoint to update an existing note
    public Note updateNote(@PathVariable Long id, @Valid @RequestBody NoteDTO note) {
        return noteService.updateNote(id, note);
    }

    @DeleteMapping("/{id}")  // Endpoint to delete a note by its ID
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
    }

    @GetMapping("/search")  // Endpoint to search notes by tags
    public List<Note> searchNotesTag(@Valid @RequestParam String tags) {
        return noteService.searchNotesByTag(tags);
    }
}
