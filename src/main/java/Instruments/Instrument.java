package Instruments;

public abstract class Instrument {

    private String name;
    private String material;
    private String colour;
    private Type type;
    private String make;
    private String model;

    public Instrument(String name, String material, String colour, Type type, String make, String model) {
        this.name = name;
        this.material = material;
        this.colour = colour;
        this.type = type;
        this.make = make;
        this.model = model;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type.getType();
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
