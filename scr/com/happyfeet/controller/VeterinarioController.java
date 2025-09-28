package com.happyfeet.controller;

import com.happyfeet.model.entities.Veterinario;
import com.happyfeet.service.impl.VeterinarioServiceImpl;
import com.happyfeet.service.interfaces.IVeterinarioService;

import java.util.List;

public class VeterinarioController {

    private final IVeterinarioService veterinarioService;

    public VeterinarioController() {
        this.veterinarioService = new VeterinarioServiceImpl();
    }

    // Registrar veterinario
    public String registrarVeterinario(String nombreCompleto, String documentoIdentidad, String especialidad, String telefono, String email) {
        try {
            Veterinario veterinario = new Veterinario(0, nombreCompleto, documentoIdentidad, especialidad, telefono, email);
            veterinarioService.registrarVeterinario(veterinario);
            return "✅ Veterinario registrado correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar veterinario: " + e.getMessage();
        }
    }

    // Listar veterinarios
    public List<Veterinario> listarVeterinarios() {
        try {
            return veterinarioService.listarVeterinarios();
        } catch (Exception e) {
            System.out.println("❌ Error al listar veterinarios: " + e.getMessage());
            return null;
        }
    }

    // Buscar veterinario por ID
    public Veterinario buscarVeterinarioPorId(Integer id) {
        try {
            return veterinarioService.buscarVeterinarioPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar veterinario con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar veterinario
    public String actualizarVeterinario(int id, String nombreCompleto, String documentoIdentidad, String especialidad, String telefono, String email) {
        try {
            Veterinario veterinario = new Veterinario(id, nombreCompleto, documentoIdentidad, especialidad, telefono, email);
            veterinarioService.actualizarVeterinario(veterinario);
            return "✅ Veterinario actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar veterinario: " + e.getMessage();
        }
    }

    // Eliminar veterinario
    public String eliminarVeterinario(Integer id) {
        try {
            veterinarioService.eliminarVeterinario(id);
            return "🗑️ Veterinario eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar veterinario con ID " + id + ": " + e.getMessage();
        }
    }
}