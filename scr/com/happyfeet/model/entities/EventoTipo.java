package com.happyfeet.model.entities;

import java.time.LocalDate;

public class EventoTipo {
    private int id;
    private String nombre;

    // Constructor vacío (recomendado para JDBC)
    public EventoTipo() {}

    // Constructor con parámetros
    public EventoTipo(int id, String nombre) {
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
        return "EventoTipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
