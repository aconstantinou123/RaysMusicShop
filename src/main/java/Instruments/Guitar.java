package Instruments;

import MiscItems.GuitarString;

public class Guitar extends Instrument {


    private int numberOfStrings;
    private boolean isElectric;
    private double buyPrice;
    private double sellPrice;
    private GuitarString guitarString;

    public Guitar(String material, Colour colour, Type type, Make make, String model,
                  int numberOfStrings, boolean isElectric, double buyPrice, double sellPrice, GuitarString guitarString) {
        super(material, colour, type, make, model);

        this.numberOfStrings = numberOfStrings;
        this.isElectric = isElectric;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.guitarString = guitarString;
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


    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }


    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public GuitarString getGuitarString() {
        return guitarString;
    }

    public void setGuitarString(GuitarString guitarString) {
        this.guitarString = guitarString;
    }

    public double getBuyPrice(){
        return buyPrice += guitarString.getBuyPrice();
    }

    public double getSellPrice(){
        return sellPrice += guitarString.getSellPrice();
    }
}
