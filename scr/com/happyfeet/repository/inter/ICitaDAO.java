package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Cita;

import java.util.List;

public interface ICitaDAO {
    void agregarCita(Cita cita);
    List<Cita> obtenerTodasCitas();
    Cita obtenerCitaPorId(Integer id);
    void actualizarCita(Cita cita);
    void eliminarCita(Integer id);
}
