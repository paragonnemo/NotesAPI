package com.nemo.NotesAPI.service;

import com.nemo.NotesAPI.note.Note;
import com.nemo.NotesAPI.note.NoteRequest;
import com.nemo.NotesAPI.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Page<Note> getAllNotes(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note createNote(NoteRequest request) {
        LocalDateTime now = LocalDateTime.now();
        Note note = new Note(request.getTitle(), request.getContent(), now, now);
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> updateNote(Long id, NoteRequest request) {
        return noteRepository.findById(id).map(existing -> {
            existing.setTitle(request.getTitle());
            existing.setContent(request.getContent());
            existing.setUpdatedAt(LocalDateTime.now());
            return noteRepository.save(existing);
        });
    }

    @Override
    public boolean deleteNote(Long id){
        if (!noteRepository.existsById(id)){
            return false;
        }
        noteRepository.deleteById(id);
        return true;
    }

}
