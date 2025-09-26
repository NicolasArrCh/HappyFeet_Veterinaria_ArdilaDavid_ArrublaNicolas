package com.happyfeet.model.entities;

public class Raza {
    private int id;
    private String nombre;
    private Especie especie;

    // Constructor vacío (recomendado para JDBC)
    public Raza() {}

    // Constructor con parámetros
    public Raza(int id, String nombre, Especie especie) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
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
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getEspecie() {
        return especie;
    }
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    @Override
    public String toString() {
        return "Raza{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + (especie != null ? especie.getNombre() : "null") +
                '}';
    }
}
