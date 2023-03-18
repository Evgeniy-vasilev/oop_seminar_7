package model;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();

    String createNote(Note user);

    void saveNotes(List<Note> notes);

    void deleteNote(Note note);

    void updateNote(String noteId, Note note) throws Exception;
}
