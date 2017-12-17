import Drums.BassDrum;
import Drums.Cymbal;
import Drums.Snare;
import Drums.TomTomDrum;
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

        BassDrum bassDrum = new BassDrum("Bass Drum", 150, 275);
        BassDrum bassDrum2 = new BassDrum("Bass Drum", 150, 275);
        Cymbal cymbal = new Cymbal("Cymbal", 50, 75);
        Cymbal cymbal2 = new Cymbal("Cymbal", 50, 75);
        Snare snare = new Snare("Snare", 70, 100);
        Snare snare2 = new Snare("Snare", 70, 100);
        TomTomDrum tomTomDrum = new TomTomDrum("Tom Tom Drum", 70, 150);
        TomTomDrum tomTomDrum2 = new TomTomDrum("Tom Tom Drum", 70, 150);
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
                            "5. Add stock\n");
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
                        System.out.println("Choose and instrument to add or press q to go back\n");
                        System.out.println("1. Guitar");
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
                                    System.out.println(newGuitar.prettyName() + " added to stock");

                                    break;
                            }

                    }while (!choice2.equals("q"));
                    break;
            }



        } while (!choice.equals("q"));

    }
}
