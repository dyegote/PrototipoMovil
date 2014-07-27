package com.liveo.principal.credito;

public class SolicitudMaestroDTO
{
    private String numeroSolicitud;
    private String fechaIngreso;
    private String identificacionCliente;
    private String nombreCliente;
    private String monto;
    private String oficina;

    public SolicitudMaestroDTO(String numeroSolicitud, String fechaIngreso, String identificacionCliente, String nombreCliente, String monto, String oficina)
    {
        this.setNumeroSolicitud(numeroSolicitud);
        this.setFechaIngreso(fechaIngreso);
        this.setIdentificacionCliente(identificacionCliente);
        this.setNombreCliente(nombreCliente);
        this.setMonto(monto);
        this.setOficina(oficina);
    }


    public String getNumeroSolicitud() {
        return numeroSolicitud;
    }

    public void setNumeroSolicitud(String numeroSolicitud) {
        this.numeroSolicitud = numeroSolicitud;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(String identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }
}
