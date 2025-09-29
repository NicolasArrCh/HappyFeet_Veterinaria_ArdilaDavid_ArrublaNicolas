package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.enums.TipoActividad;

import java.util.Date;
import java.util.List;

public interface IActividadEspecialService {
    void agregarActividadEspecial(ActividadEspecial actividadespecial) throws Exception;
    List<ActividadEspecial> obtenerTodasActividadEspecial() throws Exception;
    ActividadEspecial obtenerActividadEspecialPorId(Integer id) throws Exception;
    void actualizarActividadEspecial(ActividadEspecial actividadEspecial) throws Exception;
    void eliminarActividadEspecial(Integer id) throws Exception;

    // Extras utiles para busquedas::
    List<ActividadEspecial> obtenerPorTipo(TipoActividad tipo) throws Exception;
    List<ActividadEspecial> obtenerPorFecha(Date fecha) throws Exception;
}
