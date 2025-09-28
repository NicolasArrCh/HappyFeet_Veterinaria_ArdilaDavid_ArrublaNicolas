package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Raza;
import java.util.List;

public interface IRazaService {
    void registrarRaza(Raza raza) throws Exception;
    List<Raza> listarRazas() throws Exception;
    Raza buscarRazaPorId(Integer id) throws Exception;
    void actualizarRaza(Raza raza) throws Exception;
    void eliminarRaza(Integer id) throws Exception;
}
