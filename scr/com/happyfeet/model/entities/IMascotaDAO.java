package com.happyfeet.model.entities;
import java.util.List;

public interface IMascotaDAO {
    void agregarMascota(Mascota mascota);
    List<Mascota> obtenerTodasMascotas();
    Mascota obtenerMascotaPorId(Integer id);
    void actualizarMascota(Mascota mascota);
    void eliminarMascota(Integer id);
}
