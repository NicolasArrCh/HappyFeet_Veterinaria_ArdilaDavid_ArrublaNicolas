package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.ItemFacturaController;
import com.happyfeet.model.entities.Factura;
import com.happyfeet.model.entities.ItemFactura;

import java.util.List;
import java.util.Scanner;

public class ItemFacturaView {

    private ItemFacturaController controller = new ItemFacturaController();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== Gestión de Items de Factura ===");
            System.out.println("1. Agregar ItemFactura");
            System.out.println("2. Listar todos los Items");
            System.out.println("3. Buscar Item por ID");
            System.out.println("4. Actualizar Item");
            System.out.println("5. Eliminar Item");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarItemFactura();
                    case 2 -> listarItems();
                    case 3 -> buscarItemPorId();
                    case 4 -> actualizarItemFactura();
                    case 5 -> eliminarItemFactura();
                    case 0 -> System.out.println("👋 Saliendo del módulo de Items de Factura...");
                    default -> System.out.println("❌ Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida, debe ser un número.");
            }
        } while (opcion != 0);
    }

    private void agregarItemFactura() {
        System.out.println("\n--- Agregar ItemFactura ---");
        try {
            System.out.print("ID de la factura asociada: ");
            int facturaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.print("Precio unitario: ");
            double precioUnitario = Double.parseDouble(scanner.nextLine());

            Factura factura = new Factura();
            factura.setId(facturaId);

            ItemFactura item = new ItemFactura();
            item.setFactura(factura);
            item.setCantidad(cantidad);
            item.setPrecioUnitario(precioUnitario);

            String mensaje = controller.agregarItemFactura(item);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarItems() {
        System.out.println("\n--- Listado de Items de Factura ---");
        List<ItemFactura> items = controller.obtenerTodosItemFacturas();
        if (items == null || items.isEmpty()) {
            System.out.println("⚠️ No hay items registrados.");
        } else {
            items.forEach(System.out::println);
        }
    }

    private void buscarItemPorId() {
        System.out.print("\nIngrese el ID del item: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            ItemFactura item = controller.obtenerItemFacturaPorId(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("⚠️ No se encontró el item con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void actualizarItemFactura() {
        System.out.println("\n--- Actualizar ItemFactura ---");
        try {
            System.out.print("ID del item a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva cantidad: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo precio unitario: ");
            double precioUnitario = Double.parseDouble(scanner.nextLine());

            ItemFactura item = new ItemFactura();
            item.setId(id);
            item.setCantidad(cantidad);
            item.setPrecioUnitario(precioUnitario);

            String mensaje = controller.actualizarItemFactura(item);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarItemFactura() {
        System.out.print("\nIngrese el ID del item a eliminar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarItemFactura(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
