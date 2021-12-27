package co.com.sofka.util;

public enum Persona {
    NATURAL(true),
    JURIDICA(false);

    private final boolean value;

    public boolean isValue () {
        return value;
    }

    Persona (boolean value) {
        this.value = value;
    }
}
