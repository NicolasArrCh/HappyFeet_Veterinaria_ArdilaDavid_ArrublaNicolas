package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Especie;
import java.util.List;

public interface IEspecieService {
    void agregarEspecie(Especie especie) throws Exception;
    List<Especie> obtenerTodasEspecies() throws Exception;
    Especie obtenerEspeciePorId(int id) throws Exception;
    void actualizarEspecie(Especie especie) throws Exception;
    void eliminarEspecie(int id) throws Exception;

    // Extra útil
    Especie obtenerPorNombre(String nombre) throws Exception;
}
