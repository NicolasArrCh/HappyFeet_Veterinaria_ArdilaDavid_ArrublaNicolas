package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Dueno;

import java.util.List;

public interface IDuenoDAO {
    void agregarDueno(Dueno dueno);
    List<Dueno> obtenerTodosDuenos();
    Dueno obtenerDuenoPorId(Integer id);
    void actualizarDueno(Dueno dueno);
    void eliminarDueno(Integer id);
}
