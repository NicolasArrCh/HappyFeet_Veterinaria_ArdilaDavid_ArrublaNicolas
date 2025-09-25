package com.happyfeet.model.entities;

import java.time.LocalDate;

public class Mascota {
    private int id;
    private int duenoId;
    private String nombre;
    private int razaId;
    private LocalDate fechaNacimiento;
    private String sexo;  // Podríamos hacerlo Enum más adelante
    private String urlFoto;

    public Mascota() {}

    public Mascota(int id, int duenoId, String nombre, int razaId, LocalDate fechaNacimiento, String sexo, String urlFoto) {
        this.id = id;
        this.duenoId = duenoId;
        this.nombre = nombre;
        this.razaId = razaId;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.urlFoto = urlFoto;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getDuenoId() { return duenoId; }
    public void setDuenoId(int duenoId) { this.duenoId = duenoId; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getRazaId() { return razaId; }
    public void setRazaId(int razaId) { this.razaId = razaId; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public String getUrlFoto() { return urlFoto; }
    public void setUrlFoto(String urlFoto) { this.urlFoto = urlFoto; }

    @Override
    public String toString() {
        return "Mascota{" +
                "id=" + id +
                ", duenoId=" + duenoId +
                ", nombre='" + nombre + '\'' +
                ", razaId=" + razaId +
                ", fechaNacimiento=" + fechaNacimiento +
                ", sexo='" + sexo + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                '}';
    }
}
