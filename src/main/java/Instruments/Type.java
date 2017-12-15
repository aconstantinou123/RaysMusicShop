package Instruments;

public enum Type {

    STRING ("string"),
    BRASS ("brass"),
    WOODWIND ("woodwind"),
    PERCUSSION ("percussion"),
    KEYBOARD ("keyboard");

    final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
