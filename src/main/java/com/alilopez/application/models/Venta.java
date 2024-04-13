package com.alilopez.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Venta {
    protected String idVenta;
    protected double monto;
    protected LocalDate fecha;
    protected double cantidad;
    protected LocalTime hora;
    public Venta(String idVenta, double monto, LocalDate fecha, double cantidad, LocalTime hora) {
        this.idVenta = idVenta;
        this.monto = monto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.hora = hora;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public LocalTime getHora() {
        return hora;
    }
}
