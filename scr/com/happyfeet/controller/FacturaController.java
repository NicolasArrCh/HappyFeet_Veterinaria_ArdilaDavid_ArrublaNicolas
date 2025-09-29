package com.happyfeet.controller;

import com.happyfeet.model.entities.Dueno;
import com.happyfeet.model.entities.Factura;
import com.happyfeet.service.impl.FacturaServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

public class FacturaController {

    private FacturaServiceImpl facturaService;

    public FacturaController() {
        this.facturaService = new FacturaServiceImpl();
    }

    // Crear nueva factura
    public String agregarFactura(int duenoId, LocalDateTime fechaEmision, double total) {
        try {
            Dueno dueno = new Dueno();
            dueno.setId(duenoId);

            Factura factura = new Factura(0, dueno, fechaEmision, total);
            facturaService.agregarFactura(factura);
            return "✅ Factura registrada con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar factura: " + e.getMessage();
        }
    }

    // Consultar todas las facturas
    public List<Factura> obtenerTodasFacturas() {
        try {
            return facturaService.obtenerTodasFacturas();
        } catch (Exception e) {
            System.out.println("❌ Error al listar facturas: " + e.getMessage());
            return null;
        }
    }

    // Consultar por ID
    public Factura obtenerFacturaPorId(int id) {
        try {
            return facturaService.obtenerFacturaPorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Consultar por dueño
    public List<Factura> obtenerPorDueno(int duenoId) {
        try {
            return facturaService.obtenerPorDueno(duenoId);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Consultar por fecha
    public List<Factura> obtenerPorFecha(LocalDateTime fecha) {
        try {
            return facturaService.obtenerPorFecha(fecha);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar factura
    public String actualizarFactura(int id, int duenoId, LocalDateTime fechaEmision, double total) {
        try {
            Dueno dueno = new Dueno();
            dueno.setId(duenoId);

            Factura factura = new Factura(id, dueno, fechaEmision, total);
            facturaService.actualizarFactura(factura);
            return "✅ Factura actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar factura: " + e.getMessage();
        }
    }

    // Eliminar factura
    public String eliminarFactura(int id) {
        try {
            facturaService.eliminarFactura(id);
            return "🗑️ Factura eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar factura: " + e.getMessage();
        }
    }
}
