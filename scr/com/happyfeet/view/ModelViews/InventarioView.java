package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.InventarioController;
import com.happyfeet.model.entities.Inventario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class InventarioView {

    private final InventarioController controller;
    private final Scanner scanner;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public InventarioView() {
        this.controller = new InventarioController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Menú Inventario ===");
            System.out.println("1. Registrar producto en inventario");
            System.out.println("2. Listar inventarios");
            System.out.println("3. Buscar inventario por ID");
            System.out.println("4. Actualizar inventario");
            System.out.println("5. Eliminar inventario");
            System.out.println("6. Descontar stock");
            System.out.println("7. Verificar stock disponible");
            System.out.println("8. Productos próximos a vencer");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarInventario();
                case 2 -> listarInventarios();
                case 3 -> buscarInventarioPorId();
                case 4 -> actualizarInventario();
                case 5 -> eliminarInventario();
                case 6 -> descontarStock();
                case 7 -> verificarStock();
                case 8 -> productosPorVencer();
                case 0 -> System.out.println("👋 Saliendo del menú de inventario...");
                default -> System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarInventario() {
        try {
            System.out.println("\n--- Registrar producto ---");
            System.out.print("Nombre producto: ");
            String nombre = scanner.nextLine();

            System.out.print("ID tipo de producto: ");
            int tipoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Fabricante: ");
            String fabricante = scanner.nextLine();

            System.out.print("Lote: ");
            String lote = scanner.nextLine();

            System.out.print("Cantidad en stock: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.print("Stock mínimo: ");
            int stockMinimo = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha de vencimiento (yyyy-MM-dd): ");
            LocalDate fechaVencimiento = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Precio de venta: ");
            double precio = Double.parseDouble(scanner.nextLine());

            String mensaje = controller.registrarInventario(nombre, tipoId, descripcion, fabricante, lote,
                    cantidad, stockMinimo, fechaVencimiento, precio);

            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarInventarios() {
        System.out.println("\n--- Listado de inventarios ---");
        List<Inventario> inventarios = controller.listarInventarios();
        if (inventarios != null && !inventarios.isEmpty()) {
            inventarios.forEach(System.out::println);
        } else {
            System.out.println("No hay productos en inventario.");
        }
    }

    private void buscarInventarioPorId() {
        try {
            System.out.print("Ingrese ID de inventario: ");
            int id = Integer.parseInt(scanner.nextLine());
            Inventario inv = controller.buscarInventarioPorId(id);
            if (inv != null) {
                System.out.println("✅ Encontrado: " + inv);
            } else {
                System.out.println("❌ No se encontró inventario con ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void actualizarInventario() {
        try {
            System.out.println("\n--- Actualizar inventario ---");
            System.out.print("ID de inventario: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre producto: ");
            String nombre = scanner.nextLine();

            System.out.print("ID tipo de producto: ");
            int tipoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            System.out.print("Fabricante: ");
            String fabricante = scanner.nextLine();

            System.out.print("Lote: ");
            String lote = scanner.nextLine();

            System.out.print("Cantidad en stock: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.print("Stock mínimo: ");
            int stockMinimo = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha de vencimiento (yyyy-MM-dd): ");
            LocalDate fechaVencimiento = LocalDate.parse(scanner.nextLine(), dateFormatter);

            System.out.print("Precio de venta: ");
            double precio = Double.parseDouble(scanner.nextLine());

            String mensaje = controller.actualizarInventario(id, nombre, tipoId, descripcion, fabricante, lote,
                    cantidad, stockMinimo, fechaVencimiento, precio);

            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarInventario() {
        try {
            System.out.print("Ingrese ID de inventario a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarInventario(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void descontarStock() {
        try {
            System.out.print("Ingrese ID de inventario: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Cantidad a descontar: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.descontarStock(id, cantidad);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void verificarStock() {
        try {
            System.out.print("Ingrese ID de inventario: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Cantidad a verificar: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            boolean disponible = controller.verificarStock(id, cantidad);
            System.out.println(disponible ? "✅ Stock suficiente." : "❌ Stock insuficiente.");
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }

    private void productosPorVencer() {
        try {
            System.out.print("Ingrese cantidad de días: ");
            int dias = Integer.parseInt(scanner.nextLine());
            List<Inventario> proximos = controller.productosPorVencer(dias);

            System.out.println("\n--- Productos próximos a vencer ---");
            if (proximos != null && !proximos.isEmpty()) {
                proximos.forEach(System.out::println);
            } else {
                System.out.println("No hay productos próximos a vencer.");
            }
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
}
