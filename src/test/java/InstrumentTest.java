import Drums.BassDrum;
import Drums.Cymbal;
import Drums.Snare;
import Drums.TomTomDrum;
import Instruments.*;
import MiscItems.DrumStick;
import MiscItems.GuitarString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {

    Guitar guitar;
    GuitarString guitarString;

    BassDrum bassDrum;
    Cymbal cymbal;
    Snare snare;
    TomTomDrum tomTomDrum;
    DrumStick drumStick;
    DrumKit drumKit;

    KeyBoard keyBoard;


    @Before
    public void before(){
        guitarString = new GuitarString(5, 10);
        guitar = new Guitar("mahogany", Colour.BLACK, Type.STRING,
                Make.BCRICH, "G756", 6, true, 200, 300, guitarString);

        bassDrum = new BassDrum(150, 275);
        cymbal = new Cymbal(50, 75);
        snare = new Snare(70, 100);
        tomTomDrum = new TomTomDrum(70, 150);
        drumStick = new DrumStick(10, 20);
        drumKit = new DrumKit("Oak", Colour.BLUE, Type.PERCUSSION, Make.TAMA, "Tiger Mark 7", drumStick);

        keyBoard = new KeyBoard("plastic", Colour.RED, Type.KEYBOARD, Make.ROLAND, "ty6788", 91,
        200, 300 );
    }

    @Test
    public void canGetColour(){
        assertEquals("black", guitar.getColour());
    }

    @Test
    public void canSetMake(){
        guitar.setMake(Make.FENDER);
        assertEquals("Fender", guitar.getMake());
    }

    @Test
    public void getTotalBuyPrice(){
        assertEquals(205, guitar.getBuyPrice(), 0.1);
    }

    @Test
    public void getTotalSellPrice(){
        assertEquals(310, guitar.getSellPrice(), 0.1);
    }

    @Test
    public void canGetDrumKitSize(){
        assertEquals(0, drumKit.numberOfDrums());
    }

    @Test
    public void canAddDrum(){
        drumKit.addDrum(bassDrum);
        assertEquals(1, drumKit.numberOfDrums());
    }

    @Test
    public void canRemoveDrum(){
        drumKit.addDrum(bassDrum);
        drumKit.removeDrum(bassDrum);
        assertEquals(0, drumKit.numberOfDrums());
    }

    @Test
    public void canGetTotalBuyPrice(){
        drumKit.addDrum(bassDrum);
        drumKit.addDrum(tomTomDrum);
        drumKit.addDrum(cymbal);
        drumKit.addDrum(snare);
        assertEquals(350.0, drumKit.getBuyPrice(), 0.1);
    }

    @Test
    public void canGetTotalSellPrice(){
        drumKit.addDrum(bassDrum);
        drumKit.addDrum(tomTomDrum);
        drumKit.addDrum(cymbal);
        drumKit.addDrum(snare);
        assertEquals(620.0, drumKit.getSellPrice(), 0.1);
    }

    @Test
    public void canGetNumberOfKeys(){
        assertEquals(91, keyBoard.getNumberOfKeys());
    }

    @Test
    public void canSetBuyPrice(){
        keyBoard.setBuyPrice(2000);
        assertEquals(2000, keyBoard.getBuyPrice(), 0.1);
    }
}
