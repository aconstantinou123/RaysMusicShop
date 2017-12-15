package Drums;

import Shop.ISell;

public class TomTomDrum implements IDrum, ISell{

    private String name;
    private double buyPrice;
    private double sellPrice;

    public TomTomDrum(String name, double buyPrice, double sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public double calculateMarkup() {
        return sellPrice - buyPrice;
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

    public String prettyName() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setName(String name) {
        this.name = name;
    }
}
