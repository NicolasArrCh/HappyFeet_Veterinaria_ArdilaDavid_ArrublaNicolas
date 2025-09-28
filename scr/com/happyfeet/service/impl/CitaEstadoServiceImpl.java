package com.happyfeet.service.impl;

import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.repository.DAO.CitaEstadoDAO;
import com.happyfeet.repository.inter.ICitaEstadoDAO;
import com.happyfeet.service.interfaces.ICitaEstadoService;

import java.util.List;
import java.util.stream.Collectors;

public class CitaEstadoServiceImpl implements ICitaEstadoService {

    private ICitaEstadoDAO citaEstadoDAO = new CitaEstadoDAO();

    @Override
    public void agregarCitaEstado(CitaEstado citaEstado) throws Exception {
        if (citaEstado.getNombre() == null || citaEstado.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del estado es obligatorio");
        }
        citaEstadoDAO.agregarCitaEstado(citaEstado);
    }

    @Override
    public List<CitaEstado> obtenerTodasCitaEstados() throws Exception {
        return citaEstadoDAO.obtenerTodasCitaEstados();
    }

    @Override
    public CitaEstado obtenerCitaEstadoPorId(int id) throws Exception {
        CitaEstado estado = citaEstadoDAO.obtenerCitaEstadoPorId(id);
        if (estado == null) {
            throw new Exception("No existe un estado con ID: " + id);
        }
        return estado;
    }

    @Override
    public void actualizarCitaEstado(CitaEstado citaEstado) throws Exception {
        if (citaEstado.getId() <= 0) {
            throw new Exception("El ID del estado no es válido");
        }
        if (citaEstado.getNombre() == null || citaEstado.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del estado es obligatorio");
        }
        citaEstadoDAO.actualizarCitaEstado(citaEstado);
    }

    @Override
    public void eliminarCitaEstado(int id) throws Exception {
        CitaEstado estado = citaEstadoDAO.obtenerCitaEstadoPorId(id);
        if (estado == null) {
            throw new Exception("No se puede eliminar: estado inexistente");
        }
        citaEstadoDAO.eliminarCitaEstado(id);
    }

    @Override
    public CitaEstado obtenerPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }
        List<CitaEstado> lista = citaEstadoDAO.obtenerTodasCitaEstados();
        return lista.stream()
                .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe un estado con nombre: " + nombre));
    }
}
