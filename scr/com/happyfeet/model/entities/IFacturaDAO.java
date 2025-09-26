package com.happyfeet.model.entities;

import java.util.List;

public interface IFacturaDAO {
    void agregarFactura(Factura factura);
    List<Factura> obtenerTodasFacturas();
    Factura obtenerFacturaPorId(Integer id);
    void actualizarFactura(Factura factura);
    void eliminarFactura(Integer id);    
}
