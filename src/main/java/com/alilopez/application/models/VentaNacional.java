package com.alilopez.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class VentaNacional extends Venta{
    private float costoEnvio;
    private String direccion;

    public VentaNacional(String idVenta, double monto, LocalDate date, double cantidad, LocalTime hora, float costoEnvio, String direccion) {
        super(idVenta, monto, date, cantidad, hora);
        this.costoEnvio = costoEnvio;
        this.direccion = direccion;
    }
    public float getCostoEnvio() {
        return costoEnvio;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "VentaNacional" + '\n' +
                "Costo Envio: " + costoEnvio + '\n' +
                "Dirección: " + direccion + '\n' +
                "Id Venta: " + idVenta + '\n' +
                "Monto: " + monto + '\n' +
                "Fecha: " + fecha + '\n' +
                "Cantidad: " + cantidad;
    }
}
