package com.happyfeet.controller;

import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.service.impl.EventoTipoServiceImpl;

import java.util.List;

public class EventoTipoController {

    private EventoTipoServiceImpl eventoTipoService;

    public EventoTipoController() {
        this.eventoTipoService = new EventoTipoServiceImpl();
    }

    // Crear nuevo tipo de evento
    public String agregarEventoTipo(String nombre) {
        try {
            EventoTipo eventoTipo = new EventoTipo(0, nombre);
            eventoTipoService.agregarEventoTipo(eventoTipo);
            return "✅ Tipo de evento registrado con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar tipo de evento: " + e.getMessage();
        }
    }

    // Consultar todos los tipos de evento
    public List<EventoTipo> obtenerTodosEventoTipos() {
        try {
            return eventoTipoService.obtenerTodosEventoTipos();
        } catch (Exception e) {
            System.out.println("❌ Error al listar tipos de evento: " + e.getMessage());
            return null;
        }
    }

    // Consultar por ID
    public EventoTipo obtenerEventoTipoPorId(int id) {
        try {
            return eventoTipoService.obtenerEventoTipoPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Consultar por nombre
    public EventoTipo obtenerPorNombre(String nombre) {
        try {
            return eventoTipoService.obtenerPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar tipo de evento
    public String actualizarEventoTipo(int id, String nombre) {
        try {
            EventoTipo eventoTipo = new EventoTipo(id, nombre);
            eventoTipoService.actualizarEventoTipo(eventoTipo);
            return "✅ Tipo de evento actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar tipo de evento: " + e.getMessage();
        }
    }

    // Eliminar tipo de evento
    public String eliminarEventoTipo(int id) {
        try {
            eventoTipoService.eliminarEventoTipo(id);
            return "🗑️ Tipo de evento eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar tipo de evento: " + e.getMessage();
        }
    }
}