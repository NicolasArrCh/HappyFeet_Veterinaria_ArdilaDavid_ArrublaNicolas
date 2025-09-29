package com.happyfeet.controller;

import com.happyfeet.model.entities.Adopcion;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.service.impl.AdopcionServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class AdopcionController {

    private AdopcionServiceImpl adopcionService;

    public AdopcionController() {
        this.adopcionService = new AdopcionServiceImpl();
    }

    // Registrar nueva adopción
    public String agregarAdopcion(int mascotaId, int duenoId, LocalDate fecha, String contrato) {
        try {
            Mascota mascota = new Mascota(mascotaId);
            Dueno dueno = new Dueno(duenoId, null, null, null, null, null);

            Adopcion adopcion = new Adopcion(0, mascota, dueno, fecha, contrato);
            adopcionService.agregarAdopcion(adopcion);
            return "✅ Adopción registrada con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar adopción: " + e.getMessage();
        }
    }

    // Listar todas las adopciones
    public List<Adopcion> obtenerTodasAdopcion() {
        try {
            return adopcionService.obtenerTodasAdopcion();
        } catch (Exception e) {
            System.out.println("❌ Error al listar adopciones: " + e.getMessage());
            return null;
        }
    }

    // Buscar adopción por ID
    public Adopcion obtenerAdopcionPorId(int id) {
        try {
            return adopcionService.obtenerAdopcionPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar adopción
    public String actualizarAdopcion(int id, int mascotaId, int duenoId, LocalDate fecha, String contrato) {
        try {
            Mascota mascota = new Mascota(mascotaId);
            Dueno dueno = new Dueno(duenoId, null, null, null, null, null);

            Adopcion adopcion = new Adopcion(id, mascota, dueno, fecha, contrato);
            adopcionService.actualizarAdopcion(adopcion);
            return "✅ Adopción actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar adopción: " + e.getMessage();
        }
    }

    // Eliminar adopción
    public String eliminarAdopcion(int id) {
        try {
            adopcionService.eliminarAdopcion(id);
            return "🗑️ Adopción eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar adopción: " + e.getMessage();
        }
    }

    // Listar adopciones por dueño
    public List<Adopcion> obtenerPorDueno(int duenoId) {
        try {
            return adopcionService.obtenerPorDueno(duenoId);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar adopciones por dueño: " + e.getMessage());
            return null;
        }
    }

    // Listar adopciones por mascota
    public List<Adopcion> obtenerPorMascota(int mascotaId) {
        try {
            return adopcionService.obtenerPorMascota(mascotaId);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar adopciones por mascota: " + e.getMessage());
            return null;
        }
    }

    // Listar adopciones por fecha
    public List<Adopcion> obtenerPorFecha(LocalDate fecha) {
        try {
            return adopcionService.obtenerPorFecha(fecha);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar adopciones por fecha: " + e.getMessage());
            return null;
        }
    }
}
