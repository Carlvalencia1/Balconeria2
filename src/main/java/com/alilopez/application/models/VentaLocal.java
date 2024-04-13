package com.alilopez.application.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class VentaLocal extends Venta{
    private float descuentoLocal = 0;
    private String idVendedor;

    public VentaLocal(String idVenta, double monto, LocalDate fecha, double cantidad, LocalTime hora, float descuentoLocal, String idVendedor) {
        super(idVenta, monto, fecha, cantidad, hora);
        this.descuentoLocal = descuentoLocal;
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "VentaLocal" + '\n' +
                "Descuento local: " + descuentoLocal + '\n' +
                "Id Vendedor: " + idVendedor +  '\n' +
                "Id Venta: " + idVenta + '\n' +
                "Monto: " + monto +  '\n' +
                "Fecha: " + fecha +  '\n' +
                "Cantidad: " + cantidad +  '\n';
    }

    public double getMonto(){
        return monto;
    }

    public LocalDate getFecha(){
        return fecha;
    }

    public double getCantidad(){
        return cantidad;
    }

    public String getIdVenta(){
        return idVenta;
    }

    public float getDescuentoLocal() {
        return descuentoLocal;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

}
