package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Especie;
import com.happyfeet.repository.DAO.EspeciesDAO;
import com.happyfeet.repository.DAO.EspeciesDAO;
import com.happyfeet.repository.inter.IEspecieDAO;
import com.happyfeet.service.interfaces.IEspecieService;

import java.util.List;
import java.util.stream.Collectors;

public class EspecieServiceImpl implements IEspecieService {

    private IEspecieDAO especiesDAO = new EspeciesDAO();

    @Override
    public void agregarEspecie(Especie especie) throws Exception {
        if (especie.getNombre() == null || especie.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre de la especie es obligatorio");
        }
        especiesDAO.agregarEspecie(especie);
    }

    @Override
    public List<Especie> obtenerTodasEspecies() throws Exception {
        return especiesDAO.obtenerTodasEspecies();
    }

    @Override
    public Especie obtenerEspeciePorId(int id) throws Exception {
        Especie especie = especiesDAO.obtenerEspeciePorId(id);
        if (especie == null) {
            throw new Exception("No existe una especie con ID: " + id);
        }
        return especie;
    }

    @Override
    public void actualizarEspecie(Especie especie) throws Exception {
        if (especie.getId() <= 0) {
            throw new Exception("El ID de la especie no es válido");
        }
        if (especie.getNombre() == null || especie.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre de la especie es obligatorio");
        }
        especiesDAO.actualizarEspecie(especie);
    }

    @Override
    public void eliminarEspecie(int id) throws Exception {
        Especie especie = especiesDAO.obtenerEspeciePorId(id);
        if (especie == null) {
            throw new Exception("No se puede eliminar: especie inexistente");
        }
        especiesDAO.eliminarEspecie(id);
    }

    @Override
    public Especie obtenerPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("El nombre no puede ser nulo o vacío");
        }
        List<Especie> lista = especiesDAO.obtenerTodasEspecies();
        return lista.stream()
                .filter(e -> e.getNombre() != null &&
                        e.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElseThrow(() -> new Exception("No existe una especie con nombre: " + nombre));
    }
}
