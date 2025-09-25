package com.happyfeet.model.entities;

import java.util.List;

public interface ICitaEstadoDAO {
    void agregarCitaEstado(CitaEstado citaEstado);
    List<CitaEstado> obtenerTodasCitaEstados();
    CitaEstado obtenerCitaEstadoPorId(Integer id);
    void actualizarCitaEstado(CitaEstado citaEstado);
}
