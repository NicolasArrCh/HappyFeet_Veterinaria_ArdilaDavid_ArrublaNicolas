package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.EventoTipo;
import java.util.List;

public interface IEventoTipoService {
    void agregarEventoTipo(EventoTipo eventoTipo) throws Exception;
    List<EventoTipo> obtenerTodosEventoTipos() throws Exception;
    EventoTipo obtenerEventoTipoPorId(int id) throws Exception;
    void actualizarEventoTipo(EventoTipo eventoTipo) throws Exception;
    void eliminarEventoTipo(int id) throws Exception;

    // Extra útil: buscar por nombre
    EventoTipo obtenerPorNombre(String nombre) throws Exception;
}
