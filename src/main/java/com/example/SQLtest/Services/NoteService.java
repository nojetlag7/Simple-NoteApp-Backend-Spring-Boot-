package com.example.SQLtest.Services;

import com.example.SQLtest.DTOs.NoteDTO;
import com.example.SQLtest.Exceptions.NoteNotFoundException;
import com.example.SQLtest.Models.Note;
import com.example.SQLtest.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service  // Marks this class as a service layer component
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    // Retrieve all notes from the database
    public List<Note> getALlNotes() {
        return noteRepository.findAll();
    }

    // Retrieve a note by its ID
    public Note getNoteById(long id) {
        return noteRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    // Create a new note
    public Note createNote(NoteDTO noteDto) {
        Note note = DTOtoNote(noteDto);
        return noteRepository.save(note);
    }

    // Update an existing note
    public Note updateNote(Long id, NoteDTO noteDto) {
        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        existingNote.setTitle(noteDto.getTitle());
        existingNote.setContent(noteDto.getContent());
        existingNote.setTags(noteDto.getTags());
        existingNote.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(existingNote);
    }

    // Delete a note by its ID
    public void deleteNote(long id) {
        noteRepository.deleteById(id);
    }

    // Search notes by tags
    public List<Note> searchNotesByTag(String tags) {
        return noteRepository.findByTagsContaining(tags);
    }

    // Convert a NoteDTO to a Note entity
    public Note DTOtoNote(NoteDTO noteDto) {
        Note newNote = new Note();
        newNote.setTitle(noteDto.getTitle());
        newNote.setContent(noteDto.getContent());
        newNote.setTags(noteDto.getTags());
        return newNote;
    }

    // Convert a Note entity to a NoteDTO
    public NoteDTO NoteToDTO(Note note) {
        NoteDTO noteDto = new NoteDTO();
        noteDto.setTitle(note.getTitle());
        noteDto.setContent(note.getContent());
        noteDto.setTags(note.getTags());
        return noteDto;
    }
}
