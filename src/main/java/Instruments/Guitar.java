package Instruments;

import MiscItems.GuitarString;
import Shop.ISell;

public class Guitar extends Instrument implements ISell, IPlay {


    private int numberOfStrings;
    private boolean isElectric;
    private double buyPrice;
    private double sellPrice;
    private GuitarString guitarString;

    public Guitar(String name, String material, Colour colour, Type type, Make make, String model,
                  int numberOfStrings, boolean isElectric, double buyPrice, double sellPrice, GuitarString guitarString) {
        super(name, material, colour, type, make, model);

        this.numberOfStrings = numberOfStrings;
        this.isElectric = isElectric;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.guitarString = guitarString;
    }

    public double calculateMarkup() {
        return getSellPrice() - getBuyPrice();
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

    public String play() {
        return "wowowowowowowowowoweeeeeeeee" ;
    }

    public String prettyName() {
        return getColour() + " " + getMake() + " " + getModel() + " " + getName();
    }
}
