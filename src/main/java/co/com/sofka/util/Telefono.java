package co.com.sofka.util;

public enum Telefono {
    CELULAR(true),
    PARTICULAR(false);

    private final boolean value;

    public boolean isValue () {
        return value;
    }

    Telefono (boolean value) {
        this.value = value;
    }
}
