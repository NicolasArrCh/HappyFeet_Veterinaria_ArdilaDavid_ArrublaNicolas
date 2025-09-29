package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.ItemFactura;
import java.util.List;

public interface IItemFacturaService {
    void agregarItemFactura(ItemFactura itemFactura) throws Exception;
    List<ItemFactura> obtenerTodosItemFacturas() throws Exception;
    ItemFactura obtenerItemFacturaPorId(Integer id) throws Exception;
    void actualizarItemFactura(ItemFactura itemFactura) throws Exception;
    void eliminarItemFactura(Integer id) throws Exception;
}
