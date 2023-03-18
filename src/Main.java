import Logger.Decorator;
import Logger.LoggerTerminal;
import controllers.NoteController;
import model.FileOperation;
import model.FileOperationImpl;
import model.Repository;
import model.RepositoryFile;
import views.IViewCommands;
import views.ViewCommands;
import views.ViewNote;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new Decorator(new RepositoryFile(fileOperation), new LoggerTerminal());
        NoteController controller = new NoteController(repository);
        IViewCommands viewCommands = new ViewCommands(controller);
        ViewNote view = new ViewNote(viewCommands);
        view.run();
    }
}