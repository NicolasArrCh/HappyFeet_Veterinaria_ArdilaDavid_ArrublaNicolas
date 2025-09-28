package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.CitaEstado;
import java.util.List;

public interface ICitaEstadoService {
    void agregarCitaEstado(CitaEstado estado) throws Exception;
    List<CitaEstado> obtenerTodasCitaEstados() throws Exception;
    CitaEstado obtenerCitaEstadoPorId(int id) throws Exception;
    void actualizarCitaEstado(CitaEstado estado) throws Exception;
    void eliminarCitaEstado(int id) throws Exception;

    // Extra útil
    CitaEstado obtenerPorNombre(String nombre) throws Exception;
}
