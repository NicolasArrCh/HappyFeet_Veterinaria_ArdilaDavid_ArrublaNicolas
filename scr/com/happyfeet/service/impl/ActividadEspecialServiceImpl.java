package com.happyfeet.service.impl;

import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.enums.TipoActividad;
import com.happyfeet.repository.DAO.ActividadEspecialDAO;
import com.happyfeet.repository.inter.IActividadEspecialDAO;
import com.happyfeet.service.interfaces.IActividadEspecialService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ActividadEspecialServiceImpl implements IActividadEspecialService {

    private IActividadEspecialDAO actividadEspecialDAO = new ActividadEspecialDAO();

    @Override
    public void agregarActividadEspecial(ActividadEspecial actividadEspecial) throws Exception {
        if (actividadEspecial.getTipo() == null) {
            throw new Exception("El tipo de actividad es obligatorio");
        }
        if (actividadEspecial.getDescripcion() == null || actividadEspecial.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripcion es obligatoria");
        }
        if (actividadEspecial.getFecha() == null) {
            throw new Exception("La fecha es obligatoria");
        }
        if (actividadEspecial.getFecha().before(new Date())) {
            throw new Exception("La fecha no puede ser anterior a la actual");
        }
        actividadEspecialDAO.agregarActividadEspecial(actividadEspecial);
    }

    @Override
    public List<ActividadEspecial> obtenerTodasActividadEspecial() throws Exception {
        return actividadEspecialDAO.obtenerTodasActividadEspecial();
    }

    @Override
    public ActividadEspecial obtenerActividadEspecialPorId(Integer id) throws Exception {
        ActividadEspecial ae = actividadEspecialDAO.obtenerActividadEspecialPorId(id);
        if (ae == null) {
            throw new Exception("No existe una actividad especial con ID: " + id);
        }
        return ae;
    }

    @Override
    public void actualizarActividadEspecial(ActividadEspecial actividadEspecial) throws Exception {
        if (actividadEspecial.getId() <= 0) {
            throw new Exception("El ID de actividad especial no es válido");
        }
        actividadEspecialDAO.actualizarActividadEspecial(actividadEspecial);
    }

    @Override
    public void eliminarActividadEspecial(Integer id) throws Exception {
        ActividadEspecial ae = actividadEspecialDAO.obtenerActividadEspecialPorId(id);
        if (ae == null) {
            throw new Exception("No se puede eliminar: producto inexistente");
        }
        actividadEspecialDAO.eliminarActividadEspecial(id);
    }

    // 🔥 Regla de negocio: descontar stock
    @Override
    public List<ActividadEspecial> obtenerPorTipo(TipoActividad tipo) throws Exception {
        if (tipo == null) {
            throw new Exception("El tipo no puede ser nulo");
        }
        List<ActividadEspecial> lista = actividadEspecialDAO.obtenerTodasActividadEspecial();
        return lista.stream()
                .filter(ae -> ae.getTipo() == tipo)
                .collect(Collectors.toList());
    }

    // 🔥 Validar stock suficiente
    @Override
    public List<ActividadEspecial> obtenerPorFecha(Date fecha) throws Exception {
        if (fecha == null) {
            throw new Exception("La fecha no puede ser nula");
        }
        List<ActividadEspecial> lista =actividadEspecialDAO.obtenerTodasActividadEspecial();
        return lista.stream()
                .filter(ae -> ae.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}
