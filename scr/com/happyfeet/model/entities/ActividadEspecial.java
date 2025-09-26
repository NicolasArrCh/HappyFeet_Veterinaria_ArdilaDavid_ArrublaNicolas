package com.happyfeet.model.entities;

import java.time.LocalDate;

public class ActividadEspecial {
    private int id;
    private TipoActividad tipo;
    private String descripcion;
    private LocalDate fecha;

    public enum TipoActividad {
        ADOPCION,
        VACUNACION,
        CLUB_FRECUENTES
    }

    public ActividadEspecial() {}

    public ActividadEspecial(int id, TipoActividad tipo, String descripcion, LocalDate fecha) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public TipoActividad getTipo() { return tipo; }
    public void setTipo(TipoActividad tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        return "ActividadEspecial{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                '}';
    }

}
