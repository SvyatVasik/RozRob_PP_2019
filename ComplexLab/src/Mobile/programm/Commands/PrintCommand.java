package Mobile.programm.Commands;

import Mobile.programm.Database;

public class PrintCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public PrintCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.printMenu();
    }
}
