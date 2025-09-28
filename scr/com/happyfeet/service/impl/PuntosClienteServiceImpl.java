package com.happyfeet.service.impl;

import com.happyfeet.model.entities.PuntosCliente;
import com.happyfeet.repository.DAO.PuntosClienteDAO;
import com.happyfeet.repository.inter.IPuntosClienteDAO;
import com.happyfeet.service.interfaces.IPuntosClienteService;

import java.util.List;

public class PuntosClienteServiceImpl implements IPuntosClienteService {

    private final IPuntosClienteDAO puntosClienteDAO = new PuntosClienteDAO();

    @Override
    public void agregarPuntosCliente(PuntosCliente puntosCliente) throws Exception {
        if (puntosCliente.getPuntos() < 0) {
            throw new Exception("No se pueden asignar puntos negativos.");
        }
        if (puntosCliente.getDueno() == null || puntosCliente.getDueno().getId() <= 0) {
            throw new Exception("El cliente debe tener un dueño válido.");
        }
        puntosClienteDAO.agregarPuntosCliente(puntosCliente);
    }

    @Override
    public List<PuntosCliente> obtenerTodasPuntosCliente() throws Exception {
        return puntosClienteDAO.obtenerTodasPuntosCliente();
    }

    @Override
    public PuntosCliente obtenerPuntosClientePorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de puntos cliente no es válido.");
        }
        return puntosClienteDAO.obtenerProveedorPorId(id);
    }

    @Override
    public void actualizarPuntosCliente(PuntosCliente puntosCliente) throws Exception {
        if (puntosCliente.getId() <= 0) {
            throw new Exception("El ID de puntos cliente no es válido para actualización.");
        }
        if (puntosCliente.getPuntos() < 0) {
            throw new Exception("Los puntos no pueden ser negativos.");
        }
        puntosClienteDAO.actualizarPuntosCliente(puntosCliente);
    }

    @Override
    public void eliminarPuntosCliente(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID no es válido para eliminación.");
        }
        puntosClienteDAO.eliminarPuntosCliente(id);
    }

    @Override
    public void sumarPuntos(Integer idCliente, int puntosASumar) throws Exception {
        if (puntosASumar <= 0) {
            throw new Exception("Debes sumar un valor positivo de puntos.");
        }
        PuntosCliente pc = obtenerPuntosClientePorId(idCliente);
        if (pc == null) {
            throw new Exception("No se encontró el cliente con ID: " + idCliente);
        }
        pc.setPuntos(pc.getPuntos() + puntosASumar);
        puntosClienteDAO.actualizarPuntosCliente(pc);
    }
}
