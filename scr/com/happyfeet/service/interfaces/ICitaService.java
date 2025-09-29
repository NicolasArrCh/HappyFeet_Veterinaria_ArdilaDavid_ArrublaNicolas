package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;

import java.time.LocalDateTime;
import java.util.List;

public interface ICitaService {
    void agregarCita(Cita cita) throws Exception;
    List<Cita> obtenerTodasCitas() throws Exception;
    Cita obtenerCitaPorId(int id) throws Exception;
    void actualizarCita(Cita cita) throws Exception;
    void eliminarCita(int id) throws Exception;

    // Métodos adicionales útiles
    List<Cita> obtenerPorMascota(int mascotaId) throws Exception;
    List<Cita> obtenerPorFecha(LocalDateTime fecha) throws Exception;
    List<Cita> obtenerPorEstado(CitaEstado estado) throws Exception;
}
