package com.happyfeet.service.impl;

import com.happyfeet.model.entities.ItemFactura;
import com.happyfeet.repository.DAO.ItemFacturaDAO;
import com.happyfeet.repository.inter.IItemFacturaDAO;
import com.happyfeet.service.interfaces.IItemFacturaService;

import java.util.List;

public class ItemFacturaServiceImpl implements IItemFacturaService {

    private IItemFacturaDAO itemFacturaDAO = new ItemFacturaDAO();

    @Override
    public void agregarItemFactura(ItemFactura itemFactura) throws Exception {
        if (itemFactura.getFactura() == null || itemFactura.getFactura().getId() <= 0) {
            throw new Exception("El item debe estar asociado a una factura válida");
        }
        if (itemFactura.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        if (itemFactura.getPrecioUnitario() <= 0) {
            throw new Exception("El precio unitario debe ser mayor a 0");
        }

        // Calculamos el subtotal si no está
        if (itemFactura.getSubtotal() <= 0) {
            itemFactura.setSubtotal(itemFactura.getCantidad() * itemFactura.getPrecioUnitario());
        }

        itemFacturaDAO.agregarItemFactura(itemFactura);
    }

    @Override
    public List<ItemFactura> obtenerTodosItemFacturas() throws Exception {
        return itemFacturaDAO.obtenerTodosItemFacturas();
    }

    @Override
    public ItemFactura obtenerItemFacturaPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("ID inválido");
        }
        return itemFacturaDAO.obtenerItemFacturaPorId(id);
    }

    @Override
    public void actualizarItemFactura(ItemFactura itemFactura) throws Exception {
        if (itemFactura.getId() <= 0) {
            throw new Exception("El ID del item no es válido");
        }
        if (itemFactura.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor a 0");
        }
        if (itemFactura.getPrecioUnitario() <= 0) {
            throw new Exception("El precio unitario debe ser mayor a 0");
        }

        // recalculamos subtotal
        itemFactura.setSubtotal(itemFactura.getCantidad() * itemFactura.getPrecioUnitario());

        itemFacturaDAO.actualizarItemFactura(itemFactura);
    }

    @Override
    public void eliminarItemFactura(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID no es válido para eliminar");
        }
        itemFacturaDAO.eliminarItemFactura(id);
    }
}
