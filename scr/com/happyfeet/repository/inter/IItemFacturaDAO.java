package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.ItemFactura;

import java.util.List;

public interface IItemFacturaDAO {
    void agregarItemFactura(ItemFactura itemFactura);
    List<ItemFactura> obtenerTodosItemFacturas();
    ItemFactura obtenerItemFacturaPorId(Integer id);
    void actualizarItemFactura(ItemFactura itemFactura);
    void eliminarItemFactura(Integer id);
}
