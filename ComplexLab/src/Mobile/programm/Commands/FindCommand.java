package Mobile.programm.Commands;

import Mobile.programm.Database;

public class FindCommand implements Mobile.programm.Commands.Command {
    private Database database;

    public FindCommand(Database newDatabase) {
        database = newDatabase;
    }

    @Override
    public void execute() {
        database.FindTariffByQuality();
    }
}
