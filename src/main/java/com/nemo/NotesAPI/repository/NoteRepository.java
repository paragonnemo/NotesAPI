package com.nemo.NotesAPI.repository;

import com.nemo.NotesAPI.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository  extends JpaRepository<Note,Long> {
}
