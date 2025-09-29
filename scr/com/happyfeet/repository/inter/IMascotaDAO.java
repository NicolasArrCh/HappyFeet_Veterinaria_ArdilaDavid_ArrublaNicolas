package com.happyfeet.repository.inter;
import com.happyfeet.model.entities.Mascota;

import java.util.List;

public interface IMascotaDAO {
    void agregarMascota(Mascota mascota);
    List<Mascota> obtenerTodasMascotas();
    Mascota obtenerMascotaPorId(Integer id);
    void actualizarMascota(Mascota mascota);
    void eliminarMascota(Integer id);
}
