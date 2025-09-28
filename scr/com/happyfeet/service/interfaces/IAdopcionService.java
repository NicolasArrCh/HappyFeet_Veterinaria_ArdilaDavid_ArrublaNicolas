package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Adopcion;
import java.time.LocalDate;
import java.util.List;

public interface IAdopcionService {
    void agregarAdopcion(Adopcion adopcion) throws Exception;
    List<Adopcion> obtenerTodasAdopcion() throws Exception;
    Adopcion obtenerAdopcionPorId(int id) throws Exception;
    void actualizarAdopcion(Adopcion adopcion) throws Exception;
    void eliminarAdopcion(int id) throws Exception;

    // Extras útiles:
    List<Adopcion> obtenerPorDueno(int duenoId) throws Exception;
    List<Adopcion> obtenerPorMascota(int mascotaId) throws Exception;
    List<Adopcion> obtenerPorFecha(LocalDate fecha) throws Exception;
}
