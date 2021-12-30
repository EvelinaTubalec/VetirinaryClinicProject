package com.leverx.services;

import com.leverx.model.Note;
import com.leverx.repositories.imp.NoteRepositoryImpl;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;

import java.util.List;

public class NoteService {

    private final NoteRepositoryImpl noteRepository = new NoteRepositoryImpl();
    private static final Logger log = LoggerFactory.logger(NoteService.class);

    public Note findNote(Long id) {
        log.debug("Find note by id " + id);
        return noteRepository.findById(id);
    }

    public void saveNote(Note note) {
        log.debug("Save note");
        noteRepository.create(note);
    }

    public void deleteNote(Long id) {
        log.debug("Delete note by id " + id);
        noteRepository.delete(id);
    }

    public void updateNote(Note note) {
        log.debug("Update note");
        noteRepository.update(note);
    }

    public List<Note> findAllNotes() {
        log.debug("Find notes");
        return noteRepository.findAll();
    }
}
