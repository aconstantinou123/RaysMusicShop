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

public class ShopTest {

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
    public void before() {
        guitarString = new GuitarString("Guitar String", 5, 10);
        guitar = new Guitar("Guitar", "mahogany", Colour.BLACK, Type.STRING,
                Make.BCRICH, "G756", 6, true, 200, 300, guitarString);

        bassDrum = new BassDrum("Bass Drum", 150, 275);
        cymbal = new Cymbal("Cymbal", 50, 75);
        snare = new Snare("Snare", 70, 100);
        tomTomDrum = new TomTomDrum("Tom Tom Drum", 70, 150);
        drumStick = new DrumStick("Drum Stick", 10, 20);
        drumKit = new DrumKit("Drum Kit", "Oak", Colour.BLUE, Type.PERCUSSION, Make.TAMA, "Tiger Mark 7", drumStick);

        keyBoard = new KeyBoard("Keyboard", "plastic", Colour.RED, Type.KEYBOARD, Make.ROLAND, "ty6788", 91,
                200, 300);

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


}
