package Logger;

import model.Note;
import model.Repository;

import java.util.List;

public class Decorator implements Repository {
    private Repository repo;
    private LoggerTerminal logger;

    public Decorator(Repository repo, LoggerTerminal logger) {
        this.repo = repo;
        this.logger = logger;
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> lst = repo.getAllNotes();
        return lst;
    }

    @Override
    public String createNote(Note note) {
        String res = repo.createNote(note);
        logger.logg("Дата создания: ");
        return res;
    }

    @Override
    public void saveNotes(List<Note> notes) {
        repo.saveNotes(notes);
        logger.logg("Дата сохранения: ");
    }

    @Override
    public void deleteNote(Note note) {
        repo.deleteNote(note);
        logger.logg("Дата удаления: ");
    }

    @Override
    public void updateNote(String noteId, Note note) throws Exception {
        repo.updateNote(noteId, note);
        logger.logg("Дата изменения: ");
    }
}
