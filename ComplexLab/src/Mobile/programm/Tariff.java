package Mobile.programm;

public class Tariff {
    private String name;
    private int subscriptionFee;

    public Tariff(String name, int subscriptionFee) {
        this.name = name;
        this.subscriptionFee = subscriptionFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(int subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }
}
