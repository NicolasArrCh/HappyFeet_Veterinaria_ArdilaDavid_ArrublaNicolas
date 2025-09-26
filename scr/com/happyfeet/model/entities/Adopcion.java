package com.happyfeet.model.entities;

import java.time.LocalDate;

public class Adopcion {
    private int id;
    private Mascota mascota;
    private Dueno nuevoDueno;
    private LocalDate fecha;
    private String contrato;

    public Adopcion() {}

    public Adopcion(int id, Mascota mascota, Dueno nuevoDueno, LocalDate fecha, String contrato) {
        this.id = id;
        this.mascota = mascota;
        this.nuevoDueno = nuevoDueno;
        this.fecha = fecha;
        this.contrato = contrato;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Mascota getMascota() { return mascota; }
    public void setMascota(Mascota mascota) { this.mascota = mascota; }

    public Dueno getNuevoDueno() { return nuevoDueno; }
    public void setNuevoDueno(Dueno nuevoDueno) { this.nuevoDueno = nuevoDueno; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getContrato() { return contrato; }
    public void setContrato(String contrato) { this.contrato = contrato; }

    @Override
    public String toString() {
        return "Adopcion{" +
                "id=" + id +
                ", mascota=" + (mascota != null ? mascota.getNombre() : "null") +
                ", nuevoDueno=" + (nuevoDueno != null ? nuevoDueno.getNombreCompleto() : "null") +
                ", fecha=" + fecha +
                ", contrato='" + contrato + '\'' +
                '}';
    }
}
