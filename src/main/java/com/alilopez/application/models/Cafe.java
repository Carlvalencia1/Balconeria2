package com.alilopez.application.models;

public class Cafe {
    private float precio;
    private float peso;
    private String nombre;
    private double cantidad;
    private String tipo;
    private float costo;
    public Cafe(float precio, float peso, String nombre, double cantidad, String tipo, float costo) {
        this.precio = precio;
        this.peso = peso;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public float getPeso() {
        return peso;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return  "Nombre: " + nombre + '\n' +
                "Tipo: " + tipo + '\n' +
                "Precio: " + precio + "\n" +
                "Peso: " + peso + "\n" +
                "Cantidad: " + cantidad + '\n' +
                "Costo: " + costo + '\n';
    }
}
