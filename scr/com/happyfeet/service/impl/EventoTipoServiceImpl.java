package com.happyfeet.service.impl;

import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.repository.DAO.EventoTipoDAO;
import com.happyfeet.repository.inter.IEventoTipoDAO;
import com.happyfeet.service.interfaces.IEventoTipoService;

import java.util.List;

public class EventoTipoServiceImpl implements IEventoTipoService {

    private IEventoTipoDAO eventoTipoDAO = new EventoTipoDAO();

    @Override
    public void agregarEventoTipo(EventoTipo eventoTipo) throws Exception {
        if (eventoTipo.getNombre() == null || eventoTipo.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del tipo de evento es obligatorio");
        }
        eventoTipoDAO.agregarEventoTipo(eventoTipo);
    }

    @Override
    public List<EventoTipo> obtenerTodosEventoTipos() throws Exception {
        return eventoTipoDAO.obtenerTodosEventoTipos();
    }

    @Override
    public EventoTipo obtenerEventoTipoPorId(int id) throws Exception {
        EventoTipo eventoTipo = eventoTipoDAO.obtenerEventoTipoPorId(id);
        if (eventoTipo == null) {
            throw new Exception("No existe un tipo de evento con ID: " + id);
        }
        return eventoTipo;
    }

    @Override
    public void actualizarEventoTipo(EventoTipo eventoTipo) throws Exception {
        if (eventoTipo.getId() <= 0) {
            throw new Exception("El ID del tipo de evento no es válido");
        }
        if (eventoTipo.getNombre() == null || eventoTipo.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del tipo de evento es obligatorio");
        }
        eventoTipoDAO.actualizarEventoTipo(eventoTipo);
    }

    @Override
    public void eliminarEventoTipo(int id) throws Exception {
        EventoTipo eventoTipo = eventoTipoDAO.obtenerEventoTipoPorId(id);
        if (eventoTipo == null) {
            throw new Exception("No se puede eliminar: tipo de evento inexistente");
        }
        eventoTipoDAO.eliminarEventoTipo(id);
    }

    @Override
    public EventoTipo obtenerPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }
        List<EventoTipo> lista = eventoTipoDAO.obtenerTodosEventoTipos();
        return lista.stream()
                .filter(e -> e.getNombre() != null &&
                        e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe un tipo de evento con nombre: " + nombre));
    }
}
