package Mobile.programm.Commands;

import Mobile.programm.Database;

import java.io.FileNotFoundException;

public class CreateClientCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public CreateClientCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() throws FileNotFoundException {
        database.createClient();
    }
}
