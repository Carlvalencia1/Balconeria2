package com.alilopez.application.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Caja {
    private LocalDateTime fecha;
    private String idVendedor;
    private double monto;
    private boolean status;

    public Caja(LocalDateTime fecha, String idVendedor, double monto) {
        this.fecha = fecha;
        this.idVendedor = idVendedor;
        this.monto = monto;
    }
    public Caja(){
        this.status = false;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public double getMonto() {
        return monto;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
