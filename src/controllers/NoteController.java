package controllers;

import model.Note;
import model.Repository;
import views.IViewCommands;


import java.util.List;

public class NoteController {
    protected Repository repository;

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public NoteController() {
    }

    public void saveNote(Note note) throws Exception {
        repository.createNote(note);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        Note note = noteSearch(noteId, notes);
        return note;
    }

    public static Note noteSearch(String noteId, List<Note> notes) throws Exception {
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Заметка не найдена");
    }

    public List<Note> readAllNotes() {
        return repository.getAllNotes();
    }

    public void updateNote(String noteId, Note newNote) throws Exception {
        repository.updateNote(noteId, newNote);
    }

    public void deleteNote(Note note) {
        repository.deleteNote(note);
    }
}
