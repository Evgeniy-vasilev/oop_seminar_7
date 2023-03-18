package views;

import controllers.NoteController;
import model.Note;

import java.util.List;
import java.util.Scanner;

public class ViewCommands implements IViewCommands {

    private NoteController noteController;

    public ViewCommands(NoteController controller) {
        this.noteController = controller;
    }

    public void deleteNote() throws Exception {
        String noteId = prompt("Введите ID заметки для удаления: ");
        Note _note = noteController.readNote(noteId);
        noteController.deleteNote(_note);
    }

    public void updateNote() throws Exception {
        String readId = prompt("Введите ID заметки для редактирования: ");
        noteController.updateNote(readId, inputNote());
    }

    public void list() {
        List<Note> listNotes = noteController.readAllNotes();
        for (Note note : listNotes) {
            System.out.println(note + "\n");
        }
    }

    public void read() throws Exception {
        String id = prompt("ID заметки: ");
        Note note = noteController.readNote(id);
        System.out.println(note);
    }

    public void create() throws Exception {
        noteController.saveNote(inputNote());
    }

    private Note inputNote() {
        String header = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        return new Note(header, text);
    }

    public void help() {
        System.out.println("Список команд: ");
        for (Commands com : Commands.values()) {
            System.out.println(com);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
