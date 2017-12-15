package Instruments;

public enum Colour {

    BLACK ("Black"),
    WHITE ("White"),
    YELLOW ("Yellow"),
    ORANGE ("Orange"),
    GREEN ("Green"),
    BLUE  ("Blue"),
    PURPLE ("Purple"),
    RED ("Red"),
    GOLD ("Gold"),
    SILVER ("Silver");

    final String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}

