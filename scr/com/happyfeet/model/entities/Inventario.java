package com.happyfeet.model.entities;

import java.time.LocalDate;

public class Inventario {
    private int id;
    private String nombreProducto;
    private ProductoTipo productoTipo;
    private String descripcion;
    private String fabricante;
    private String lote;
    private int cantidadStock;
    private int stockMinimo;
    private LocalDate fechaVencimiento;
    private double precioVenta;

    // Constructor vacío (recomendado para JDBC)
    public Inventario() {}

    // Constructor con parámetros
    public Inventario(int id, String nombreProducto, ProductoTipo productoTipo, String descripcion, String fabricante, String lote, int cantidadStock, int stockMinimo, LocalDate fechaVencimiento, double precioVenta) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.productoTipo = productoTipo;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.lote = lote;
        this.cantidadStock = cantidadStock;
        this.stockMinimo = stockMinimo;
        this.fechaVencimiento = fechaVencimiento;
        this.precioVenta = precioVenta;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public ProductoTipo getProductoTipo() {
        return productoTipo;
    }
    public void setProductoTipo(ProductoTipo productoTipo) {
        this.productoTipo = productoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFabricante() {
        return fabricante;
    }
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }
    public void setCantidadStock(int cantidadStock) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", productoTipo=" + (productoTipo != null ? productoTipo.getNombre() : "null") +
                ", descripcion='" + descripcion + '\'' +
                ", fabricante='" + fabricante + '\'' +
                ", lote='" + lote + '\'' +
                ", cantidadStock=" + cantidadStock +
                ", stockMinimo=" + stockMinimo +
                ", fechaVencimiento=" + fechaVencimiento +
                ", precioVenta=" + precioVenta +
                '}';
    }
}
