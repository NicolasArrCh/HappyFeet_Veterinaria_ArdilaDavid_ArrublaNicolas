package com.happyfeet.model.entities;

import java.util.List;

public interface IPuntosClienteDAO {
    void agregarPuntosCliente(PuntosCliente puntosCliente);
    List<PuntosCliente> obtenerTodasPuntosCliente();
    PuntosCliente obtenerProveedorPorId(Integer id);
    void actualizarPuntosCliente(PuntosCliente puntosCliente);
    void eliminarPuntosCliente(Integer id);
}
