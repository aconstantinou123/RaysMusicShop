package Instruments;

import Drums.IDrum;
import MiscItems.DrumStick;

import java.util.ArrayList;

public class DrumKit extends Instrument{

    private ArrayList<IDrum> drums;
    private DrumStick drumStick;

    public DrumKit(String name, String material, Colour colour, Type type, Make make, String model, DrumStick drumStick) {
        super(name, material, colour, type, make, model);
        this.drums = new ArrayList<>();
        this.drumStick = drumStick;
    }

    public ArrayList<IDrum> getDrums() {
        return drums;
    }

    public void addDrum(IDrum drum) {
        this.drums.add(drum);
    }

    public void removeDrum(IDrum drum) {
        this.drums.remove(drum);
    }

    public int numberOfDrums() {
        return drums.size();
    }

    public DrumStick getDrumStick() {
        return drumStick;
    }

    public void setDrumStick(DrumStick drumStick) {
        this.drumStick = drumStick;
    }

    public double getBuyPrice() {
        double price = 0;
        for (IDrum drum : drums){
            price += drum.getBuyPrice();
        }
        price += drumStick.getBuyPrice();
        return price;
    }

    public double getSellPrice() {
        double price = 0;
        for (IDrum drum : drums){
            price += drum.getSellPrice();
        }
        price += drumStick.getSellPrice();
        return price;
    }


}
