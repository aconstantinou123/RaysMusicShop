package MiscItems;

import Shop.ISell;

public class GuitarString implements ISell{

    private String name;
    private double buyPrice;
    private double sellPrice;

    public GuitarString(String name, double buyPrice, double sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
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

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void adjustSellPrice(double percent) {
        this.sellPrice = this.sellPrice * (percent / 100);
    }

    public void resetPrice(double percent) {
        this.sellPrice = Math.round(this.sellPrice / (percent / 100));
    }
}
