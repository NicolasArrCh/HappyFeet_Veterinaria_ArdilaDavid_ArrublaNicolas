package com.happyfeet.model.entities;

import java.time.LocalDateTime;

public class Factura {
    private int id;
    private Dueno dueno; // Relación con el dueño
    private LocalDateTime fechaEmision;
    private double total;

    public Factura() {}

    public Factura(int id, Dueno dueno, LocalDateTime fechaEmision, double total) {
        this.id = id;
        this.dueno = dueno;
        this.fechaEmision = fechaEmision;
        this.total = total;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Dueno getDueno() { return dueno; }
    public void setDueno(Dueno dueno) { this.dueno = dueno; }

    public LocalDateTime getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDateTime fechaEmision) { this.fechaEmision = fechaEmision; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", dueno=" + (dueno != null ? dueno.getNombreCompleto() : "null") +
                ", fechaEmision=" + fechaEmision +
                ", total=" + total +
                '}';
    }
}
