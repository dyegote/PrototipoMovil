package com.liveo.principal.clientes;

/**
 * Created by MiPc on 15/07/2014.
 */
public class ClienteDTO {
    private String numeroCliente;
    private String nombreCliente;
    private String identificacion;
    private String tipoIdentificacion;

    public ClienteDTO(String nombreCliente, String identificacion, String numeroCliente,String tipoIdentificacion)
    {
        this.setNumeroCliente(numeroCliente);
        this.setNombreCliente(nombreCliente);
        this.setIdentificacion(identificacion);
        this.setTipoIdentificacion(tipoIdentificacion);
    }

    public String getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(String numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
}
