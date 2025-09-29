package com.happyfeet.model.entities;

public class Especie {
    private int id;
    private String nombre;

    // Constructor vacío (recomendado para JDBC)
    public Especie() {}

    // Constructor con parámetros
    public Especie(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setId(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Especie{id=" + id + ", nombre='" + nombre + "'}";
    }
}
