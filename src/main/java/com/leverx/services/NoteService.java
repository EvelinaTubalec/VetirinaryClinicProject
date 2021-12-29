package com.leverx.services;

import com.leverx.model.Note;
import com.leverx.repositories.imp.NoteRepositoryImpl;

import java.util.List;

public class NoteService {

    NoteRepositoryImpl noteRepository = new NoteRepositoryImpl();

    public Note findNote(Long id) {
        return noteRepository.findById(id);
    }

    public void saveNote(Note note) {
        noteRepository.create(note);
    }

    public void deleteNote(Long id) {
        noteRepository.delete(id);
    }

    public void updateNote(Note note) {
        noteRepository.update(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }
}
