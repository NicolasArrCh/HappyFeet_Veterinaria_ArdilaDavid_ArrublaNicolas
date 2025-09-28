package com.happyfeet.controller;

import com.happyfeet.model.entities.PuntosCliente;
import com.happyfeet.service.impl.PuntosClienteServiceImpl;
import com.happyfeet.service.interfaces.IPuntosClienteService;

import java.util.List;

public class PuntosClienteController {

    private final IPuntosClienteService puntosClienteService = new PuntosClienteServiceImpl();

    // Crear un nuevo registro de puntos
    public String agregarPuntosCliente(PuntosCliente puntosCliente) {
        try {
            puntosClienteService.agregarPuntosCliente(puntosCliente);
            return "✅ Puntos de cliente registrados correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar puntos de cliente: " + e.getMessage();
        }
    }

    // Listar todos los registros
    public List<PuntosCliente> obtenerTodasPuntosCliente() {
        try {
            return puntosClienteService.obtenerTodasPuntosCliente();
        } catch (Exception e) {
            System.out.println("❌ Error al listar puntos de clientes: " + e.getMessage());
            return null;
        }
    }

    // Obtener puntos de un cliente por ID
    public PuntosCliente obtenerPuntosClientePorId(Integer id) {
        try {
            return puntosClienteService.obtenerPuntosClientePorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener puntos de cliente con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar puntos de un cliente
    public String actualizarPuntosCliente(PuntosCliente puntosCliente) {
        try {
            puntosClienteService.actualizarPuntosCliente(puntosCliente);
            return "✅ Puntos de cliente actualizados correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar puntos de cliente: " + e.getMessage();
        }
    }

    // Eliminar un registro de puntos cliente
    public String eliminarPuntosCliente(Integer id) {
        try {
            puntosClienteService.eliminarPuntosCliente(id);
            return "🗑️ Puntos de cliente eliminados correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar puntos de cliente con ID " + id + ": " + e.getMessage();
        }
    }

    // Sumar puntos a un cliente
    public String sumarPuntos(Integer idCliente, int puntosASumar) {
        try {
            puntosClienteService.sumarPuntos(idCliente, puntosASumar);
            return "➕ Se sumaron " + puntosASumar + " puntos al cliente con ID " + idCliente;
        } catch (Exception e) {
            return "❌ Error al sumar puntos: " + e.getMessage();
        }
    }
}
