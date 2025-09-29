package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.EventoTipo;

import java.util.List;

public interface IEventoTipoDAO {
    void agregarEventoTipo(EventoTipo eventoTipo);
    List<EventoTipo> obtenerTodosEventoTipos();
    EventoTipo obtenerEventoTipoPorId(Integer id);
    void actualizarEventoTipo(EventoTipo eventoTipo);
    void eliminarEventoTipo(Integer id);
}
