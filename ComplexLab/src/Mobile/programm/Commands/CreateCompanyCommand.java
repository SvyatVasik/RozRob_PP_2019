package Mobile.programm.Commands;

import Mobile.programm.Database;

import java.io.IOException;

public class CreateCompanyCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public CreateCompanyCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() throws IOException {
        database.createCompany();
    }
}
