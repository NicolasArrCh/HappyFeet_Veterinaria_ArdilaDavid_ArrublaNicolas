package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Dueno;
import java.util.List;

public interface IDuenoService {
    void agregarDueno(Dueno dueno) throws Exception;
    List<Dueno> obtenerTodosDuenos() throws Exception;
    Dueno obtenerDuenoPorId(int id) throws Exception;
    void actualizarDueno(Dueno dueno) throws Exception;
    void eliminarDueno(int id) throws Exception;

    // Extras útiles
    Dueno obtenerPorDocumento(String documentoIdentidad) throws Exception;
    List<Dueno> obtenerPorNombre(String nombre) throws Exception;
}
