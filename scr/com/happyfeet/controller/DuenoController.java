package com.happyfeet.controller;

import com.happyfeet.model.entities.Dueno;
import com.happyfeet.service.impl.DuenoServiceImpl;

import java.util.List;

public class DuenoController {

    private DuenoServiceImpl duenoService;

    public DuenoController() {
        this.duenoService = new DuenoServiceImpl();
    }

    // Registrar nuevo dueño
    public String agregarDueno(String nombreCompleto, String documento, String direccion,
                                 String telefono, String email) {
        try {
            Dueno dueno = new Dueno(0, nombreCompleto, documento, direccion, telefono, email);
            duenoService.agregarDueno(dueno);
            return "✅ Dueño registrado con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar dueño: " + e.getMessage();
        }
    }

    // Listar todos los dueños
    public List<Dueno> obtenerTodosDuenos() {
        try {
            return duenoService.obtenerTodosDuenos();
        } catch (Exception e) {
            System.out.println("❌ Error al listar dueños: " + e.getMessage());
            return null;
        }
    }

    // Buscar dueño por ID
    public Dueno obtenerDuenoPorId(int id) {
        try {
            return duenoService.obtenerDuenoPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar dueño
    public String actualizarDueno(int id, String nombreCompleto, String documento, String direccion,
                                  String telefono, String email) {
        try {
            Dueno dueno = new Dueno(id, nombreCompleto, documento, direccion, telefono, email);
            duenoService.actualizarDueno(dueno);
            return "✅ Dueño actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar dueño: " + e.getMessage();
        }
    }

    // Eliminar dueño
    public String eliminarDueno(int id) {
        try {
            duenoService.eliminarDueno(id);
            return "🗑️ Dueño eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar dueño: " + e.getMessage();
        }
    }

    // Buscar dueño por documento
    public Dueno obtenerPorDocumento(String documento) {
        try {
            return duenoService.obtenerPorDocumento(documento);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Buscar dueños por nombre (coincidencia parcial)
    public List<Dueno> obtenerPorNombre(String nombre) {
        try {
            return duenoService.obtenerPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }
}
