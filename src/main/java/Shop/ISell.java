package Shop;

public interface ISell {

    public double calculateMarkup();

    public double getBuyPrice();

    public double getSellPrice();

    public void adjustSellPrice(double percent);

    public String prettyName();

    public String getName();
}
