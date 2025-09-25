package com.happyfeet.model.entities;

public class ItemFactura {
    private int id;
    private Factura factura; // FK -> facturas.id
    private Inventario producto; // FK -> inventario.id (puede ser null si es servicio)
    private String servicioDescripcion; // Si no es producto, acá va el servicio
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    public ItemFactura() {}

    public ItemFactura(int id, Factura factura, Inventario producto, String servicioDescripcion,
                       int cantidad, double precioUnitario, double subtotal) {
        this.id = id;
        this.factura = factura;
        this.producto = producto;
        this.servicioDescripcion = servicioDescripcion;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }

    public Inventario getProducto() { return producto; }
    public void setProducto(Inventario producto) { this.producto = producto; }

    public String getServicioDescripcion() { return servicioDescripcion; }
    public void setServicioDescripcion(String servicioDescripcion) { this.servicioDescripcion = servicioDescripcion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(double precioUnitario) { this.precioUnitario = precioUnitario; }

    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "ItemFactura{" +
                "id=" + id +
                ", factura=" + (factura != null ? factura.getId() : "null") +
                ", producto=" + (producto != null ? producto.getId() : "Servicio") +
                ", servicioDescripcion='" + servicioDescripcion + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", subtotal=" + subtotal +
                '}';
    }
}
