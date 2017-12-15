package Shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Shop {

    private String name;
    private ArrayList<ISell> stock;

    public Shop(String name) {
        this.name = name;
        this.stock = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ISell> getStock() {
        return stock;
    }

    public void addStock(ISell item) {
        stock.add(item);
    }

    public void removeStock(ISell item) {
        stock.remove(item);
    }

    public int numberOfItemsInStock() {
        return stock.size();
    }

    public double calculateTotalPotentialProfit(){
        double profit = 0;
        for (ISell item : stock) {
            profit += item.calculateMarkup();
        }
        return profit;
    }

    public double calculateTotalBuyPrice(){
        double buyPrice = 0;
        for (ISell item : stock) {
            buyPrice += item.getBuyPrice();
        }
        return buyPrice;
    }

    public double calculateTotalSellPrice(){
        double sellPrice = 0;
        for (ISell item : stock) {
            sellPrice += item.getSellPrice();
        }
        return sellPrice;
    }

    public String listItemsByClass(Class searchItem){
        ArrayList<String> foundInstruments = new ArrayList<>();
        for (ISell item : stock){
            if (searchItem == item.getClass()){
                foundInstruments.add(item.prettyName());
            }
        }
        String result = String.join("\n", foundInstruments);
        return result;
    }

    public String listAllStock(){
        ArrayList<String> allInstruments = new ArrayList<>();
        for (ISell item : stock){
            allInstruments.add(item.prettyName());
            Collections.sort(allInstruments);
        }

        String result = String.join("\n", allInstruments);
        return result;
    }

}
