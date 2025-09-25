package com.happyfeet.model.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cita {
    private int id;
    private Mascota mascota;
    private LocalDateTime fechaHora;
    private String motivo;
    private CitaEstado estado;


    // Constructor vacío (recomendado para JDBC)
    public Cita() {}

    // Constructor con parámetros
    public Cita(int id, Mascota mascota, LocalDateTime fechaHora, String motivo, CitaEstado estado) {
        this.id = id;
        this.mascota = mascota;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public CitaEstado getEstado() {
        return estado;
    }
    public void setEstado(CitaEstado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", mascota=" + (mascota != null ? mascota.getNombre() : "null") +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                ", estado=" + (estado != null ? estado.getNombre() : "null") +
                '}';
    }
}
