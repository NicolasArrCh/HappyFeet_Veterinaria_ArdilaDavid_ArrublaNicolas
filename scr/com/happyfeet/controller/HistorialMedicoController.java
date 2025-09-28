package com.happyfeet.controller;

import com.happyfeet.model.entities.HistorialMedico;
import com.happyfeet.service.impl.HistorialMedicoServiceImpl;
import com.happyfeet.service.interfaces.IHistorialMedicoService;

import java.time.LocalDate;
import java.util.List;

public class HistorialMedicoController {

    private IHistorialMedicoService historialService = new HistorialMedicoServiceImpl();

    public void agregarHistorialMedico(HistorialMedico historial) {
        try {
            historialService.agregarHistorialMedico(historial);
            System.out.println("✅ Historial médico agregado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al agregar historial médico: " + e.getMessage());
        }
    }

    public void obtenerTodosHistorialesMedicos() {
        try {
            List<HistorialMedico> historiales = historialService.obtenerTodosHistorialesMedicos();
            historiales.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("❌ Error al listar historiales médicos: " + e.getMessage());
        }
    }

    public void obtenerHistorialMedicoPorId(int id) {
        try {
            HistorialMedico historial = historialService.obtenerHistorialMedicoPorId(id);
            System.out.println(historial);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener historial médico con ID " + id + ": " + e.getMessage());
        }
    }

    public void actualizarHistorialMedico(HistorialMedico historial) {
        try {
            historialService.actualizarHistorialMedico(historial);
            System.out.println("✅ Historial médico actualizado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al actualizar historial médico: " + e.getMessage());
        }
    }

    public void eliminarHistorialMedico(int id) {
        try {
            historialService.eliminarHistorialMedico(id);
            System.out.println("✅ Historial médico eliminado correctamente.");
        } catch (Exception e) {
            System.out.println("❌ Error al eliminar historial médico con ID " + id + ": " + e.getMessage());
        }
    }

    public void obtenerPorMascota(int mascotaId) {
        try {
            List<HistorialMedico> historiales = historialService.obtenerPorMascota(mascotaId);
            historiales.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener historiales médicos de la mascota ID " + mascotaId + ": " + e.getMessage());
        }
    }

    public void obtenerPorFecha(LocalDate fecha) {
        try {
            List<HistorialMedico> historiales = historialService.obtenerPorFecha(fecha);
            historiales.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener historiales médicos en fecha " + fecha + ": " + e.getMessage());
        }
    }

    public void obtenerPorEventoTipo(int eventoTipoId) {
        try {
            List<HistorialMedico> historiales = historialService.obtenerPorEventoTipo(eventoTipoId);
            historiales.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener historiales médicos con evento tipo ID " + eventoTipoId + ": " + e.getMessage());
        }
    }
}
