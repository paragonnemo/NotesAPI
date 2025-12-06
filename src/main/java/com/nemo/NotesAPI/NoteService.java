package com.nemo.NotesAPI;

import org.springframework.stereotype.Service;

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

    public Note createNote(Note note) {
        long id = idGenerator.getAndIncrement();
        note.setId(id);
        notes.put(id, note);
        return note;
    }

    public Optional<Note> updateNote(Long id, Note updated) {
        Note existing = notes.get(id);
        if (existing == null){
            return Optional.empty();
        }
        existing.setTitle(updated.getTitle());
        existing.setContent(updated.getContent());
        return Optional.of(existing);
    }

    public boolean deleteNote(Long id){
        return notes.remove(id) != null;
    }
}
