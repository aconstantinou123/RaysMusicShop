import Instruments.Colour;
import Instruments.Guitar;
import Instruments.Make;
import Instruments.Type;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {

    Guitar guitar;

    @Before
    public void before(){
        guitar = new Guitar("mahogany", Colour.BLACK, Type.STRING,
                Make.BCRICH, "G756", 6, true, 200, 300 );
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
}
