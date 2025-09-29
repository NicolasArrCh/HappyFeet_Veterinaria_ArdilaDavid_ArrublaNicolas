package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.CitaEstado;

import java.util.List;

public interface ICitaEstadoDAO {
    void agregarCitaEstado(CitaEstado citaEstado);
    List<CitaEstado> obtenerTodasCitaEstados();
    CitaEstado obtenerCitaEstadoPorId(Integer id);
    void actualizarCitaEstado(CitaEstado citaEstado);
    void eliminarCitaEstado(Integer id);
}
