package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Raza;

import java.util.List;

public interface IRazaDAO {
    void agregarRaza(Raza raza);
    List<Raza> obtenerTodasRazas();
    Raza obtenerRazaPorId(Integer id);
    void actualizarRaza(Raza raza);
    void eliminarRaza(Integer id);
}
