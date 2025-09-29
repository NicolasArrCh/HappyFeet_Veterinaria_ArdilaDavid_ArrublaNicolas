package com.happyfeet.controller;

import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.service.impl.ProductoTipoServiceImpl;
import com.happyfeet.service.interfaces.IProductoTipoService;

import java.util.List;

public class ProductoTipoController {

    private IProductoTipoService productoTipoService = new ProductoTipoServiceImpl();

    // Crear un nuevo tipo de producto
    public String crearProductoTipo(ProductoTipo productoTipo) {
        try {
            productoTipoService.crearProductoTipo(productoTipo);
            return "✅ ProductoTipo creado correctamente.";
        } catch (Exception e) {
            return "❌ Error al crear ProductoTipo: " + e.getMessage();
        }
    }

    // Listar todos los tipos de productos
    public List<ProductoTipo> listarProductoTipos() {
        try {
            return productoTipoService.listarProductoTipos();
        } catch (Exception e) {
            System.out.println("❌ Error al listar ProductoTipos: " + e.getMessage());
            return null;
        }
    }

    // Obtener tipo de producto por ID
    public ProductoTipo obtenerProductoTipoPorId(Integer id) {
        try {
            return productoTipoService.obtenerProductoTipoPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener ProductoTipo con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar tipo de producto
    public String actualizarProductoTipo(ProductoTipo productoTipo) {
        try {
            productoTipoService.actualizarProductoTipo(productoTipo);
            return "✅ ProductoTipo actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar ProductoTipo: " + e.getMessage();
        }
    }

    // Eliminar tipo de producto
    public String eliminarProductoTipo(Integer id) {
        try {
            productoTipoService.eliminarProductoTipo(id);
            return "🗑️ ProductoTipo eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar ProductoTipo con ID " + id + ": " + e.getMessage();
        }
    }
}
