package Instruments;

import java.util.ArrayList;

public class DrumKit extends Instrument{

    private ArrayList<String> drums;

    public DrumKit(String material, Colour colour, Type type, Make make, String model) {
        super(material, colour, type, make, model);
    }
}
