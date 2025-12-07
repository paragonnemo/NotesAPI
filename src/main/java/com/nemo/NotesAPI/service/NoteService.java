package com.nemo.NotesAPI.service;

import com.nemo.NotesAPI.note.Note;
import com.nemo.NotesAPI.note.NoteRequest;
import com.nemo.NotesAPI.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(long id) {
        return noteRepository.findById(id);
    }

    public Note createNote(NoteRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Note note = new Note(request.getTitle(), request.getContent(), now, now);
        return noteRepository.save(note);
    }


    public Optional<Note> updateNote(Long id, NoteRequest request) {
        return noteRepository.findById(id).map(existing -> {
            existing.setTitle(request.getTitle());
            existing.setContent(request.getContent());
            existing.setUpdatedAt(LocalDateTime.now());
            return noteRepository.save(existing);
        });
    }

    public boolean deleteNote(Long id){
        if (!noteRepository.existsById(id)){
            return false;
        }
        noteRepository.deleteById(id);
        return true;
    }
}
