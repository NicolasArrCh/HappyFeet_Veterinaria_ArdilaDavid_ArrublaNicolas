package com.happyfeet.model.entities;

import java.util.List;

public interface IEventoTipoDAO {
    void agregarEventoTipo(EventoTipo eventoTipo);
    List<EventoTipo> obtenerTodosEventoTipos();
    EventoTipo obtenerEventoTipoPorId(Integer id);
    void actualizarEventoTipo(EventoTipo eventoTipo);
    void eliminarEventoTipo(Integer id);
}
