package com.happyfeet.model.entities;

import java.util.List;

public interface IEspecieDAO {
    void agregarEspecie(Especie especie);
    List<Especie> obtenerTodasEspecies();
    Especie obtenerEspeciePorId(Integer id);
    void actualizarEspecie(Especie especie);
    void eliminarEspecie(Integer id);
}
