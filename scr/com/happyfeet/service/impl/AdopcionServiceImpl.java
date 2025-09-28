package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Adopcion;
import com.happyfeet.repository.DAO.AdopcionDAO;
import com.happyfeet.repository.inter.IAdopcionDAO;
import com.happyfeet.service.interfaces.IAdopcionService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AdopcionServiceImpl implements IAdopcionService {

    private IAdopcionDAO adopcionDAO = new AdopcionDAO();

    @Override
    public void agregarAdopcion(Adopcion adopcion) throws Exception {
        if (adopcion.getMascota() == null) {
            throw new Exception("La mascota es obligatoria para la adopción");
        }
        if (adopcion.getNuevoDueno() == null) {
            throw new Exception("El nuevo dueño es obligatorio para la adopción");
        }
        if (adopcion.getFecha() == null || adopcion.getFecha().isAfter(LocalDate.now())) {
            throw new Exception("La fecha de adopción no puede ser nula ni futura");
        }
        if (adopcion.getContrato() == null || adopcion.getContrato().trim().isEmpty()) {
            throw new Exception("El contrato de adopción es obligatorio");
        }
        adopcionDAO.agregarAdopcion(adopcion);
    }

    @Override
    public List<Adopcion> obtenerTodasAdopcion() throws Exception {
        return adopcionDAO.obtenerTodasAdopcion();
    }

    @Override
    public Adopcion obtenerAdopcionPorId(int id) throws Exception {
        Adopcion adopcion = adopcionDAO.obtenerAdopcionPorId(id);
        if (adopcion == null) {
            throw new Exception("No existe una adopción con ID: " + id);
        }
        return adopcion;
    }

    @Override
    public void actualizarAdopcion(Adopcion adopcion) throws Exception {
        if (adopcion.getId() <= 0) {
            throw new Exception("El ID de la adopción no es válido");
        }
        adopcionDAO.actualizarAdopcion(adopcion);
    }

    @Override
    public void eliminarAdopcion(int id) throws Exception {
        Adopcion adopcion = adopcionDAO.obtenerAdopcionPorId(id);
        if (adopcion == null) {
            throw new Exception("No se puede eliminar: adopción inexistente");
        }
        adopcionDAO.eliminarAdopcion(id);
    }

    @Override
    public List<Adopcion> obtenerPorDueno(int duenoId) throws Exception {
        List<Adopcion> lista = adopcionDAO.obtenerTodasAdopcion();
        return lista.stream()
                .filter(a -> a.getNuevoDueno() != null && a.getNuevoDueno().getId() == duenoId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Adopcion> obtenerPorMascota(int mascotaId) throws Exception {
        List<Adopcion> lista = adopcionDAO.obtenerTodasAdopcion();
        return lista.stream()
                .filter(a -> a.getMascota() != null && a.getMascota().getId() == mascotaId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Adopcion> obtenerPorFecha(LocalDate fecha) throws Exception {
        if (fecha == null) {
            throw new Exception("La fecha no puede ser nula");
        }
        List<Adopcion> lista = adopcionDAO.obtenerTodasAdopcion();
        return lista.stream()
                .filter(a -> fecha.equals(a.getFecha()))
                .collect(Collectors.toList());
    }
}
