package com.leverx.servlets;

import com.leverx.model.Animal;
import com.leverx.model.Note;
import com.leverx.model.Vet;
import com.leverx.services.AnimalService;
import com.leverx.services.NoteService;
import com.leverx.services.VetService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/notes")
public class NoteServlet extends HttpServlet {

    public static final String DATA = "data";
    public static final String TEXT = "text";
    public static final String VET_ID = "vetId";
    public static final String ANIMAL_ID = "animalId";
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    public static final String NOTE_ID = "noteId";

    private final AnimalService animalService = new AnimalService();
    private final VetService vetService = new VetService();
    private final NoteService noteService = new NoteService();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteService.findAllNotes();
        for (Note note : notes) {
            PrintWriter writer = resp.getWriter();
            writer.println(note);
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stringDate = req.getParameter(DATA);
        String text = req.getParameter(TEXT);
        String stringVetId = req.getParameter(VET_ID);
        String stringAnimalId = req.getParameter(ANIMAL_ID);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate date = LocalDate.parse(stringDate, formatter);

        Long vetId = Long.parseLong(stringVetId);
        Long animalId = Long.parseLong(stringAnimalId);

        Vet vet = vetService.findVet(vetId);
        Animal animal = animalService.findAnimal(animalId);
        Note note = new Note(text, date, animal, vet);
        noteService.saveNote(note);
        PrintWriter writer = resp.getWriter();
        writer.print("The note was created!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long noteId = Long.parseLong(req.getParameter(NOTE_ID));
        String text = req.getParameter(TEXT);
        String stringDate = req.getParameter(DATA);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YYYY);
        LocalDate date = LocalDate.parse(stringDate, formatter);

        Note note = noteService.findNote(noteId);
        note.setText(text);
        note.setDate(date);
        noteService.updateNote(note);
        PrintWriter writer = resp.getWriter();
        writer.print("The note was updated!");
    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter(NOTE_ID);
        PrintWriter writer = resp.getWriter();
        Long noteId = Long.parseLong(id);
        animalService.deleteAnimal(noteId);
        writer.print("The note was removed!");
    }
}
