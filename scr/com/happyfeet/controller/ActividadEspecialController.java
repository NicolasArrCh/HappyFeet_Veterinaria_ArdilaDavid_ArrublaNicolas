package com.happyfeet.controller;

import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.enums.TipoActividad;
import com.happyfeet.service.impl.ActividadEspecialServiceImpl;

import java.util.Date;
import java.util.List;

public class ActividadEspecialController {

    private ActividadEspecialServiceImpl actividadEspecialService;

    public ActividadEspecialController() {
        this.actividadEspecialService = new ActividadEspecialServiceImpl();
    }

    // Crear nueva actividad especial
    public String agregarActividadEspecial(TipoActividad tipo, String descripcion, Date fecha) {
        try {
            ActividadEspecial actividadEspecial = new ActividadEspecial(
                    0, // El ID lo generará la BD
                    tipo,
                    descripcion,
                    fecha
            );

            actividadEspecialService.agregarActividadEspecial(actividadEspecial);
            return "✅ Actividad especial registrada con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar actividad especial: " + e.getMessage();
        }
    }

    // Consultar todas las actividades especiales
    public List<ActividadEspecial> obtenerTodasActividadEspecial() {
        try {
            return actividadEspecialService.obtenerTodasActividadEspecial();
        } catch (Exception e) {
            System.out.println("❌ Error al listar actividades especiales: " + e.getMessage());
            return null;
        }
    }

    // Consultar actividad especial por ID
    public ActividadEspecial obtenerActividadEspecialPorId(int id) {
        try {
            return actividadEspecialService.obtenerActividadEspecialPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar actividad especial
    public String actualizarActividadEspecial(int id, TipoActividad tipo, String descripcion, Date fecha) {
        try {
            ActividadEspecial actividadEspecial = new ActividadEspecial(
                    id,
                    tipo,
                    descripcion,
                    fecha
            );

            actividadEspecialService.actualizarActividadEspecial(actividadEspecial);
            return "✅ Actividad especial actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar actividad especial: " + e.getMessage();
        }
    }

    // Eliminar actividad especial
    public String eliminarActividadEspecial(int id) {
        try {
            actividadEspecialService.eliminarActividadEspecial(id);
            return "🗑️ Actividad especial eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar actividad especial: " + e.getMessage();
        }
    }

    // Consultar por tipo de actividad
    public List<ActividadEspecial> obtenerPorTipo(TipoActividad tipo) {
        try {
            return actividadEspecialService.obtenerPorTipo(tipo);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar por tipo: " + e.getMessage());
            return null;
        }
    }

    // Consultar por fecha exacta
    public List<ActividadEspecial> obtenerPorFecha(Date fecha) {
        try {
            return actividadEspecialService.obtenerPorFecha(fecha);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar por fecha: " + e.getMessage());
            return null;
        }
    }
}
