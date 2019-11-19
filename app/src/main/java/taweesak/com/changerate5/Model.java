package taweesak.com.changerate5;

public class Model {
    private int choice;
    private double rates;

    private String rateText;

    public Model(int choice, double rates) {
        this.choice = choice;
        //this.rates = rates;
        setRates(rates);
        setRateText(choice);
    }

    public String getRateText() {
        return rateText;
    }

    public void setRateText(int choice) {
        switch (choice) {
            case 0:
                this.rateText = "USD/THB";
                break;
            case 1:
                this.rateText = "JPY/THB";
                break;
            case 2:
                this.rateText = "EUR/THB";
                break;
        }
    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public double getRates() {
        return rates;
    }

    public void setRates(double rates) {
        switch (choice) {
            case 0:
                this.rates = rates * 30.0262;
                break;
            case 1:
                this.rates = rates * 27.3978;
                break;
            case 2:
                this.rates = rates * 33.2422;
                break;
        }
    }
}
