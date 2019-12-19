package Mobile.programm.Commands;

import Mobile.programm.Database;

import java.io.FileNotFoundException;

public class CreateTariffListCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public CreateTariffListCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() throws FileNotFoundException {
        database.createTariffList();
    }

}
