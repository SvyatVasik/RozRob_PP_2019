package Mobile.programm;


import Mobile.programm.Commands.*;
import Mobile.programm.Commands.*;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Mobile.programm.Database database = new Mobile.programm.Database();
        Scanner in = new Scanner(System.in);

        do {
            new PrintCommand(database).execute();
        } while(consoleMenu(Integer.parseInt(in.nextLine()), database));
    }

    private static boolean consoleMenu(int userChoice, Mobile.programm.Database database) throws IOException {
        switch (userChoice) {
            case 1:
                new CreateCompanyCommand(database).execute();
                break;
            case 2:
                new CreateClientCommand(database).execute();
                break;
            case 3:
                new CreateTariffListCommand(database).execute();
                break;
            case 4:
                new AddClientToCompanyCommand(database).execute();
                break;
            case 5:
                new TotalCountCommand(database).execute();
                break;
            case 6:
                new SortCommand(database).execute();
                break;
            case 7:
                new FindCommand(database).execute();
                break;
            case 8:
                new AddTariffToCompanyCommand(database).execute();
                break;
            case 9:
                return false;
        }
        return true;
    }
}
