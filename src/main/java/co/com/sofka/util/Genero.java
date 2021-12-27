package co.com.sofka.util;

public enum Genero {
    MASCULINO(true),
    FEMENINO(false);

    private final boolean value;

    public boolean isValue () {
        return value;
    }

    Genero (boolean value) {
        this.value = value;
    }
}
