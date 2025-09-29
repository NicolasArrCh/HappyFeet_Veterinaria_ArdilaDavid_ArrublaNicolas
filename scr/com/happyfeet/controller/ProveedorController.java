package com.happyfeet.controller;

import com.happyfeet.model.entities.Proveedor;
import com.happyfeet.service.impl.ProveedorServiceImpl;
import com.happyfeet.service.interfaces.IProveedorService;

import java.util.List;

public class ProveedorController {

    private final IProveedorService proveedorService = new ProveedorServiceImpl();

    // Crear un nuevo proveedor
    public String crearProveedor(Proveedor proveedor) {
        try {
            proveedorService.registrarProveedor(proveedor);
            return "✅ Proveedor registrado correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar proveedor: " + e.getMessage();
        }
    }

    // Listar todos los proveedores
    public List<Proveedor> listarProveedores() {
        try {
            return proveedorService.listarProveedores();
        } catch (Exception e) {
            System.out.println("❌ Error al listar proveedores: " + e.getMessage());
            return null;
        }
    }

    // Buscar proveedor por ID
    public Proveedor obtenerProveedorPorId(Integer id) {
        try {
            return proveedorService.buscarProveedorPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al obtener proveedor con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar proveedor
    public String actualizarProveedor(Proveedor proveedor) {
        try {
            proveedorService.actualizarProveedor(proveedor);
            return "✅ Proveedor actualizado correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar proveedor: " + e.getMessage();
        }
    }

    // Eliminar proveedor
    public String eliminarProveedor(Integer id) {
        try {
            proveedorService.eliminarProveedor(id);
            return "🗑️ Proveedor eliminado correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar proveedor con ID " + id + ": " + e.getMessage();
        }
    }
}
