package com.nemo.NotesAPI;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Note> getAllNotes() {
        return new ArrayList<>(notes.values());
    }

    public Optional<Note> getNoteById(long id) {
        return Optional.ofNullable(notes.get(id));
    }

    public Note createNote(NoteRequest request) {
        long id = idGenerator.getAndIncrement();
        LocalDateTime now = LocalDateTime.now();

        Note note = new Note();
        note.setId(id);
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setCreatedAt(now);
        note.setUpdatedAt(now);

        notes.put(id, note);
        return note;
    }


    public Optional<Note> updateNote(Long id, NoteRequest request) {
        Note existing = notes.get(id);
        LocalDateTime now = LocalDateTime.now();
        if (existing == null){
            return Optional.empty();
        }
        existing.setTitle(request.getTitle());
        existing.setContent(request.getContent());
        existing.setUpdatedAt(now);
        return Optional.of(existing);
    }

    public boolean deleteNote(Long id){
        return notes.remove(id) != null;
    }
}
