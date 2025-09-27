package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Adopcion;

import java.util.List;
public interface IAdopcionDAO {
    void agregarAdopcion(Adopcion adopcion);
    List<Adopcion> obtenerTodasAdopcion();
    Adopcion obtenerAdopcionPorId(Integer id);
    void actualizarAdopcion(Adopcion adopcion);
    void eliminarAdopcion(Integer id);
}
