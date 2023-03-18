package views;

public class ViewNote {

    private final IViewCommands viewCommands;

    public ViewNote(IViewCommands viewCommands) {
        this.viewCommands = viewCommands;
    }

    public void run() {
        Commands com;

        while (true) {
            String command = viewCommands.prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE -> viewCommands.create();
                    case READ -> viewCommands.read();
                    case LIST -> viewCommands.list();
                    case UPDATE -> viewCommands.updateNote();
                    case DELETE -> viewCommands.deleteNote();
                    case HELP -> viewCommands.help();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
