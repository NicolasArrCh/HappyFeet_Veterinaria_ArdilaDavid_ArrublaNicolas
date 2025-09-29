package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.PuntosCliente;

import java.util.List;

public interface IPuntosClienteDAO {
    void agregarPuntosCliente(PuntosCliente puntosCliente);
    List<PuntosCliente> obtenerTodasPuntosCliente();
    PuntosCliente obtenerProveedorPorId(Integer id);
    void actualizarPuntosCliente(PuntosCliente puntosCliente);
    void eliminarPuntosCliente(Integer id);
}
