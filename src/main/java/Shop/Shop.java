package Shop;

import Drums.IDrum;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Collections;

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
            allInstruments.add(String.format("%s   Buy: £%s   Sell: £%s   Markup £%s", item.prettyName(), item.getBuyPrice(),
            item.getSellPrice(), item.calculateMarkup()));
            Collections.sort(allInstruments);
        }

        String result = String.join("\n", allInstruments);
        return result;
    }

    public String listAllIDrum(){
        ArrayList<String> iDrumInstruments = new ArrayList<>();
        for (ISell item : stock){
                if(item instanceof IDrum)
            iDrumInstruments.add(item.prettyName());
            Collections.sort(iDrumInstruments);
        }

        String result = String.join("\n", iDrumInstruments);
        return result;
    }

    public String searchByProductName(String itemName){
        ArrayList<ISell> foundInstrument = new ArrayList<>();
        for (ISell item : stock){
            if (itemName.contains(item.getName())){
                foundInstrument.add(item);
            }
        }
        if (!foundInstrument.isEmpty()) {
            String result = String.format("%s: %s", itemName, foundInstrument.size());
            return result;
        }
        else {
            return "Nothing found";
        }
    }

    public String searchByProductNamePrettyList(String itemName){
        ArrayList<String> foundInstrument = new ArrayList<>();
        for (ISell item : stock){
            if (itemName.contains(item.getName())){
                foundInstrument.add(String.format("%s   Buy: £%s   Sell: £%s   Markup £%s", item.prettyName(), item.getBuyPrice(),
                        item.getSellPrice(), item.calculateMarkup()));
            }
        }
            String result = String.join("\n", foundInstrument);
            return result;
    }

    public String displayStock(){
        ArrayList<String> allStock = new ArrayList<>();
        ArrayList<String> allStockUnique = new ArrayList<>();
        for (ISell item : stock) {
                allStock.add(searchByProductName(item.getName()));
                for (String displayStock : allStock){
                    if(!allStockUnique.contains(displayStock)){
                        allStockUnique.add(displayStock);
                    }
                }
        }
        String result = String.join("\n", allStockUnique);
        return result;
    }

    public void applySalePrices(double percent){
        for (ISell items : stock){
            items.adjustSellPrice(percent);
        }
    }

    public IDrum selectIDrum(String nameOfDrum){
        IDrum drum = null;
        for (ISell item : stock){
            if(item instanceof  IDrum && item.prettyName().equals(nameOfDrum)){
                drum = ((IDrum) item);
            }
        }
        return drum;
    }

    public String removeByPrettyName(String prettyName){
        for (ISell item : stock){
            if (prettyName.equals(item.prettyName())){
                removeStock(item);
                return item.prettyName() + " removed";
            }
        }
        return "item not found";
    }


}
