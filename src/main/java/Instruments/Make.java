package Instruments;

public enum Make {

    YAMAHA ("Yamaha"),
    FENDER ("Fender"),
    IBANEZ ("Ibanez"),
    ROLAND ("Roland"),
    STEINWAY ("Steinway"),
    ZILDJIAN ("Zildjain"),
    TAMA ("Tama"),
    BCRICH ("BC Rich");

    final String make;

    Make(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }
}
