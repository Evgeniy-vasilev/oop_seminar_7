package model;

import controllers.NoteController;

import java.util.ArrayList;
import java.util.List;

public class RepositoryFile extends NoteController implements Repository {
    private NoteMapper mapper;
    private FileOperation fileOperation;

    public RepositoryFile(FileOperation fileOperation) {
        this(fileOperation, new NoteMapper());
    }

    public RepositoryFile(FileOperation fileOperation, NoteMapper noteMapper) {
        this.fileOperation = fileOperation;
        this.mapper = noteMapper;
    }

    public void saveNotes(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Note note) {

        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveNotes(notes);
        return id;
    }

    @Override
    public void deleteNote(Note note) {
        List<String> lines = new ArrayList<>();
        List<Note> notes = getAllNotes();
        for (Note item : notes) {
            if (!note.getId().equals(item.getId()))
                lines.add(mapper.map(item));
        }

        fileOperation.saveAllLines(lines);
        System.out.println("Запись удалена!");
    }

    @Override
    public void updateNote(String noteId, Note newNote) throws Exception {
        List<Note> notes = repository.getAllNotes();
        Note note = noteSearch(noteId, notes);
        note.setHeader(newNote.getHeader());
        note.setText(newNote.getText());
        saveNote(newNote);
        System.out.println("Запись изменена!");
    }
}
