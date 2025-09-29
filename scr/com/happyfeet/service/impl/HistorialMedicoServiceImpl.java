package com.happyfeet.service.impl;

import com.happyfeet.model.entities.HistorialMedico;
import com.happyfeet.repository.DAO.EventoTipoDAO;
import com.happyfeet.repository.DAO.HistorialMedicoDAO;
import com.happyfeet.repository.DAO.MascotaDAO;
import com.happyfeet.repository.inter.IHistorialMedicoDAO;
import com.happyfeet.service.interfaces.IHistorialMedicoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class HistorialMedicoServiceImpl implements IHistorialMedicoService {

    private IHistorialMedicoDAO historialMedicoDAO = new HistorialMedicoDAO();

    @Override
    public void agregarHistorialMedico(HistorialMedico historial) throws Exception {
        if (historial.getMascota() == null || historial.getMascota().getId() <= 0) {
            throw new Exception("El historial debe estar asociado a una mascota válida");
        }
        if (historial.getFechaEvento() == null) {
            throw new Exception("La fecha del evento es obligatoria");
        }
        if (historial.getEventoTipo() == null || historial.getEventoTipo().getId() <= 0) {
            throw new Exception("El historial debe estar asociado a un tipo de evento válido");
        }
        if (historial.getDescripcion() == null || historial.getDescripcion().trim().isEmpty()) {
            throw new Exception("La descripción es obligatoria");
        }

        MascotaDAO mascotaDAO = new MascotaDAO();
        EventoTipoDAO eventoTipoDAO = new EventoTipoDAO();

        if (historial.getMascota().getId() == 0) {
            mascotaDAO.agregarMascota(historial.getMascota());
        } else {
            if (mascotaDAO.obtenerMascotaPorId(historial.getMascota().getId()) == null) {
                throw new Exception("La mascota con ID " + historial.getMascota().getId() + " no existe en la BD");
            }
        }

        if (historial.getEventoTipo().getId() == 0) {
            eventoTipoDAO.agregarEventoTipo(historial.getEventoTipo());
        } else {
            if (eventoTipoDAO.obtenerEventoTipoPorId(historial.getEventoTipo().getId()) == null) {
                throw new Exception("El tipo de evento con ID " + historial.getEventoTipo().getId() + " no existe en la BD");
            }
        }

        historialMedicoDAO.agregarHistorialMedico(historial);
    }

    @Override
    public List<HistorialMedico> obtenerTodosHistorialesMedicos() throws Exception {
        return historialMedicoDAO.obtenerTodosHistorialesMedicos();
    }

    @Override
    public HistorialMedico obtenerHistorialMedicoPorId(int id) throws Exception {
        HistorialMedico historialMedico = historialMedicoDAO.obtenerHistorialMedicoPorId(id);
        if (historialMedico == null) {
            throw new Exception("No existe un historial médico con ID: " + id);
        }
        return historialMedico;
    }

    @Override
    public void actualizarHistorialMedico(HistorialMedico historialMedico) throws Exception {
        if (historialMedico.getId() <= 0) {
            throw new Exception("El ID del historial médico no es válido");
        }
        historialMedicoDAO.actualizarHistorialMedico(historialMedico);
    }

    @Override
    public void eliminarHistorialMedico(int id) throws Exception {
        HistorialMedico historial = historialMedicoDAO.obtenerHistorialMedicoPorId(id);
        if (historial == null) {
            throw new Exception("No se puede eliminar: historial médico inexistente");
        }
        historialMedicoDAO.eliminarHistorialMedico(id);
    }

    @Override
    public List<HistorialMedico> obtenerPorMascota(int mascotaId) throws Exception {
        return historialMedicoDAO.obtenerTodosHistorialesMedicos().stream()
                .filter(h -> h.getMascota() != null && h.getMascota().getId() == mascotaId)
                .collect(Collectors.toList());
    }

    @Override
    public List<HistorialMedico> obtenerPorFecha(LocalDate fecha) throws Exception {
        return historialMedicoDAO.obtenerTodosHistorialesMedicos().stream()
                .filter(h -> h.getFechaEvento() != null && h.getFechaEvento().equals(fecha))
                .collect(Collectors.toList());
    }

    @Override
    public List<HistorialMedico> obtenerPorEventoTipo(int eventoTipoId) throws Exception {
        return historialMedicoDAO.obtenerTodosHistorialesMedicos().stream()
                .filter(h -> h.getEventoTipo() != null && h.getEventoTipo().getId() == eventoTipoId)
                .collect(Collectors.toList());
    }
}
