package Mobile.programm.Commands;

import Mobile.programm.Database;

public class SortCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public SortCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.sortBySubscriptionFee();
    }
}
