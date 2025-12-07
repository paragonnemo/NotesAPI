package com.nemo.NotesAPI.controller;

import com.nemo.NotesAPI.service.NoteService;
import com.nemo.NotesAPI.service.NoteServiceImpl;
import com.nemo.NotesAPI.exception.NoteNotFoundException;
import com.nemo.NotesAPI.note.Note;
import com.nemo.NotesAPI.note.NoteRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteServiceImpl noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public Page<Note> getAllNotes(Pageable pageable) {
        return noteService.getAllNotes(pageable);
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@Valid @RequestBody NoteRequest request) {
        Note created = noteService.createNote(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity
                .created(location)
                .body(created);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id,
                           @Valid @RequestBody NoteRequest request) {
        return noteService.updateNote(id, request)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        boolean deleted = noteService.deleteNote(id);
        if(!deleted){
            throw new NoteNotFoundException(id);
        }
        return noContent().build();
    }

}