package com.example.SQLtest.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SQLtest.DTOs.NoteDTO;
import com.example.SQLtest.Models.Note;
import com.example.SQLtest.Services.NoteService;

import jakarta.validation.Valid;

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
    public ResponseEntity<Note>getNoteById(@Valid @PathVariable Long id) {
        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(note); //200
    }

    @PostMapping  // Endpoint to create a new note
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteDTO note) {
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote); //201
    }

    @PutMapping("/{id}")  // Endpoint to update an existing note
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @Valid @RequestBody NoteDTO note) {
        Note Updatednote = noteService.updateNote(id, note);
        return ResponseEntity.ok(Updatednote); //200
    }

    @DeleteMapping("/{id}")  // Endpoint to delete a note by its ID
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build(); //204
    }

    @GetMapping("/search")  // Endpoint to search notes by tags
    public List<Note> searchNotesTag(@Valid @RequestParam String tags) {
        return noteService.searchNotesByTag(tags);
    }
}

//error codes
/*
  1XX = informational error
  2XX = success
  3XX = redirection
  4XX = client error
  5XX = server error

  (201 = created,200 OK, 204 No Content, 400 Bad Request, 401 Unauthorized, 403 Forbidden, 404 Not Found, 500 Internal Server Error)

 */