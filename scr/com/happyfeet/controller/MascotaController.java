package com.happyfeet.controller;

import com.happyfeet.model.entities.Mascota;
import com.happyfeet.service.impl.MascotaServiceImpl;
import com.happyfeet.service.interfaces.IMascotaService;

import java.util.List;

public class MascotaController {

    private IMascotaService mascotaService = new MascotaServiceImpl();

    // Registrar nueva mascota
    public String registrarMascota(Mascota mascota) {
        try {
            mascotaService.registrarMascota(mascota);
            return "✅ Mascota registrada correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar mascota: " + e.getMessage();
        }
    }

    // Listar todas las mascotas
    public List<Mascota> listarMascotas() {
        try {
            return mascotaService.listarMascotas();
        } catch (Exception e) {
            System.out.println("❌ Error al listar mascotas: " + e.getMessage());
            return null;
        }
    }

    // Buscar mascota por ID
    public Mascota buscarMascotaPorId(Integer id) {
        try {
            return mascotaService.buscarMascotaPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar mascota con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar mascota
    public String actualizarMascota(Mascota mascota) {
        try {
            mascotaService.actualizarMascota(mascota);
            return "✅ Mascota actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar mascota: " + e.getMessage();
        }
    }

    // Eliminar mascota
    public String eliminarMascota(Integer id) {
        try {
            mascotaService.eliminarMascota(id);
            return "🗑️ Mascota eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar mascota con ID " + id + ": " + e.getMessage();
        }
    }
}
