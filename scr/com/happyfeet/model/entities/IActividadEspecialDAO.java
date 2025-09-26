package com.happyfeet.model.entities;

import java.util.List;
public interface IActividadEspecialDAO {
    void agregarActividadEspecial(ActividadEspecial actividadespecial);
    List<ActividadEspecial> obtenerTodasActividadEspecial();
    ActividadEspecial obtenerActividadEspecialPorId(Integer id);
    void actualizarActividadEspecial(ActividadEspecial actividadespecial);
    void eliminarActividadEspecial(Integer id);
}
