package Mobile.programm.Commands;

import Mobile.programm.Database;

public class AddClientToCompanyCommand implements Command {
    private Database database;

    public AddClientToCompanyCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.addClientToCompany();
    }
}
