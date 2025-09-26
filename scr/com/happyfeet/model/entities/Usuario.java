package com.happyfeet.model.entities;

public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contrasena;
    private Rol rol;

    // Enum interno para el rol
    public enum Rol {
        ADMIN,
        VETERINARIO,
        AUXILIAR
    }

    public Usuario() {}

    public Usuario(int id, String nombreUsuario, String contrasena, Rol rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreUsuario() { return nombreUsuario; }
    public void setNombreUsuario(String nombreUsuario) { this.nombreUsuario = nombreUsuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario{id=" + id +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", rol=" + rol + '}';
    }
}

