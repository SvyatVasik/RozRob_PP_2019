package Mobile.programm.Commands;

import Mobile.programm.Database;

public class AddTariffToCompanyCommand implements Command {

    private Database database;

    public AddTariffToCompanyCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.addTariffToCompany();
    }

}
