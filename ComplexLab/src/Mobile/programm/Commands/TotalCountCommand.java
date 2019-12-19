package Mobile.programm.Commands;

import Mobile.programm.Database;

public class TotalCountCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public TotalCountCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.totalCountOfClients();
    }
}
