package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.repository.DAO.CitaDAO;
import com.happyfeet.repository.DAO.CitaEstadoDAO;
import com.happyfeet.repository.DAO.MascotaDAO;
import com.happyfeet.repository.inter.ICitaDAO;
import com.happyfeet.service.interfaces.ICitaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CitaServiceImpl implements ICitaService {

    private ICitaDAO citaDAO = new CitaDAO();

    @Override
    public void agregarCita(Cita cita) throws Exception {
        if (cita.getMascota() == null) {
            throw new Exception("La cita debe estar asociada a una mascota");
        }
        if (cita.getFechaHora() == null || cita.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new Exception("La fecha y hora de la cita deben ser futuras");
        }
        if (cita.getMotivo() == null || cita.getMotivo().trim().isEmpty()) {
            throw new Exception("El motivo de la cita es obligatorio");
        }
        if (cita.getEstado() == null) {
            throw new Exception("El estado de la cita es obligatorio");
        }
        MascotaDAO mascotaDAO = new MascotaDAO();
        CitaEstadoDAO citaEstadoDAO = new CitaEstadoDAO();

        if (cita.getMascota().getId() == 0) {
            mascotaDAO.agregarMascota(cita.getMascota());
        } else {
            if (mascotaDAO.obtenerMascotaPorId(cita.getMascota().getId()) == null) {
                throw new Exception("La mascota con ID " + cita.getMascota().getId() + " no existe en la BD");
            }
        }

        if (cita.getEstado().getId() == 0) {
            citaEstadoDAO.agregarCitaEstado(cita.getEstado());
        } else {
            if (citaEstadoDAO.obtenerCitaEstadoPorId(cita.getEstado().getId()) == null) {
                throw new Exception("La cita con ID " + cita.getEstado().getId() + " no existe en la BD");
            }
        }
        citaDAO.agregarCita(cita);
    }

    @Override
    public List<Cita> obtenerTodasCitas() throws Exception {
        return citaDAO.obtenerTodasCitas();
    }

    @Override
    public Cita obtenerCitaPorId(int id) throws Exception {
        Cita cita = citaDAO.obtenerCitaPorId(id);
        if (cita == null) {
            throw new Exception("No existe una cita con ID: " + id);
        }
        return cita;
    }

    @Override
    public void actualizarCita(Cita cita) throws Exception {
        if (cita.getId() <= 0) {
            throw new Exception("El ID de la cita no es válido");
        }
        citaDAO.actualizarCita(cita);
    }

    @Override
    public void eliminarCita(int id) throws Exception {
        Cita cita = citaDAO.obtenerCitaPorId(id);
        if (cita == null) {
            throw new Exception("No se puede cancelar: cita inexistente");
        }
        cita.setEstado(new CitaEstado(3, "CANCELADA")); // ejemplo: estado CANCELADA
        citaDAO.actualizarCita(cita);
    }

    @Override
    public List<Cita> obtenerPorMascota(int mascotaId) throws Exception {
        return citaDAO.obtenerTodasCitas().stream()
                .filter(c -> c.getMascota() != null && c.getMascota().getId() == mascotaId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cita> obtenerPorFecha(LocalDateTime fecha) throws Exception {
        if (fecha == null) {
            throw new Exception("La fecha no puede ser nula");
        }
        return citaDAO.obtenerTodasCitas().stream()
                .filter(c -> fecha.equals(c.getFechaHora()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Cita> obtenerPorEstado(CitaEstado estado) throws Exception {
        if (estado == null) {
            throw new Exception("El estado no puede ser nulo");
        }
        return citaDAO.obtenerTodasCitas().stream()
                .filter(c -> estado.equals(c.getEstado()))
                .collect(Collectors.toList());
    }
}
