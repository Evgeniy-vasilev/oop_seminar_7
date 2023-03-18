package views;

public interface IViewCommands {
    void read() throws Exception;

    void deleteNote() throws Exception;

    void updateNote() throws Exception;

    void list() throws Exception;

    void create() throws Exception;

    void help();

    String prompt(String message);
}
