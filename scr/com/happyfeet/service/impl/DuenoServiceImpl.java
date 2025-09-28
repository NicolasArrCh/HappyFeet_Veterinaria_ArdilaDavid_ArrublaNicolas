package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Dueno;
import com.happyfeet.repository.DAO.DuenoDAO;
import com.happyfeet.repository.inter.IDuenoDAO;
import com.happyfeet.service.interfaces.IDuenoService;

import java.util.List;
import java.util.stream.Collectors;

public class DuenoServiceImpl implements IDuenoService {

    private IDuenoDAO duenoDAO = new DuenoDAO();

    @Override
    public void agregarDueno(Dueno dueno) throws Exception {
        if (dueno.getNombreCompleto() == null || dueno.getNombreCompleto().trim().isEmpty()) {
            throw new Exception("El nombre completo es obligatorio");
        }
        if (dueno.getDocumentoIdentidad() == null || dueno.getDocumentoIdentidad().trim().isEmpty()) {
            throw new Exception("El documento de identidad es obligatorio");
        }
        if (dueno.getTelefono() == null || dueno.getTelefono().trim().isEmpty()) {
            throw new Exception("El teléfono es obligatorio");
        }
        if (dueno.getEmail() == null || !dueno.getEmail().contains("@")) {
            throw new Exception("El email no es válido");
        }
        duenoDAO.agregarDueno(dueno);
    }

    @Override
    public List<Dueno> obtenerTodosDuenos() throws Exception {
        return duenoDAO.obtenerTodosDuenos();
    }

    @Override
    public Dueno obtenerDuenoPorId(int id) throws Exception {
        Dueno dueno = duenoDAO.obtenerDuenoPorId(id);
        if (dueno == null) {
            throw new Exception("No existe un dueño con ID: " + id);
        }
        return dueno;
    }

    @Override
    public void actualizarDueno(Dueno dueno) throws Exception {
        if (dueno.getId() <= 0) {
            throw new Exception("El ID del dueño no es válido");
        }
        duenoDAO.actualizarDueno(dueno);
    }

    @Override
    public void eliminarDueno(int id) throws Exception {
        Dueno dueno = duenoDAO.obtenerDuenoPorId(id);
        if (dueno == null) {
            throw new Exception("No se puede eliminar: dueño inexistente");
        }
        duenoDAO.eliminarDueno(id);
    }

    @Override
    public Dueno obtenerPorDocumento(String documentoIdentidad) throws Exception {
        if (documentoIdentidad == null || documentoIdentidad.trim().isEmpty()) {
            throw new Exception("El documento de identidad no puede ser nulo o vacío");
        }
        List<Dueno> lista = duenoDAO.obtenerTodosDuenos();
        return lista.stream()
                .filter(d -> documentoIdentidad.equalsIgnoreCase(d.getDocumentoIdentidad()))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe un dueño con documento: " + documentoIdentidad));
    }

    @Override
    public List<Dueno> obtenerPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }
        List<Dueno> lista = duenoDAO.obtenerTodosDuenos();
        return lista.stream()
                .filter(d -> d.getNombreCompleto() != null &&
                        d.getNombreCompleto().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
}
