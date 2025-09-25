package com.happyfeet.model.entities;

import java.util.List;

public interface IRazaDAO {
    void agregarRaza(Raza raza);
    List<Raza> obtenerTodasRazas();
    Raza obtenerRazaPorId(Integer id);
    void actualizarRaza(Raza raza);
    void eliminarRaza(Integer id);
}
