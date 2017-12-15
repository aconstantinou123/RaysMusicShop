package Instruments;

public enum Colour {

    BLACK ("black"),
    WHITE ("white"),
    YELLOW ("yellow"),
    ORANGE ("orange"),
    GREEN ("green"),
    BLUE  ("blue"),
    PURPLE ("purple"),
    RED ("red"),
    GOLD ("gold"),
    SILVER ("silver");

    final String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}

