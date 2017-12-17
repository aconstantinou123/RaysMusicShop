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
    KeyBoard keyBoard2;

    Shop shop;


    @Before
    public void before() {
        guitarString = new GuitarString("Guitar String", 5, 10);
        guitar = new Guitar("Guitar", "mahogany", "Black", Type.STRING,
                "BC Rich", "G756", 6, true, 200, 300, guitarString);

        bassDrum = new BassDrum("Bass Drum", 150, 275);
        bassDrum2 = new BassDrum("Bass Drum", 150, 275);
        cymbal = new Cymbal("Cymbal", 50, 75);
        cymbal2 = new Cymbal("Cymbal", 50, 75);
        snare = new Snare("Snare", 70, 100);
        snare2 = new Snare("Snare", 70, 100);
        tomTomDrum = new TomTomDrum("Tom Tom Drum", 70, 150);
        tomTomDrum2 = new TomTomDrum("Tom Tom Drum", 70, 150);
        drumStick = new DrumStick("Drum Stick", 10, 20);
        drumKit = new DrumKit("Drum Kit", "Oak", "Blue", Type.PERCUSSION, "Tama", "Tiger Mark 7", drumStick);

        keyBoard = new KeyBoard("Keyboard", "plastic", "Red", Type.KEYBOARD, "Roland", "ty6788", 91,
                200, 300);

        keyBoard2 = new KeyBoard("Keyboard", "plastic", "Black", Type.KEYBOARD, "Steinway", "X$6788", 65,
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
    public void canAdjustSellPrice(){
        bassDrum.adjustSellPrice(10);
        assertEquals(27.5,bassDrum.getSellPrice(), 0.1);
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
    public void canAdjustAllPrices() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.applySalePrices(50);
        assertEquals(155, guitar.getSellPrice(), 0.1);
        assertEquals(310, drumKit.getSellPrice(), 0.1);
        assertEquals(150, keyBoard.getSellPrice(), 0.1);
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

    @Test
    public void canListAllItems() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals("Bass Drum\n" +
                "Black BC Rich G756 Guitar\n" +
                "Blue Tama Tiger Mark 7 Drum Kit\n" +
                "Cymbal\n" +
                "Red Roland ty6788 Keyboard\n" +
                "Sheet Music\n" +
                "Snare\n" +
                "Tom Tom Drum", shop.listAllStock());
    }

    @Test
    public void canListAllItemsByClass() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(keyBoard2);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(tomTomDrum2);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals("Black BC Rich G756 Guitar", shop.listItemsByClass(Guitar.class));
        assertEquals("Blue Tama Tiger Mark 7 Drum Kit", shop.listItemsByClass(DrumKit.class));
        assertEquals("Sheet Music", shop.listItemsByClass(SheetMusic.class));
        assertEquals("Red Roland ty6788 Keyboard\n" +
                "Black Steinway X$6788 Keyboard", shop.listItemsByClass(KeyBoard.class));
        assertEquals("Bass Drum", shop.listItemsByClass(BassDrum.class));
    }

    @Test
    public void canSearchByName() {
        shop.addStock(keyBoard);
        shop.addStock(keyBoard2);
        shop.addStock(guitar);
        assertEquals("Keyboard: 2", shop.searchByProductName("Keyboard"));
        assertEquals("Guitar: 1", shop.searchByProductName("Guitar"));
    }

    @Test
    public void canDislayStock() {
        shop.addStock(guitar);
        shop.addStock(drumKit);
        shop.addStock(keyBoard);
        shop.addStock(keyBoard2);
        shop.addStock(bassDrum2);
        shop.addStock(snare2);
        shop.addStock(snare);
        shop.addStock(tomTomDrum2);
        shop.addStock(tomTomDrum);
        shop.addStock(cymbal2);
        shop.addStock(sheetMusic);
        assertEquals("Guitar: 1\n" +
                "Drum Kit: 1\n" +
                "Keyboard: 2\n" +
                "Bass Drum: 1\n" +
                "Snare: 2\n" +
                "Tom Tom Drum: 2\n" +
                "Cymbal: 1\n" +
                "Sheet Music: 1", shop.displayStock());
    }


}
