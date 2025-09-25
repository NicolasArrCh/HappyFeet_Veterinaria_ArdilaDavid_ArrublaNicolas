package com.happyfeet.model.entities;

import java.time.LocalDate;

public class Dueno {
    private int id;
    private String nombreCompleto;
    private String documentoIdentidad;
    private String direccion;
    private String telefono;
    private String email;

    // Constructor vacío (recomendado para JDBC)
    public Dueno() {}

    // Constructor con parámetros
    public Dueno(int id, String nombreCompleto, String documentoIdentidad, String direccion, String telefono, String email) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Dueño{" +
                "id=" + id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
