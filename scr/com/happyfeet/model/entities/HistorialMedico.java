package com.happyfeet.model.entities;

import java.time.LocalDate;

public class HistorialMedico {
    private int id;
    private Mascota mascota;
    private LocalDate fechaEvento;
    private EventoTipo eventoTipo;
    private String descripcion;
    private String diagnostico;
    private String tratamientoRecomendado;

    // Constructor vacío (recomendado para JDBC)
    public HistorialMedico() {}

    // Constructor con parámetros
    public HistorialMedico(int id, Mascota mascota, LocalDate fechaEvento, EventoTipo eventoTipo, String descripcion, String diagnostico, String tratamientoRecomendado) {
        this.id = id;
        this.mascota = mascota;
        this.fechaEvento = fechaEvento;
        this.eventoTipo = eventoTipo;
        this.descripcion = descripcion;
        this.diagnostico = diagnostico;
        this.tratamientoRecomendado = tratamientoRecomendado;
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

    public LocalDate getFechaEvento() {
        return fechaEvento;
    }
    public void setFechaEvento(LocalDate fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public EventoTipo getEventoTipo() {
        return eventoTipo;
    }
    public void setEventoTipo(EventoTipo eventoTipo) {
        this.eventoTipo = eventoTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamientoRecomendado() {
        return tratamientoRecomendado;
    }
    public void setTratamientoRecomendado(String tratamientoRecomendado) {
        this.tratamientoRecomendado = tratamientoRecomendado;
    }

    @Override
    public String toString() {
        return "HistorialMedico{" +
                "id=" + id +
                ", mascota=" + (mascota != null ? mascota.getNombre() : "null") +
                ", fechaEvento=" + fechaEvento +
                ", eventoTipo=" + (eventoTipo != null ? eventoTipo.getNombre() : "null") +
                ", descripcion='" + descripcion + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", tratamientoRecomendado='" + tratamientoRecomendado + '\'' +
                '}';
    }
}
