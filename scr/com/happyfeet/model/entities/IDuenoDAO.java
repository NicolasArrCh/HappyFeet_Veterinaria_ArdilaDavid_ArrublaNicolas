package com.happyfeet.model.entities;

import java.util.List;

public interface IDuenoDAO {
    void agregarDueno(Dueno dueno);
    List<Dueno> obtenerTodosDuenos();
    Dueno obtenerDuenoPorId(Integer id);
    void actualizarDueno(Dueno dueno);
    void eliminarDueno(Integer id);
}
