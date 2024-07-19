package com.example.notesapi.repository;

import org.springframework.stereotype.Repository;

import com.example.notesapi.model.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class NoteRepository {
    private List<Note> notes = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    public List<Note> findAll() {
        return notes;
    }

    public Optional<Note> findById(Long id) {
        return notes.stream().filter(note -> note.getId().equals(id)).findFirst();
    }

    public Note save(Note note) {
        note.setId(counter.incrementAndGet());
        notes.add(note);
        return note;
    }

    public void deleteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }

    public void update(Note note) {
        deleteById(note.getId());
        notes.add(note);
    }
}
