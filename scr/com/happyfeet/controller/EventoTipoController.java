package com.happyfeet.controller;

import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.service.impl.EventoTipoServiceImpl;
import com.happyfeet.service.interfaces.IEventoTipoService;

import java.util.List;

public class EventoTipoController {

    private final IEventoTipoService service = new EventoTipoServiceImpl();

    public String agregarEventoTipo(EventoTipo eventoTipo) {
        try {
            service.agregarEventoTipo(eventoTipo);
            return "✅ Tipo de evento registrado con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar tipo de evento: " + e.getMessage();
        }
    }

    public List<EventoTipo> obtenerTodosEventoTipos() {
        try {
            return service.obtenerTodosEventoTipos();
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return List.of();
        }
    }

    public EventoTipo obtenerEventoTipoPorId(int id) {
        try {
            return service.obtenerEventoTipoPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return null;
        }
    }

    public String actualizarEventoTipo(EventoTipo eventoTipo) {
        try {
            service.actualizarEventoTipo(eventoTipo);
            return "✅ Tipo de evento actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar tipo de evento: " + e.getMessage();
        }
    }

    public String eliminarEventoTipo(int id) {
        try {
            service.eliminarEventoTipo(id);
            return "✅ Tipo de evento eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar tipo de evento: " + e.getMessage();
        }
    }

    public EventoTipo obtenerPorNombre(String nombre) {
        try {
            return service.obtenerPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
            return null;
        }
    }
}
