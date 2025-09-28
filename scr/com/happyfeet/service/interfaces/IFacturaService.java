package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Factura;
import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaService {
    void agregarFactura(Factura factura) throws Exception;
    List<Factura> obtenerTodasFacturas() throws Exception;
    Factura obtenerFacturaPorId(int id) throws Exception;
    void actualizarFactura(Factura factura) throws Exception;
    void eliminarFactura(int id) throws Exception;

    // Extras útiles:
    List<Factura> obtenerPorDueno(int duenoId) throws Exception;
    List<Factura> obtenerPorFecha(LocalDateTime fecha) throws Exception;
}