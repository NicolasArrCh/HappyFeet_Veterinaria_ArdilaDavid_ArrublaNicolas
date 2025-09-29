package com.happyfeet.controller;

import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.service.impl.CitaEstadoServiceImpl;

import java.util.List;

public class CitaEstadoController {

    private CitaEstadoServiceImpl citaEstadoService;

    public CitaEstadoController() {
        this.citaEstadoService = new CitaEstadoServiceImpl();
    }

    // Registrar un nuevo estado de cita
    public String agregarCitaEstado(String nombre) {
        try {
            CitaEstado estado = new CitaEstado(0, nombre);
            citaEstadoService.agregarCitaEstado(estado);
            return "✅ Estado registrado con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar estado: " + e.getMessage();
        }
    }

    // Listar todos los estados
    public List<CitaEstado> obtenerTodasCitaEstados() {
        try {
            return citaEstadoService.obtenerTodasCitaEstados();
        } catch (Exception e) {
            System.out.println("❌ Error al listar estados: " + e.getMessage());
            return null;
        }
    }

    // Buscar estado por ID
    public CitaEstado obtenerCitaEstadoPorId(int id) {
        try {
            return citaEstadoService.obtenerCitaEstadoPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar estado
    public String actualizarCitaEstado(int id, String nombre) {
        try {
            CitaEstado estado = new CitaEstado(id, nombre);
            citaEstadoService.actualizarCitaEstado(estado);
            return "✅ Estado actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar estado: " + e.getMessage();
        }
    }

    // Eliminar estado
    public String eliminarCitaEstado(int id) {
        try {
            citaEstadoService.eliminarCitaEstado(id);
            return "🗑️ Estado eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar estado: " + e.getMessage();
        }
    }

    // Buscar estado por nombre
    public CitaEstado obtenerPorNombre(String nombre) {
        try {
            return citaEstadoService.obtenerPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }
}
