package co.com.sofka.model;

import co.com.sofka.util.*;

public class DespegarModel {
    private String origen;
    private String destino;
    private String nombre;
    private String apellido;
    private Documento tipoDocumento;
    private String numeroDocumento;
    private String estado;
    private String ciudad;
    private String direccion;

    public String getOrigen () {
        return origen;
    }

    public void setOrigen (String origen) {
        this.origen = origen;
    }

    public String getDestino () {
        return destino;
    }

    public void setDestino (String destino) {
        this.destino = destino;
    }


    public String getNombre () {
        return nombre;
    }

    public void setNombre (String nombre) {
        this.nombre = nombre;
    }


    public String getApellido () {
        return apellido;
    }

    public void setApellido (String apellido) {
        this.apellido = apellido;
    }

    public Documento getTipoDocumento () {
        return tipoDocumento;
    }

    public void setTipoDocumento (Documento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento () {
        return numeroDocumento;
    }

    public void setNumeroDocumento (String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getEstado () {
        return estado;
    }

    public void setEstado (String estado) {
        this.estado = estado;
    }

    public String getCiudad () {
        return ciudad;
    }

    public void setCiudad (String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion () {
        return direccion;
    }

    public void setDireccion (String direccion) {
        this.direccion = direccion;
    }


}
