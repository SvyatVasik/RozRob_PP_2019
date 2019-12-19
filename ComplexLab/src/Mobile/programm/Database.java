package Mobile.programm;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {
    private Scanner in = new Scanner(System.in);
    private ArrayList<Mobile.programm.Company> companies = new ArrayList<>();
    private ArrayList<Mobile.programm.Client> clients = new ArrayList<>();
    private ArrayList<Tariff> tariffs = new ArrayList<>();

    public void createTariffList() throws FileNotFoundException {

        AtomicInteger counter = new AtomicInteger(1);

        System.out.println("|----------------------|---------------------------------------------|");
        System.out.println("| '1' - створити тариф | '0' - переглянути тарифи створених компаній |");
        System.out.println("|----------------------|---------------------------------------------|");

        int user_choice = Integer.parseInt(in.nextLine());


        if (user_choice == 1) {
            downloadFromFileOrNotChoice();
            int user_choice_2 = Integer.parseInt(in.nextLine());

            if (user_choice_2 == 1) {
                System.out.print("--> Скільки бажаєте створити тарифів: ");
                int tariff_number = Integer.parseInt(in.nextLine());

                for (int i = 0; i < tariff_number; i++) {
                    System.out.print("--> Введіть назву тарифа: ");
                    String tariff_name = in.nextLine();
                    System.out.print("--> Введіть місячну абонплату тарифа: ");
                    int tariff_fee = Integer.parseInt(in.nextLine());
                    tariffs.add(i, new Tariff(tariff_name, tariff_fee));
                }
            } else if (user_choice_2 == 0) {
                FileReader fr = new FileReader("./src/Mobile/programm/data/tarrifs.txt");
                Scanner scan = new Scanner(fr);

                int i = 0;
                while (scan.hasNextLine()) {
                    String[] str = scan.nextLine().split("/");

                    String tarif_name = str[0].trim();
                    int tarif_fee = Integer.parseInt(str[1].trim());

                    tariffs.add(i, new Tariff(tarif_name, tarif_fee));
                    i++;
                }
                System.out.println("Тарифи були успішно завантаженні з файлу!");
            }
        } else if (user_choice == 0) {

            if (companies.size() == 0) {
                System.out.println("У вас поки що не має компаній!");
                return;
            }

            printCompanies();
            System.out.print("--> Виберіть компанію, шоб переглянути її тарифи: ");
            int company_index = Integer.parseInt(in.nextLine()) - 1;

            if (companies.get(company_index).getTariff().size() == 0) {
                System.out.println("У компанії поки що не має тарифів!");
                return;
            }

            for (int i = 0; i < companies.get(company_index).getTariff().size(); i++) {
                System.out.println(counter.getAndIncrement() + ". " + companies.get(company_index).getTariff().get(i).getName()
                        + " / " + companies.get(company_index).getTariff().get(i).getSubscriptionFee());
            }
        }
    }

    public void createCompany() throws IOException {

        AtomicInteger counter = new AtomicInteger(1);

        System.out.println("|-------------------------|-----------------------------------------------|");
        System.out.println("| '1' - створити компанію | '0' - переглянути клієнтів створених компаній |");
        System.out.println("|-------------------------|-----------------------------------------------|");

        int user_choice = Integer.parseInt(in.nextLine());

        if (user_choice == 1) {
            downloadFromFileOrNotChoice();
            int user_choice_2 = Integer.parseInt(in.nextLine());

            if (user_choice_2 == 1) {
                System.out.print("--> Скільки компаній бажаєте створити: ");
                int company_number = Integer.parseInt(in.nextLine());

                for (int i = 0; i < company_number; i++) {
                    System.out.print("--> Введіть назву компанії: ");
                    String company_name = in.nextLine();
                    companies.add(i, new Mobile.programm.Company(company_name));
                    System.out.println("Вітаю! Ви успішно створили компанію " + companies.get(i).getName());
                }
            } else if (user_choice_2 == 0) {
                FileReader fr = new FileReader("./src/Mobile/programm/data/companies.txt");
                Scanner scan = new Scanner(fr);

                int i = 0;
                while (scan.hasNextLine()) {
                    String comp_name = scan.nextLine();
                    companies.add(i, new Mobile.programm.Company(comp_name));
                    i++;
                }
                System.out.println("Компанії були успішно завантаженні з файлу!");
            }
        } else if (user_choice == 0) {

            if (companies.size() == 0) {
                System.out.println("У вас поки що не має компаній!");
                return;
            }
            if (clients.size() == 0) {
                System.out.println("У вас поки що не має клієнтів!");
                return;
            }

            printCompanies();
            System.out.print("--> Виберіть компанію, щоб переглянути її клієнтів: ");
            int company_index = Integer.parseInt(in.nextLine()) - 1;

            if (companies.get(company_index).getClients().size() == 0) {
                System.out.println("У компанії поки що не має клієнтів!");
                return;
            }

            for (int i = 0; i < companies.get(company_index).getClients().size(); i++) {
                System.out.println(counter.getAndIncrement() + ". " + companies.get(company_index).getClients().get(i).getName());
            }
        }
    }

    public void addClientToCompany() {

        if (companies.size() == 0) {
            System.out.println("У вас поки що не має компаній");
        }

        printCompanies();
        System.out.print("--> Виберіть до якої компанії додати клієнта: ");
        int company_index = Integer.parseInt(in.nextLine()) - 1;


        System.out.print("--> Скільки клієнтів бажаєте добавити до компанії " + companies.get(company_index).getName() + ": ");
        int client_number = Integer.parseInt(in.nextLine());

        printClients();
        for (int i = 0; i < client_number; i++) {
            System.out.print("--> Виберіть якого клієнта добавити до компанії " + companies.get(company_index).getName() + ": ");
            int client_index = Integer.parseInt(in.nextLine()) - 1;

            if (companies.get(company_index).getClients().contains(clients.get(client_index))) {
                System.out.println("Цей клієнт вже доданий до компанії!");
                return;
            }

            companies.get(company_index).getClients().add(i, clients.get(client_index));
            System.out.println("Вітаю! Ви успіщно додали клієнта " + clients.get(client_index).getName());
        }

    }

    public void totalCountOfClients() {

        if (companies.size() == 0) {
            System.out.println("У вас поки що не має компаній!");
            return;
        }

        printCompanies();
        System.out.print("--> Виберіть в якій компанії підрахувати клієнтів: ");
        int company_index = Integer.parseInt(in.nextLine()) - 1;

        System.out.println("В компанії " + companies.get(company_index).getName() + ", " + companies.get(company_index).getClients().size()
                + " клієнт(-ів)");
    }

    public void sortBySubscriptionFee() {

        if (companies.size() == 0) {
            System.out.println("У вас поки що не має компаній!");
            return;
        }

        printCompanies();
        System.out.print("--> Виберіть компанію в якій бажаєте відсортувати тарифи за абонплатою: ");
        int company_index = Integer.parseInt(in.nextLine()) - 1;
        companies.get(company_index).getTariff().sort(Comparator.comparing(Tariff::getSubscriptionFee));
        System.out.println("Всі тарифи в компанії " + companies.get(company_index).getName() + " відсортовані.");
    }

    public void FindTariffByQuality() {

        if (companies.size() == 0) {
            System.out.println("У вас поки що не має компаній!");
            return;
        }

        printCompanies();
        System.out.print("--> Введіть в якій компанії виконати пошук: ");
        int company_index = Integer.parseInt(in.nextLine()) - 1;

        if (companies.get(company_index).getTariff().size() == 0) {
            System.out.println("В цій компанії не має тарифів!");
            return;
        }

        System.out.print("--> Введіть діапазон абонплати від: ");
        int start_fee = Integer.parseInt(in.nextLine());
        System.out.print("--> Введіть діапазон абонплати до: ");
        int end_fee = Integer.parseInt(in.nextLine());

        companies.get(company_index).getTariff().forEach(x -> printTariffNameIfInDiapason(start_fee, end_fee, x));
    }

    private void printTariffNameIfInDiapason(int from, int to, Tariff tariff) {

        if (isTariffFeeDiapason(from, to, tariff.getSubscriptionFee())) {
            System.out.println("Тариф знайдено - " + tariff.getName() + " / " + tariff.getSubscriptionFee());
        } else
            System.out.println("На жаль, такого тарифу не має!");
    }

    private boolean isTariffFeeDiapason(int from, int to, int subscription_fee) {
        return from < subscription_fee && subscription_fee < to;
    }

    public void createClient() throws FileNotFoundException {

        System.out.println("|-----------------------------|---------------------------------------|");
        System.out.println("| '1' - створити клієнта(-ів) | '0' - переглянути створениих клієнтів |");
        System.out.println("|-----------------------------|---------------------------------------|");

        int user_choice = Integer.parseInt(in.nextLine());

        if (user_choice == 1) {
            downloadFromFileOrNotChoice();
            int user_choice_2 = Integer.parseInt(in.nextLine());

            if (user_choice_2 == 1) {
                System.out.print("--> Скільки клієнтів бажаєте створити: ");
                int client_number = Integer.parseInt(in.nextLine());

                for (int i = 0; i < client_number; i++) {
                    System.out.print("--> Яке ім'я у клієнта: ");
                    String client_name = in.nextLine();
                    clients.add(i, new Mobile.programm.Client(client_name));
                    System.out.println("Вітаю! Ви успішно створили клієнта " + clients.get(i).getName());
                }
            } else if (user_choice_2 == 0) {
                FileReader fr = new FileReader("./src/Mobile/programm/data/clients.txt");
                Scanner scan = new Scanner(fr);

                int i = 0;
                while (scan.hasNextLine()) {
                    String client_name = scan.nextLine();
                    clients.add(i, new Mobile.programm.Client(client_name));
                    i++;
                }
                System.out.println("Клієнти були успішно завантаженні з файлу!");
            }
        }

        if (user_choice == 0) {

            if (clients.size() == 0) {
                System.out.println("У вас поки що не має клієнтів!");
                return;
            }
            printClients();
        }
    }

    public void printMenu() {
        System.out.print("\n------------------ Меню ------------------\n" +
                "| 1. Створити компанію\n" +
                "| 2. Створити клієнта\n" +
                "| 3. Створити список тарифів компанії\n" +
                "| 4. Додати клієнта до компанії\n" +
                "| 5. Підрахувати загальну к-сть клієнтів у компанії\n" +
                "| 6. Сортувати тарифи за абонплатою\n" +
                "| 7. Знайти тариф у компанії\n" +
                "| 8. Додати тариф до компанії\n" +
                "| 9. Вихід\n" +
                "|-----------------------------------------|\n" +
                "Виберіть пункт меню -> ");
    }

    void printClients() {
        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("Список всіх створених клієнтів: ");

        for (Mobile.programm.Client client : clients)
            System.out.println(counter.getAndIncrement() + ". " + client.getName());
    }

    void printCompanies() {
        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("Список всіх створених компаній: ");

        for (Mobile.programm.Company company : companies) {
            System.out.println(counter.getAndIncrement() + ". " + company.getName());
        }
    }

    void printTariffs() {
        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("Список всіх створених тарифів: ");

        for (Tariff tariff : tariffs) {
            System.out.println(counter.getAndIncrement() + ". " + tariff.getName() + " / " + tariff.getSubscriptionFee());
        }
    }

    public void addTariffToCompany() {

        if (tariffs.size() == 0) {
            System.out.println("У вас поки що не має тарифів");
            return;
        }

        System.out.println("|--------------------------------|-----------------------------------|");
        System.out.println("| '1' - додати тариф до компанії | '0' - переглянути всі тарифи      |");
        System.out.println("|--------------------------------|-----------------------------------|");

        int user_choice = Integer.parseInt(in.nextLine());

        if (user_choice == 1) {
            printCompanies();

            if (companies.size() == 0) {
                System.out.println("У вас поки що не має компаній!");
                return;
            }

            System.out.print("--> Виберіть до якої компанії додати тариф: ");
            int company_index = Integer.parseInt(in.nextLine()) - 1;


            System.out.print("--> Скільки тарифів бажаєте добавити до компанії " + companies.get(company_index).getName() + ": ");
            int tariff_number = Integer.parseInt(in.nextLine());

            printTariffs();

            for (int i = 0; i < tariff_number; i++) {
                System.out.print("--> Виберіть який тариф добавити до компанії " + companies.get(company_index).getName() + ": ");
                int tariff_index = Integer.parseInt(in.nextLine()) - 1;

                if (companies.get(company_index).getTariff().contains(tariffs.get(tariff_index))) {
                    System.out.println("Цей тариф вже додано до компанії!");
                    return;
                }
                companies.get(company_index).getTariff().add(i, tariffs.get(tariff_index));
                System.out.println("Вітаємо! Ви успішно додали тариф " + tariffs.get(tariff_index).getName() + " / "
                        + tariffs.get(tariff_index).getSubscriptionFee());
            }
        } else if (user_choice == 0) {
            printTariffs();
        }

    }

    void downloadFromFileOrNotChoice() {
        System.out.println("|--------------------------|---------------------------|");
        System.out.println("| '1' - створити власноруч | '0' - завантажити з файлу |");
        System.out.println("|--------------------------|---------------------------|");
    }
}
