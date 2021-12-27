package co.com.sofka.util;

public enum Banco {
    BBVA("BBVA"),
    BANCOLOMBIA("Bancolombia"),
    COLPATRIA("Colpatria"),
    DAVIVIENDA("Davivienda"),
    CITIBANK("Citibank");

    private final String value;

    public String getValue () {
        return value;
    }

    Banco (String value) {
        this.value = value;
    }
}
