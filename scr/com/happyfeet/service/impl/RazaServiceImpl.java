package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Raza;
import com.happyfeet.repository.DAO.RazaDAO;
import com.happyfeet.service.interfaces.IRazaService;

import java.util.List;

public class RazaServiceImpl implements IRazaService {

    private final RazaDAO razaDAO;

    public RazaServiceImpl() {
        this.razaDAO = new RazaDAO();
    }

    @Override
    public void registrarRaza(Raza raza) throws Exception {
        if (raza == null) {
            throw new Exception("La raza no puede ser nula");
        }
        if (raza.getNombre() == null || raza.getNombre().isEmpty()) {
            throw new Exception("El nombre de la raza es obligatorio");
        }
        if (raza.getEspecie() == null || raza.getEspecie().getId() <= 0) {
            throw new Exception("La especie asociada es obligatoria");
        }
        razaDAO.agregarRaza(raza);
    }

    @Override
    public List<Raza> listarRazas() throws Exception {
        return razaDAO.obtenerTodasRazas();
    }

    @Override
    public Raza buscarRazaPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID debe ser válido");
        }
        return razaDAO.obtenerRazaPorId(id);
    }

    @Override
    public void actualizarRaza(Raza raza) throws Exception {
        if (raza == null || raza.getId() <= 0) {
            throw new Exception("La raza no es válida para actualización");
        }
        razaDAO.actualizarRaza(raza);
    }

    @Override
    public void eliminarRaza(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID debe ser válido");
        }
        razaDAO.eliminarRaza(id);
    }
}
