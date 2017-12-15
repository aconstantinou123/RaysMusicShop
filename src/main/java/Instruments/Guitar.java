package Instruments;

public class Guitar extends Instrument {


    private int numberOfStrings;
    private boolean isElectric;
    private double buyPrice;
    private double sellPrice;

    public Guitar(String material, Colour colour, Type type, Make make, String model, int numberOfStrings, boolean isElectric, double buyPrice, double sellPrice) {
        super(material, colour, type, make, model);

        this.numberOfStrings = numberOfStrings;
        this.isElectric = isElectric;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public int getNumberOfStrings() {
        return numberOfStrings;
    }

    public void setNumberOfStrings(int numberOfStrings) {
        this.numberOfStrings = numberOfStrings;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
}
