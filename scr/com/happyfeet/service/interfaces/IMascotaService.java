package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Mascota;
import java.util.List;

public interface IMascotaService {
    void registrarMascota(Mascota mascota) throws Exception;
    List<Mascota> listarMascotas() throws Exception;
    Mascota buscarMascotaPorId(Integer id) throws Exception;
    void actualizarMascota(Mascota mascota) throws Exception;
    void eliminarMascota(Integer id) throws Exception;
}
