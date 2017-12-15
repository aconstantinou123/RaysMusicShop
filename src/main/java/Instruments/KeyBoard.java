package Instruments;

import Shop.ISell;

public class KeyBoard extends Instrument implements ISell, IPlay{

    private int numberOfKeys;
    private double buyPrice;
    private double sellPrice;

    public KeyBoard(String name, String material, Colour colour, Type type, Make make, String model, int numberOfKeys, double buyPrice, double sellPrice) {
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
}
