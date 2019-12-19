package Mobile.programm;

import java.util.ArrayList;

public class Company {
    private String name;
    private ArrayList<Mobile.programm.Client> clients = new ArrayList<>();
    private ArrayList<Tariff> tariff = new ArrayList<Tariff>();

    public ArrayList<Tariff> getTariff() {
        return tariff;
    }

    public void setTariff(ArrayList<Tariff> tariff) {
        this.tariff = tariff;
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Mobile.programm.Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Mobile.programm.Client> clients) {
        this.clients = clients;
    }
}
