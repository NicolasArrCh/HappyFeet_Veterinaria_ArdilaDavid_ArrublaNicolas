package com.happyfeet.controller;

import com.happyfeet.model.entities.Inventario;
import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.service.impl.InventarioServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class InventarioController {

    private InventarioServiceImpl inventarioService;

    public InventarioController() {
        this.inventarioService = new InventarioServiceImpl();
    }

    // Crear nuevo inventario
    public String registrarInventario(String nombreProducto, int productoTipoId, String descripcion,
                                      String fabricante, String lote, int cantidadStock, int stockMinimo,
                                      LocalDate fechaVencimiento, double precioVenta) {
        try {
            ProductoTipo tipo = new ProductoTipo(productoTipoId, ""); // Aquí podrías luego traerlo de un repositorio real
            Inventario inventario = new Inventario(0, nombreProducto, tipo, descripcion,
                    fabricante, lote, cantidadStock, stockMinimo,
                    fechaVencimiento, precioVenta);

            inventarioService.agregarInventario(inventario);
            return "✅ Inventario registrado con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar inventario: " + e.getMessage();
        }
    }

    // Consultar todos
    public List<Inventario> listarInventarios() {
        try {
            return inventarioService.obtenerTodosInventarios();
        } catch (Exception e) {
            System.out.println("❌ Error al listar inventarios: " + e.getMessage());
            return null;
        }
    }

    // Consultar por ID
    public Inventario buscarInventarioPorId(int id) {
        try {
            return inventarioService.obtenerInventarioPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar inventario
    public String actualizarInventario(int id, String nombreProducto, int productoTipoId, String descripcion,
                                       String fabricante, String lote, int cantidadStock, int stockMinimo,
                                       LocalDate fechaVencimiento, double precioVenta) {
        try {
            ProductoTipo tipo = new ProductoTipo(productoTipoId, "");
            Inventario inventario = new Inventario(id, nombreProducto, tipo, descripcion,
                    fabricante, lote, cantidadStock, stockMinimo,
                    fechaVencimiento, precioVenta);

            inventarioService.actualizarInventario(inventario);
            return "✅ Inventario actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar inventario: " + e.getMessage();
        }
    }

    // Eliminar inventario
    public String eliminarInventario(int id) {
        try {
            inventarioService.eliminarInventario(id);
            return "🗑️ Inventario eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar inventario: " + e.getMessage();
        }
    }

    // Descontar stock
    public String descontarStock(int id, int cantidad) {
        try {
            inventarioService.descontarStock(id, cantidad);
            return "📉 Stock descontado correctamente.";
        } catch (Exception e) {
            return "❌ Error al descontar stock: " + e.getMessage();
        }
    }

    // Verificar stock suficiente
    public boolean verificarStock(int id, int cantidad) {
        try {
            return inventarioService.verificarStockDisponible(id, cantidad);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return false;
        }
    }

    // Productos próximos a vencer
    public List<Inventario> productosPorVencer(int dias) {
        try {
            return inventarioService.obtenerProductosPorVencer(dias);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }
}
