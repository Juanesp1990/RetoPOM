package co.com.sofka.util;

public enum Documento {
    CEDULA("Cedula"),
    NIT("Nit"),
    PASAPORTE("Pasaporte"),
    CEDULAEXTRANJERA("CedulaExtranjera");
    private final String value;

    public String getValue () {
        return value;
    }

    Documento (String value) {
        this.value = value;
    }
}
