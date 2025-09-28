package com.happyfeet.controller;

import com.happyfeet.model.entities.Usuario;
import com.happyfeet.model.enums.Rol;
import com.happyfeet.service.impl.UsuarioServiceImpl;
import com.happyfeet.service.interfaces.IUsuarioService;

import java.util.List;

public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioServiceImpl();
    }

    // Registrar usuario
    public String registrarUsuario(String nombreUsuario, String contrasena, String rolStr) {
        try {
            Rol rol = Rol.valueOf(rolStr.toUpperCase());
            Usuario usuario = new Usuario(0, nombreUsuario, contrasena, rol);
            usuarioService.registrarUsuario(usuario);
            return "✅ Usuario registrado correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar usuario: " + e.getMessage();
        }
    }

    // Listar usuarios
    public List<Usuario> listarUsuarios() {
        try {
            return usuarioService.listarUsuarios();
        } catch (Exception e) {
            System.out.println("❌ Error al listar usuarios: " + e.getMessage());
            return null;
        }
    }

    // Buscar usuario por ID
    public Usuario buscarUsuarioPorId(Integer id) {
        try {
            return usuarioService.buscarUsuarioPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar usuario con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar usuario
    public String actualizarUsuario(int id, String nombreUsuario, String contrasena, String rolStr) {
        try {
            Rol rol = Rol.valueOf(rolStr.toUpperCase());
            Usuario usuario = new Usuario(id, nombreUsuario, contrasena, rol);
            usuarioService.actualizarUsuario(usuario);
            return "✅ Usuario actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar usuario: " + e.getMessage();
        }
    }

    // Eliminar usuario
    public String eliminarUsuario(Integer id) {
        try {
            usuarioService.eliminarUsuario(id);
            return "🗑️ Usuario eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar usuario con ID " + id + ": " + e.getMessage();
        }
    }

    // Autenticación (login)
    public String autenticar(String nombreUsuario, String contrasena) {
        try {
            Usuario usuario = usuarioService.autenticar(nombreUsuario, contrasena);
            return "✅ Usuario autenticado: " + usuario.getNombreUsuario() + " (Rol: " + usuario.getRol() + ")";
        } catch (Exception e) {
            return "❌ Error de autenticación: " + e.getMessage();
        }
    }
}
