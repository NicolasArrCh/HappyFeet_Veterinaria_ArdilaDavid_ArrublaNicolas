package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.PuntosCliente;
import java.util.List;

public interface IPuntosClienteService {

    void agregarPuntosCliente(PuntosCliente puntosCliente) throws Exception;

    List<PuntosCliente> obtenerTodasPuntosCliente() throws Exception;

    PuntosCliente obtenerPuntosClientePorId(Integer id) throws Exception;

    void actualizarPuntosCliente(PuntosCliente puntosCliente) throws Exception;

    void eliminarPuntosCliente(Integer id) throws Exception;

    // Método extra: sumar puntos (regla común en fidelización)
    void sumarPuntos(Integer idCliente, int puntosASumar) throws Exception;
}
