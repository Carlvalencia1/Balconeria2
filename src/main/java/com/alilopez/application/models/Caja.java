package com.alilopez.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Caja {
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String idVendedor;
    private double monto;
    private boolean status;

    public Caja(LocalDate fecha, LocalTime horaEntrada, LocalTime horaSalida, String idVendedor, double monto) {
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.idVendedor = idVendedor;
        this.monto = monto;
    }

    public Caja(){
        this.status = false;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
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
