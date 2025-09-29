package com.happyfeet.model.entities;

public class ProductoTipo {
    private int id;
    private String nombre;

    // Constructor vacío (recomendado para JDBC)
    public ProductoTipo() {}

    // Constructor con parámetros
    public ProductoTipo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ProductoTipo{" +
                "id=" + id +
                ", nombre='" + nombre +
                '}';
    }
}
