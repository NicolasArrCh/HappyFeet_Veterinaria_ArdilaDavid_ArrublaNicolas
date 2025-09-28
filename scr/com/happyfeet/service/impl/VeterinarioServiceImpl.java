package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Veterinario;
import com.happyfeet.repository.DAO.VeterinarioDAO;
import com.happyfeet.repository.inter.IVeterinarioDAO;
import com.happyfeet.service.interfaces.IVeterinarioService;

import java.util.List;

public class VeterinarioServiceImpl implements IVeterinarioService {

    private final IVeterinarioDAO veterinarioDAO;

    public VeterinarioServiceImpl() {
        this.veterinarioDAO = new VeterinarioDAO();
    }

    @Override
    public void registrarVeterinario(Veterinario veterinario) throws Exception {
        if (veterinario.getNombreCompleto() == null || veterinario.getNombreCompleto().isEmpty()) {
            throw new Exception("El nombre del veterinario es obligatorio");
        }
        if (veterinario.getDocumentoIdentidad() == null || veterinario.getDocumentoIdentidad().isEmpty()) {
            throw new Exception("El documento de identidad es obligatorio");
        }
        if (veterinario.getEspecialidad() == null || veterinario.getEspecialidad().isEmpty()) {
            throw new Exception("La especialidad es obligatoria");
        }
        veterinarioDAO.agregarVeterinario(veterinario);
    }

    @Override
    public List<Veterinario> listarVeterinarios() throws Exception {
        return veterinarioDAO.obtenerTodasVeterinario();
    }

    @Override
    public Veterinario buscarVeterinarioPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("ID inválido para buscar veterinario");
        }
        Veterinario vt = veterinarioDAO.obtenerVeterinarioPorId(id);
        if (vt == null) {
            throw new Exception("No se encontró un veterinario con ID: " + id);
        }
        return vt;
    }

    @Override
    public void actualizarVeterinario(Veterinario veterinario) throws Exception {
        if ( veterinario.getId() <= 0) {
            throw new Exception("El ID del veterinario no es válido para actualizar");
        }
        veterinarioDAO.actualizarVeterinario(veterinario);
    }

    @Override
    public void eliminarVeterinario(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID no es válido para eliminar");
        }
        veterinarioDAO.eliminarVeterinario(id);
    }
}
