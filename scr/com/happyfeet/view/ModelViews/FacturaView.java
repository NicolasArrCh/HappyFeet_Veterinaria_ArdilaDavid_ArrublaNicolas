package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.FacturaController;
import com.happyfeet.model.entities.Factura;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class FacturaView {

    private FacturaController controller;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public FacturaView() {
        this.controller = new FacturaController();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE FACTURAS ===");
            System.out.println("1. Registrar factura");
            System.out.println("2. Listar facturas");
            System.out.println("3. Buscar factura por ID");
            System.out.println("4. Buscar facturas por dueño");
            System.out.println("5. Buscar facturas por fecha");
            System.out.println("6. Actualizar factura");
            System.out.println("7. Eliminar factura");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarFactura();
                case 2 -> listarFacturas();
                case 3 -> buscarFacturaPorId();
                case 4 -> buscarFacturaPorDueno();
                case 5 -> buscarFacturaPorFecha();
                case 6 -> actualizarFactura();
                case 7 -> eliminarFactura();
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarFactura() {
        try {
            System.out.print("ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha de emisión (yyyy-MM-dd HH:mm): ");
            LocalDateTime fecha = LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Total de la factura: ");
            double total = Double.parseDouble(scanner.nextLine());

            String mensaje = controller.agregarFactura(duenoId, fecha, total);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error al registrar factura: " + e.getMessage());
        }
    }

    private void listarFacturas() {
        List<Factura> facturas = controller.obtenerTodasFacturas();
        if (facturas != null && !facturas.isEmpty()) {
            System.out.println("\n📋 LISTADO DE FACTURAS:");
            facturas.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No hay facturas registradas.");
        }
    }

    private void buscarFacturaPorId() {
        try {
            System.out.print("Ingrese ID de la factura: ");
            int id = Integer.parseInt(scanner.nextLine());

            Factura factura = controller.obtenerFacturaPorId(id);
            if (factura != null) {
                System.out.println("✅ Factura encontrada: " + factura);
            } else {
                System.out.println("⚠️ No existe una factura con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void buscarFacturaPorDueno() {
        try {
            System.out.print("Ingrese ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            List<Factura> facturas = controller.obtenerPorDueno(duenoId);
            if (facturas != null && !facturas.isEmpty()) {
                System.out.println("\n📋 FACTURAS DEL DUEÑO " + duenoId + ":");
                facturas.forEach(System.out::println);
            } else {
                System.out.println("⚠️ No hay facturas registradas para ese dueño.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void buscarFacturaPorFecha() {
        try {
            System.out.print("Ingrese fecha (yyyy-MM-dd HH:mm): ");
            LocalDateTime fecha = LocalDateTime.parse(scanner.nextLine(), formatter);

            List<Factura> facturas = controller.obtenerPorFecha(fecha);
            if (facturas != null && !facturas.isEmpty()) {
                System.out.println("\n📋 FACTURAS DE LA FECHA " + fecha.toLocalDate() + ":");
                facturas.forEach(System.out::println);
            } else {
                System.out.println("⚠️ No hay facturas en esa fecha.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void actualizarFactura() {
        try {
            System.out.print("ID de la factura a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva fecha de emisión (yyyy-MM-dd HH:mm): ");
            LocalDateTime fecha = LocalDateTime.parse(scanner.nextLine(), formatter);

            System.out.print("Nuevo total: ");
            double total = Double.parseDouble(scanner.nextLine());

            String mensaje = controller.actualizarFactura(id, duenoId, fecha, total);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void eliminarFactura() {
        try {
            System.out.print("ID de la factura a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.eliminarFactura(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
