import Drums.BassDrum;
import Drums.Cymbal;
import Drums.Snare;
import Drums.TomTomDrum;
import Instruments.*;
import MiscItems.DrumStick;
import MiscItems.GuitarString;
import MiscItems.SheetMusic;
import Shop.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    Guitar guitar;
    GuitarString guitarString;

    BassDrum bassDrum;
    BassDrum bassDrum2;
    Cymbal cymbal;
    Cymbal cymbal2;
    Snare snare;
    Snare snare2;
    TomTomDrum tomTomDrum;
    TomTomDrum tomTomDrum2;
    DrumStick drumStick;
    DrumKit drumKit;
    SheetMusic sheetMusic;

    KeyBoard keyBoard;

    Shop shop;


    @Before
    public void before() {
        guitarString = new GuitarString("Guitar String", 5, 10);
        guitar = new Guitar("Guitar", "mahogany", Colour.BLACK, Type.STRING,
                Make.BCRICH, "G756", 6, true, 200, 300, guitarString);

        bassDrum = new BassDrum("Bass Drum", 150, 275);
        bassDrum2 = new BassDrum("Bass Drum", 150, 275);
        cymbal = new Cymbal("Cymbal", 50, 75);
        cymbal2 = new Cymbal("Cymbal", 50, 75);
        snare = new Snare("Snare", 70, 100);
        snare2 = new Snare("Snare", 70, 100);
        tomTomDrum = new TomTomDrum("Tom Tom Drum", 70, 150);
        tomTomDrum2 = new TomTomDrum("Tom Tom Drum", 70, 150);
        drumStick = new DrumStick("Drum Stick", 10, 20);
        drumKit = new DrumKit("Drum Kit", "Oak", Colour.BLUE, Type.PERCUSSION, Make.TAMA, "Tiger Mark 7", drumStick);

        keyBoard = new KeyBoard("Keyboard", "plastic", Colour.RED, Type.KEYBOARD, Make.ROLAND, "ty6788", 91,
                200, 300);

        sheetMusic = new SheetMusic("Sheet Music", 2, 6);

        shop = new Shop("Rays Music Store");

        drumKit.addDrum(bassDrum);
        drumKit.addDrum(tomTomDrum);
        drumKit.addDrum(cymbal);
        drumKit.addDrum(snare);

    }

    @Test
    public void canCalculateMarkup(){
        assertEquals(125, bassDrum.calculateMarkup(), 0.1);
    }

    @Test
    public void canCalculateMarkup_Drums(){
        assertEquals(270, drumKit.calculateMarkup(), 0.1);
    }

    @Test
    public void canCalculateMarkup_Guitar(){
        assertEquals(105, guitar.calculateMarkup(), 0.1);
    }

    @Test
    public void canGetStockSize(){
        assertEquals(0, shop.numberOfItemsInStock());
    }

    @Test
    public void canAddItemstoStock(){
        shop.addStock(guitar);
        assertEquals(1, shop.numberOfItemsInStock());
    }

    @Test
    public void canRemoveItemsFromStock(){
        shop.addStock(guitar);
        assertEquals(1, shop.numberOfItemsInStock());
        shop.removeStock(guitar);
        assertEquals(0, shop.numberOfItemsInStock());
    }

    @Test
    public void canCalculateTotalProfit(){
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals(8, shop.numberOfItemsInStock());
        assertEquals(739, shop.calculateTotalPotentialProfit(), 0.1);
    }

    @Test
    public void canCalculateTotalBuyPrice() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals(8, shop.numberOfItemsInStock());
        assertEquals(1097, shop.calculateTotalBuyPrice(), 0.1);

    }

    @Test
    public void canCalculateTotalSellPrice() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals(8, shop.numberOfItemsInStock());
        assertEquals(1836, shop.calculateTotalSellPrice(), 0.1);

    }
}
