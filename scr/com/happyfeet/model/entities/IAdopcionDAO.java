package com.happyfeet.model.entities;

import java.util.List;
public interface IAdopcionDAO {
    void agregarAdopcion(Adopcion adopcion);
    List<Adopcion> obtenerTodasAdopcion();
    Adopcion obtenerAdopcionPorId(Integer id);
    void actualizarAdopcion(Adopcion adopcion);
    void eliminarAdopcion(Integer id);
}
