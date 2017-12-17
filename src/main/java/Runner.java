import Drums.*;
import Instruments.*;
import MiscItems.DrumStick;
import MiscItems.GuitarString;
import MiscItems.SheetMusic;
import Shop .*;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Runner {

    private Shop shop;

    public Runner(Shop shop) {
        this.shop = shop;

    }

    public static void main(String[] args) {

        GuitarString guitarString = new GuitarString("Guitar String", 5, 10);
        Guitar guitar = new Guitar("Guitar", "mahogany", "Black", Type.STRING,
                "BC Rich", "G756", 6, true, 200, 300, guitarString);

        BassDrum bassDrum = new BassDrum("Bass Drum", "Tama Bass Drum Nexus", 150, 275);
        BassDrum bassDrum1 = new BassDrum("Bass Drum", "Super Bass Drum", 150, 275);
        BassDrum bassDrum2 = new BassDrum("Bass Drum", "Extreme Bass", 150, 275);
        Cymbal cymbal = new Cymbal("Cymbal", "Zildjain Smash",50, 75);
        Cymbal cymbal2 = new Cymbal("Cymbal", "Tama Crash", 50, 75);
        Snare snare = new Snare("Snare", "Snake Charmer", 70, 100);
        Snare snare2 = new Snare("Snare", "Hash Crash Snare", 70, 100);
        TomTomDrum tomTomDrum = new TomTomDrum("Tom Tom Drum", "Tom Tom Forever",70, 150);
        TomTomDrum tomTomDrum2 = new TomTomDrum("Tom Tom Drum", "Tama Xtreme", 70, 150);
        DrumStick drumStick = new DrumStick("Drum Stick", 10, 20);
        DrumKit drumKit = new DrumKit("Drum Kit", "Oak", "Blue", Type.PERCUSSION, "Tama", "Tiger Mark 7", drumStick);

        KeyBoard keyBoard = new KeyBoard("Keyboard", "plastic", "Red", Type.KEYBOARD, "Roland", "ty6788", 91,
                200, 300);

        KeyBoard keyBoard2 = new KeyBoard("Keyboard", "plastic", "Black", Type.KEYBOARD, "Steinway", "XS6788", 65,
                200, 300);

        SheetMusic sheetMusic = new SheetMusic("Sheet Music", 2, 6);

        Shop shop = new Shop("Rays Music Store");

        drumKit.addDrum(bassDrum);
        drumKit.addDrum(tomTomDrum);
        drumKit.addDrum(cymbal);
        drumKit.addDrum(snare);

        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(keyBoard2);
        shop.addStock(bassDrum2);
        shop.addStock(bassDrum1);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);

        Runner runner = new Runner(shop);
        runner.run();

    }

    private void run(){

        String choice;
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        do {
            System.out.println("Ray Music Shop Admin \nPlease select and option or press q to exit");
            System.out.println("1. List all stock\n" +
                            "2. List by type\n" +
                            "3. Search for products\n" +
                            "4. Financial Totals\n" +
                            "5. Apply Sale Prices\n" +
                            "6. Reset Prices\n" +
                            "7. Remove stock\n" +
                            "8. Add stock\n");
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    String choice2;
                    do {
                        System.out.println(shop.listAllStock());
                        System.out.println("\nPress q to return to the main menu");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case "2":
                    do {
                        System.out.println(shop.displayStock());
                        System.out.println("\nPress q to return to the main menu");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case "3":
                    do {
                        System.out.println("Please enter the type of product you are looking for");
                        String search = scanner.nextLine();
                        System.out.println(shop.searchByProductName(search));
                        System.out.println(shop.searchByProductNamePrettyList(search));
                        System.out.println("Press q to return to the main menu or any other key to search again");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case "4":
                    do {
                        System.out.println("Buy price of all stock: £" + shop.calculateTotalBuyPrice());
                        System.out.println("Sell price of all stock: £" + shop.calculateTotalSellPrice());
                        System.out.println("Potential profit of all stock: £" + shop.calculateTotalPotentialProfit());
                        System.out.println("\nPress q to return to the main menu");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case "5":
                    do {
                        System.out.println("Type the percent you wish to reduce prices to: ");
                        Double percent = Double.parseDouble(scanner.nextLine());
                        shop.applySalePrices(percent);
                        System.out.println("Prices adjusted to " + percent + "%");
                        System.out.println(shop.listAllStock() + "\n");
                        System.out.println("press q to quit back to the main menu");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case "6":
                    do {
                        System.out.println("Type in current sale % and the computer will calculate the original prices");
                        Double percent = Double.parseDouble(scanner.nextLine());
                        shop.resetAllPrices(percent);
                        System.out.println("Prices reset");
                        System.out.println(shop.listAllStock() + "\n");
                        System.out.println("press q to quit back to the main menu");
                        choice2 = scanner.nextLine();
                    }while (!choice2.equals("q"));
                    break;

                case"7":
                    System.out.println(shop.listAllStock() + "\n");
                    System.out.println("Type the name of the items you wish to remove");
                    String itemToRemove = scanner.nextLine();
                    shop.removeByPrettyName(itemToRemove);
                    System.out.println(itemToRemove + " removed from stock");
                    break;

                case "8":
                    do {
                        System.out.println("Choose and instrument to add or press q to go back\n");
                        System.out.println("1. Guitar\n" +
                                            "2. Keyboard\n" +
                                            "3. Individual Drums\n" +
                                            "4. Drum Kit\n");
                        choice2 = scanner.nextLine();
                            switch (choice2){
                                case "1":
                                    System.out.println("What is the make of guitar?");
                                    String make = scanner.nextLine();
                                    System.out.println("What is the model?");
                                    String model = scanner.nextLine();
                                    System.out.println("What is the guitar made of?");
                                    String material = scanner.nextLine();
                                    System.out.println("What colour is the guitar?");
                                    String colour = scanner.nextLine();
                                    System.out.println("How many strings does it have?");
                                    Integer strings = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Is the guitar electric of acoustic?");
                                    String electric = scanner.nextLine();
                                    boolean isElectric = true;
                                        if (electric.equals("electric")){
                                            isElectric = true;
                                        }
                                        else if (electric.equals("acoustic")){
                                            isElectric = false;
                                        }
                                        else {
                                            System.out.println("Unrecognised answer");
                                        }
                                    System.out.println("Buy price?");
                                    Integer buyPrice = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Sell price?");
                                    Integer sellPrice = Integer.parseInt(scanner.nextLine());
                                    GuitarString newStrings = new GuitarString("GuitarString", 5, 10);
                                    Guitar newGuitar = new Guitar("Guitar", material, colour, Type.STRING, make, model, strings, isElectric, buyPrice, sellPrice, newStrings);
                                    shop.addStock(newGuitar);
                                    System.out.println(newGuitar.prettyName() + " added to stock\n");
                                    break;

                                case "2":
                                    System.out.println("What is the make of keyboard?");
                                    String makeK = scanner.nextLine();
                                    System.out.println("What is the model?");
                                    String modelK = scanner.nextLine();
                                    System.out.println("What is the keyboard made of?");
                                    String materialK = scanner.nextLine();
                                    System.out.println("What colour is the keyboard?");
                                    String colourK = scanner.nextLine();
                                    System.out.println("How many keys does it have?");
                                    Integer keysK = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Buy price?");
                                    Integer buyPriceK = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Sell price?");
                                    Integer sellPriceK = Integer.parseInt(scanner.nextLine());
                                    KeyBoard newKeyboard = new KeyBoard("Keyboard", materialK, colourK, Type.KEYBOARD, makeK, modelK, keysK, buyPriceK, sellPriceK);
                                    shop.addStock(newKeyboard);
                                    System.out.println(newKeyboard.prettyName() + " added to stock\n");
                                    break;

                                case "3":
                                    String choice3;
                                    System.out.println("Select the type of drum/cymbal\n");
                                    System.out.println("1. Bass Drum\n" +
                                        "2. Snare\n" +
                                        "3. Tom Tom Drum\n" +
                                        "4. Cymbal\n");
                                    choice3 = scanner.nextLine();
                                    switch (choice3){
                                        case "1":
                                            System.out.println("What is the make and model?");
                                            String modelBass = scanner.nextLine();
                                            System.out.println("Buy price?");
                                            Integer buyPriceBass = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Sell price?");
                                            Integer sellPriceBass = Integer.parseInt(scanner.nextLine());
                                            BassDrum newBassDrum = new BassDrum("Bass Drum", modelBass, buyPriceBass, sellPriceBass);
                                            shop.addStock(newBassDrum);
                                            System.out.println(newBassDrum.prettyName() + " added to stock\n");
                                            break;

                                        case "2":
                                            System.out.println("What is the make and model?");
                                            String modelSnare = scanner.nextLine();
                                            System.out.println("Buy price?");
                                            Integer buyPriceSnare = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Sell price?");
                                            Integer sellPriceSnare = Integer.parseInt(scanner.nextLine());
                                            Snare newSnareDrum = new Snare("Snare", modelSnare, buyPriceSnare, sellPriceSnare);
                                            shop.addStock(newSnareDrum);
                                            System.out.println(newSnareDrum.prettyName() + " added to stock\n");
                                            break;

                                        case "3":
                                            System.out.println("What is the make and model?");
                                            String modelTom = scanner.nextLine();
                                            System.out.println("Buy price?");
                                            Integer buyPriceTom = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Sell price?");
                                            Integer sellPriceTom = Integer.parseInt(scanner.nextLine());
                                            TomTomDrum newTomTomDrum = new TomTomDrum("Tom Tom Drum", modelTom, buyPriceTom, sellPriceTom);
                                            shop.addStock(newTomTomDrum);
                                            System.out.println(newTomTomDrum.prettyName() + " added to stock\n");
                                            break;

                                        case "4":
                                            System.out.println("What is the make and model?");
                                            String modelCym = scanner.nextLine();
                                            System.out.println("Buy price?");
                                            Integer buyPriceCym = Integer.parseInt(scanner.nextLine());
                                            System.out.println("Sell price?");
                                            Integer sellPriceCym = Integer.parseInt(scanner.nextLine());
                                            Cymbal newCymbal = new Cymbal("Cymbal", modelCym, buyPriceCym, sellPriceCym);
                                            shop.addStock(newCymbal);
                                            System.out.println(newCymbal.prettyName() + " added to stock\n");
                                            break;
                                    }
                                    break;

                                case "4":
                                    System.out.println("What is the make of drum kit?");
                                    String makeD = scanner.nextLine();
                                    System.out.println("What is the model?");
                                    String modelD = scanner.nextLine();
                                    System.out.println("What is the drum kit made of?");
                                    String materialD = scanner.nextLine();
                                    System.out.println("What colour is the drum kit");
                                    String colourD = scanner.nextLine();
                                    DrumStick newDrumStick = new DrumStick("Drumstick",10, 20);
                                    DrumKit newDrumKit = new DrumKit("Drum Kit", materialD, colourD, Type.PERCUSSION, makeD, modelD, newDrumStick);
                                    System.out.println("Number of drums to add to drum kit: ");
                                    Integer numberOfDrums = Integer.parseInt(scanner.nextLine());
                                      for (int i = 1; i <= numberOfDrums; i++){
                                          System.out.println(shop.listAllIDrum() + "\n");
                                          System.out.println("Select drum number " + i + " by typing the name");
                                          String selectedDrum = scanner.nextLine();
                                          newDrumKit.addDrum(shop.selectIDrum(selectedDrum));
                                          shop.removeStock(((ISell) shop.selectIDrum(selectedDrum)));
                                      }
                                      shop.addStock(newDrumKit);
                                    System.out.println(newDrumKit.prettyName() + " added to stock\n");
                                    break;

                            }


                    }while (!choice2.equals("q"));
                    break;
            }



        } while (!choice.equals("q"));

    }
}
