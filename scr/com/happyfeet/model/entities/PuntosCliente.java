package com.happyfeet.model.entities;

public class PuntosCliente {
    private int id;
    private Dueno dueno;
    private int puntos;

    public PuntosCliente() {}

    public PuntosCliente(int id, Dueno dueno, int puntos) {
        this.id = id;
        this.dueno = dueno;
        this.puntos = puntos;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Dueno getDueno() { return dueno; }
    public void setDueno(Dueno dueno) { this.dueno = dueno; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    @Override
    public String toString() {
        return "PuntosCliente{" +
                "id=" + id +
                ", dueno=" + (dueno != null ? dueno.getNombreCompleto() : "null") +
                ", puntos=" + puntos +
                '}';
    }

}
