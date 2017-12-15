package Instruments;

import Instruments.Colour;

public class Instrument {

    private String material;
    private Colour colour;
    private Type type;
    private Make make;
    private String model;

    public Instrument(String material, Colour colour, Type type, Make make, String model) {
        this.material = material;
        this.colour = colour;
        this.type = type;
        this.make = make;
        this.model = model;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColour() {
        return colour.getColour();
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public String getType() {
        return type.getType();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMake() {
        return make.getMake();
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}