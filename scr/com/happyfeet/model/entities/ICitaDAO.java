package com.happyfeet.model.entities;

import java.util.List;

public interface ICitaDAO {
    void agregarCita(Cita cita);
    List<Cita> obtenerTodasCitas();
    Cita obtenerCitaPorId(Integer id);
    void actualizarCita(Cita cita);
    void eliminarCita(Integer id);
}
