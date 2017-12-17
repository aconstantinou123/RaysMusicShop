package Instruments;

import Shop.ISell;

public class KeyBoard extends Instrument implements ISell, IPlay{

    private int numberOfKeys;
    private double buyPrice;
    private double sellPrice;

    public KeyBoard(String name, String material, String colour, Type type, String make, String model, int numberOfKeys, double buyPrice, double sellPrice) {
        super(name, material, colour, type, make, model);
        this.numberOfKeys = numberOfKeys;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public double calculateMarkup() {
        return sellPrice - buyPrice;
    }

    public int getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(int numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
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

    public String play() {
        return "plink plank plonk";
    }

    public String prettyName() {
        return getColour() + " " + getMake() + " " + getModel() + " " + getName();
    }

    public void adjustSellPrice(double percent) {
        this.sellPrice = this.sellPrice * (percent / 100);
    }

    public void resetPrice(double percent) {
        this.sellPrice = Math.round(this.sellPrice / (percent / 100));
    }

}
