package Drums;

import Shop.ISell;

public class Cymbal extends Drum implements IDrum, ISell{

    public Cymbal(String name, String displayName, double buyPrice, double sellPrice) {
        super(name, displayName, buyPrice, sellPrice);
    }

    public double calculateMarkup() {
        return getSellPrice() - getBuyPrice();
    }

    public void adjustSellPrice(double percent) {
        this.setSellPrice(this.getSellPrice() * (percent / 100));
    }

    public void resetPrice(double percent) {
        this.setSellPrice(Math.round(this.getSellPrice() * (percent / 100)));
    }

    public String prettyName() {
        return getDisplayName();
    }
}
