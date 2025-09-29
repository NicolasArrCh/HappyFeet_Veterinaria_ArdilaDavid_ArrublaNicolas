package com.happyfeet.controller;

import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.service.impl.CitaServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class CitaController {

    private CitaServiceImpl citaService;

    public CitaController() {
        this.citaService = new CitaServiceImpl();
    }

    // Registrar nueva cita
    public String agregarCita(int mascotaId, LocalDateTime fechaHora, String motivo, int estadoId, String estadoNombre) {
        try {
            Mascota mascota = new Mascota(mascotaId); // ⚠️ Aquí solo se pasa el ID
            CitaEstado estado = new CitaEstado(estadoId, estadoNombre);
            Cita cita = new Cita(0, mascota, fechaHora, motivo, estado);

            citaService.agregarCita(cita);
            return "✅ Cita registrada con éxito (ID: " + cita.getId() + ")";
        } catch (Exception e) {
            return "❌ Error al registrar cita: " + e.getMessage();
        }
    }

    // Listar todas las citas
    public List<Cita> obtenerTodasCitas() {
        try {
            return citaService.obtenerTodasCitas();
        } catch (Exception e) {
            System.out.println("❌ Error al listar citas: " + e.getMessage());
            return null;
        }
    }

    // Buscar cita por ID
    public Cita obtenerCitaPorId(int id) {
        try {
            return citaService.obtenerCitaPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar cita
    public String actualizarCita(int id, int mascotaId, LocalDateTime fechaHora, String motivo, int estadoId, String estadoNombre) {
        try {
            Mascota mascota = new Mascota(mascotaId);
            CitaEstado estado = new CitaEstado(estadoId, estadoNombre);
            Cita cita = new Cita(id, mascota, fechaHora, motivo, estado);

            citaService.actualizarCita(cita);
            return "✅ Cita actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar cita: " + e.getMessage();
        }
    }

    // Cancelar cita
    public String eliminarCita(int id) {
        try {
            citaService.eliminarCita(id);
            return "🗑️ Cita cancelada correctamente.";
        } catch (Exception e) {
            return "❌ Error al cancelar cita: " + e.getMessage();
        }
    }

    // Listar citas por mascota
    public List<Cita> obtenerPorMascota(int mascotaId) {
        try {
            return citaService.obtenerPorMascota(mascotaId);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar citas por mascota: " + e.getMessage());
            return null;
        }
    }

    // Listar citas por fecha
    public List<Cita> obtenerPorFecha(LocalDateTime fecha) {
        try {
            return citaService.obtenerPorFecha(fecha);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar citas por fecha: " + e.getMessage());
            return null;
        }
    }

    // Listar citas por estado
    public List<Cita> obtenerPorEstado(CitaEstado estado) {
        try {
            return citaService.obtenerPorEstado(estado);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar citas por estado: " + e.getMessage());
            return null;
        }
    }
}