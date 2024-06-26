package com.alilopez.application.models;

import com.alilopez.application.App;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class Tienda {
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Cafe> productos = new ArrayList<>();
    private ArrayList<String> tiposProductos = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<TrabajosLocales> ventasLocales = new ArrayList<>();
    private ArrayList<TrabajosNaciones> ventaNacionales = new ArrayList<>();
    private ArrayList<Caja> historial = new ArrayList<>();
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public ArrayList<TrabajosLocales> getVentasLocales() {
        return ventasLocales;
    }
    public ArrayList<Cafe> getProductos() {
        return productos;
    }
    public ArrayList<TrabajosNaciones> getVentaNacionales() {
        return ventaNacionales;
    }

    public ArrayList<Caja> getHistorial() {
        return historial;
    }

    public ArrayList<String> getTiposProductos() {
        return tiposProductos;
    }
    public ArrayList<TrabajosLocales> VLencontradas = new ArrayList<>();
    public ArrayList<TrabajosNaciones> VNencontradas = new ArrayList<>();
    public ArrayList<Caja> historialEncontrado = new ArrayList<>();

    public ArrayList<TrabajosLocales> getVLencontradas() {
        return VLencontradas;
    }

    public ArrayList<TrabajosNaciones> getVNencontradas() {
        return VNencontradas;
    }

    public ArrayList<Caja> getHistorialEncontrado() {
        return historialEncontrado;
    }

    public boolean closeCaja(LocalTime entrada, LocalTime salida){
        double total = 0;
        for (int i = 0; i < ventasLocales.size(); i++) {
            TrabajosLocales ventaAux = ventasLocales.get(i);
            if (ventaAux.getHora().isAfter(entrada) && ventaAux.getHora().isBefore(salida)) {
                total += ventaAux.getMonto();
            }
        }
        for (int i = 0; i < ventaNacionales.size(); i++) {
            TrabajosNaciones ventaAux = ventaNacionales.get(i);
            if (ventaAux.getHora().isAfter(entrada) && ventaAux.getHora().isBefore(salida)){
                total += ventaAux.getMonto();
            }
        };
        Caja caja = new Caja(LocalDate.now(), entrada, salida, App.getUser().getId(), total);
        return historial.add(caja);
    }


    public boolean addCliente(Cliente cliente){
        boolean flag = false;
        if (cliente.getComprado() >= 0 && cliente.getGastado() >= 0) {
            for (int i = 0; i < clientes.size(); i++) {
                if (cliente.getCorreo().equals(clientes.get(i).getCorreo()) && !flag) {
                    flag = true;
                }
            }
            if (!flag) {
                clientes.add(cliente);
            }
        }
        return flag;
    }
    public boolean addUsuario(Usuario user){
        boolean flag = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (user.getIdUsuario().equals(usuarios.get(i).getIdUsuario()) && !flag) {
                flag = true;
            }
        }
        if (!flag) {
            usuarios.add(user);
        }
        return flag;
    }
    public boolean addVentaLocal(double cantidad, String tipo, float descuento){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            if (tipo.equals(productos.get(i).getTipo()) && !flag && cantidad <= productos.get(i).getCantidad()){
                if (cantidad > 0) {
                    double restante = productos.get(i).getCantidad() - cantidad;
                    productos.get(i).setCantidad(restante);
                }
                String id = UUID.randomUUID().toString();
                double monto = (productos.get(i).getPrecio()*cantidad)-descuento;
                if (monto > 0){
                    LocalDate fecha = LocalDate.now();
                    LocalTime hora = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaVenta = LocalTime.parse(hora.format(formatter));
                    String idVendedor = App.getUser().getId();
                    TrabajosLocales ventaLocal = new TrabajosLocales(id, monto, fecha, cantidad, horaVenta , descuento, idVendedor);
                    ventasLocales.add(ventaLocal);
                    flag = true;
                }
            }
        }
        return flag;
    }
    public boolean addVentaNacional(double cantidad, String tipo, float costoEnvio, String direccion){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            if (tipo.equals(productos.get(i).getTipo()) && !flag && cantidad <= productos.get(i).getCantidad()){
                if (cantidad > 0) {
                    double restante = productos.get(i).getCantidad() - cantidad;
                    productos.get(i).setCantidad(restante);
                }
                double monto = productos.get(i).getPrecio()*cantidad;
                if (monto > 0 && costoEnvio > 0) {
                    String id = UUID.randomUUID().toString();
                    LocalDate fecha = LocalDate.now();
                    LocalTime hora = LocalTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime horaVenta = LocalTime.parse(hora.format(formatter));
                    TrabajosNaciones ventaNacional = new TrabajosNaciones(id, monto, fecha, cantidad, horaVenta , costoEnvio, direccion);
                    ventaNacionales.add(ventaNacional);
                    flag = true;
                }
            }
        }
        return flag;
    }
    public boolean addProducto(Cafe cafe){
        boolean flag = true;
        if (cafe.getCantidad() >= 0 && cafe.getPrecio() >= 0 && cafe.getCosto() >= 0 && cafe.getPeso() > 0) {
            for (int i = 0; i < productos.size(); i++) {
                if (cafe.getTipo().equals(productos.get(i).getTipo()) && flag){
                    flag = false;
                }
            }
            if (flag) {
                productos.add(cafe);
                tiposProductos.add(cafe.getTipo());
            }
        }
        return flag;
    }
    public boolean updateClient(String correo, float comprado, float gastado){
        boolean flag = false;
        if (comprado >= 0 && gastado >= 0) {
            for (int i = 0; i < clientes.size(); i++) {
                String userMail = clientes.get(i).getCorreo();
                if (userMail.equals(correo) && !flag){
                    flag = true;
                    clientes.get(i).setComprado(comprado);
                    clientes.get(i).setGastado(gastado);
                    i = clientes.size();
                }
            }
        }
        return flag;
    }

    public boolean updateUsuario(String id, int edad, String pass){
        boolean flag = false;
        for (int i = 0; i < usuarios.size(); i++) {
            String userID = usuarios.get(i).getIdUsuario();
            if (userID.equals(id) && !flag && edad >=15){
                flag = true;
                usuarios.get(i).setEdad(edad);
                usuarios.get(i).setPassword(pass);
                i = usuarios.size();
            }
        }
        return flag;
    }

    public boolean updateUsuario(String id,  String pass){
        boolean flag = false;
        for (int i = 0; i < usuarios.size(); i++) {
            String userID = usuarios.get(i).getIdUsuario();
            if (userID.equals(id) && !flag){
                flag = true;
                usuarios.get(i).setPassword(pass);
                i = usuarios.size();
            }
        }
        return flag;
    }
    public boolean updateProduct(String id, double cantidad, float precio, float costo ){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            String productId = productos.get(i).getTipo();
            if (productId.equals(id) && !flag && cantidad>=0 && precio > 0 && costo > 0){
                flag = true;
                productos.get(i).setCantidad(cantidad);
                productos.get(i).setPrecio(precio);
                productos.get(i).setCosto(costo);
                i = productos.size();
            }
        }
        return flag;
    }
    public boolean updateProduct(String id, double cantidad){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            String productId = productos.get(i).getTipo();
            if (productId.equals(id) && !flag && cantidad>=0){
                flag = true;
                productos.get(i).setCantidad(cantidad);
                i = productos.size();
            }
        }
        return flag;
    }

    public String searchUsuario(String id){
        String b = null;
        boolean flag = false;
        for (int i = 0; i < usuarios.size(); i++) {
            String userId = usuarios.get(i).getIdUsuario();
            if (userId.equals(id) && !flag){
                b = usuarios.get(i).toString();
                flag = true;
                i = usuarios.size();
            }
        }
        return b;
    }
    public boolean deleteUsuario(String id){
        boolean flag = false;
        for (int i = 0; i < usuarios.size(); i++) {
            String userId = usuarios.get(i).getIdUsuario();
            if (userId.equals(id) && !flag){
                usuarios.remove(i);
                flag = true;
                i = usuarios.size();
            }
        }
        return flag;
    }
    public boolean deleteVentaLocal(String id){
        boolean flag = false;
        for (int i = 0; i < ventasLocales.size(); i++) {
            String idVenta = ventasLocales.get(i).getIdVenta();
            if (idVenta.equals(id) && !flag){
                for (int j = 0; j < historial.size(); j++) {
                    LocalTime hora = ventasLocales.get(i).getHora();
                    LocalTime entrada = historial.get(j).getHoraEntrada();
                    LocalTime salida = historial.get(j).getHoraSalida();
                    if (hora.isAfter(entrada) && hora.isBefore(salida)) {
                        historial.get(j).setMonto(historial.get(j).getMonto()-ventasLocales.get(i).getMonto());
                        ventasLocales.remove(i);
                        flag = true;
                        j = historial.size();
                        i = ventasLocales.size();
                    }
                }
            }
        }
        return flag;
    }

    public boolean deleteVentaNacional(String id){
        boolean flag = false;
        for (int i = 0; i < ventaNacionales.size(); i++) {
            String idVenta = ventaNacionales.get(i).getIdVenta();
            if (idVenta.equals(id) && !flag){
                for (int j = 0; j < historial.size(); j++) {
                    LocalTime hora = ventaNacionales.get(i).getHora();
                    LocalTime entrada = historial.get(j).getHoraEntrada();
                    LocalTime salida = historial.get(j).getHoraSalida();
                    if (hora.isAfter(entrada) && hora.isBefore(salida)) {
                        historial.get(j).setMonto(historial.get(j).getMonto()-ventaNacionales.get(i).getMonto());
                        ventaNacionales.remove(i);
                        flag = true;
                        j = historial.size();
                        i = ventaNacionales.size();
                    }
                }
            }
        }
        return flag;
    }
    public String searchCliente(String mail){
        String b = null;
        boolean flag = false;
        for (int i = 0; i < clientes.size(); i++) {
            String clientMail = clientes.get(i).getCorreo();
            if (clientMail.equals(mail) && !flag){
                b = clientes.get(i).toString();
                flag = true;
                i = clientes.size();
            }
        }
        return b;
    }

    public String searchProducto(String id){
        String b = null;
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            String productId = productos.get(i).getTipo();
            if (productId.equals(id) && !flag){
                b = productos.get(i).toString();
                flag = true;
                i = productos.size();
            }
        }
        return b;
    }
    public boolean searchVentasLocales(LocalDate fecha){
        boolean flag = false;
        ArrayList<TrabajosLocales> aux = new ArrayList<>();
        for (int i = 0; i < ventasLocales.size(); i++) {
            LocalDate date = ventasLocales.get(i).getFecha();
            if (date.equals(fecha)) {
                aux.add(ventasLocales.get(i));
            }
        }
        VLencontradas = aux;
        if (!VLencontradas.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    public boolean searchVentasLocales(LocalDate fecha, LocalDate fecha2){
        ArrayList<TrabajosLocales> aux = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < ventasLocales.size(); i++) {
            LocalDate date = ventasLocales.get(i).getFecha();
            if ((date.isEqual(fecha) || date.isAfter(fecha)) && (date.isEqual(fecha2) || date.isBefore(fecha2))) {
                aux.add(ventasLocales.get(i));
            }
        }
        VLencontradas = aux;
        if (!VLencontradas.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    public boolean searchVentasNacionales(LocalDate fecha){
        ArrayList<TrabajosNaciones> aux = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < ventaNacionales.size(); i++) {
            LocalDate date = ventaNacionales.get(i).getFecha();
            if (date.equals(fecha)) {
                aux.add(ventaNacionales.get(i));
            }
        }
        VNencontradas = aux;
        if (!VNencontradas.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    public boolean searchVentasNacionales(LocalDate fecha, LocalDate fecha2){
        ArrayList<TrabajosNaciones> aux = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < ventaNacionales.size(); i++) {
            LocalDate date = ventaNacionales.get(i).getFecha();
            if ((date.isEqual(fecha) || date.isAfter(fecha)) && (date.isEqual(fecha2) || date.isBefore(fecha2))) {
                aux.add(ventaNacionales.get(i));
            }
        }
        VNencontradas = aux;
        if (!VNencontradas.isEmpty()) {
            flag = true;
        }
        return flag;
    }

    public boolean searchHistorial(LocalDate fecha){
        ArrayList<Caja> aux = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < historial.size(); i++) {
            LocalDate date = historial.get(i).getFecha();
            if (date.equals(fecha)) {
                aux.add(historial.get(i));
            }
        }
        historialEncontrado = aux;
        if (!historialEncontrado.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    public boolean searchHistorial(LocalDate fecha, LocalDate fecha2){
        ArrayList<Caja> aux = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < historial.size(); i++) {
            LocalDate date = historial.get(i).getFecha();
            if ((date.isEqual(fecha) || date.isAfter(fecha)) && (date.isEqual(fecha2) || date.isBefore(fecha2))) {
                aux.add(historial.get(i));
            }
        }
        historialEncontrado = aux;
        if (!historialEncontrado.isEmpty()) {
            flag = true;
        }
        return flag;
    }
    public boolean deleteCliente(String correo){
        boolean flag = false;
        for (int i = 0; i < clientes.size(); i++) {
            String clienteMail = clientes.get(i).getCorreo();
            if (clienteMail.equals(correo) && !flag){
                clientes.remove(i);
                flag = true;
                i = clientes.size();
            }
        }
        return flag;
    }

    public boolean deleteProducto(String id){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            String productId = productos.get(i).getTipo();
            if (productId.equals(id) && !flag){
                tiposProductos.remove(i);
                productos.remove(i);
                flag = true;
                i = productos.size();
            }
        }
        return flag;
    }

    public boolean warningCantidad(String tipo){
        boolean flag = false;
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getTipo().equals(tipo) && productos.get(i).getCantidad() < 10) {
                flag = true;
            }
        }
        return flag;
    }
}
