package com.happyfeet.controller;

import com.happyfeet.model.entities.ItemFactura;
import com.happyfeet.service.impl.ItemFacturaServiceImpl;
import com.happyfeet.service.interfaces.IItemFacturaService;

import java.util.List;

public class ItemFacturaController {

    private IItemFacturaService itemFacturaService = new ItemFacturaServiceImpl();

    // Crear un nuevo item de factura
    public String agregarItemFactura(ItemFactura itemFactura) {
        try {
            itemFacturaService.agregarItemFactura(itemFactura);
            return "✅ Item de factura agregado correctamente.";
        } catch (Exception e) {
            return "❌ Error al agregar item de factura: " + e.getMessage();
        }
    }

    // Listar todos los items de facturas
    public List<ItemFactura> obtenerTodosItemFacturas() {
        try {
            return itemFacturaService.obtenerTodosItemFacturas();
        } catch (Exception e) {
            System.out.println("❌ Error al listar items de facturas: " + e.getMessage());
            return null;
        }
    }

    // Buscar un item por ID
    public ItemFactura obtenerItemFacturaPorId(int id) {
        try {
            return itemFacturaService.obtenerItemFacturaPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar item con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar un item de factura
    public String actualizarItemFactura(ItemFactura itemFactura) {
        try {
            itemFacturaService.actualizarItemFactura(itemFactura);
            return "✅ Item de factura actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar item de factura: " + e.getMessage();
        }
    }

    // Eliminar un item de factura
    public String eliminarItemFactura(int id) {
        try {
            itemFacturaService.eliminarItemFactura(id);
            return "🗑️ Item de factura eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar item con ID " + id + ": " + e.getMessage();
        }
    }
}
