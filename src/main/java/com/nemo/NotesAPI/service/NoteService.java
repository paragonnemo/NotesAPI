package com.nemo.NotesAPI.service;

import com.nemo.NotesAPI.note.Note;
import com.nemo.NotesAPI.note.NoteRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NoteService {

    Page<Note> getAllNotes(Pageable pageable);

    Optional<Note> getNoteById(Long id);

    Note createNote(NoteRequest request);

    Optional<Note> updateNote(Long id, NoteRequest request);

    boolean deleteNote(Long id);
}
