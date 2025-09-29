package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.ProductoTipoController;
import com.happyfeet.model.entities.ProductoTipo;

import java.util.List;
import java.util.Scanner;

public class ProductoTipoView {

    private final ProductoTipoController controller;
    private final Scanner scanner;

    public ProductoTipoView() {
        this.controller = new ProductoTipoController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Tipos de Producto ===");
            System.out.println("1. Crear ProductoTipo");
            System.out.println("2. Listar ProductoTipos");
            System.out.println("3. Obtener ProductoTipo por ID");
            System.out.println("4. Actualizar ProductoTipo");
            System.out.println("5. Eliminar ProductoTipo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> crearProductoTipo();
                case 2 -> listarProductoTipos();
                case 3 -> obtenerProductoTipoPorId();
                case 4 -> actualizarProductoTipo();
                case 5 -> eliminarProductoTipo();
                case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida.");
            }

        } while (opcion != 0);
    }

    private void crearProductoTipo() {
        System.out.println("\n--- Crear ProductoTipo ---");
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();

        ProductoTipo productoTipo = new ProductoTipo();
        productoTipo.setNombre(nombre);

        String mensaje = controller.crearProductoTipo(productoTipo);
        System.out.println(mensaje);
    }

    private void listarProductoTipos() {
        System.out.println("\n--- Lista de ProductoTipos ---");
        List<ProductoTipo> lista = controller.listarProductoTipos();

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay tipos de productos registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private void obtenerProductoTipoPorId() {
        System.out.println("\n--- Buscar ProductoTipo por ID ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        ProductoTipo productoTipo = controller.obtenerProductoTipoPorId(id);
        if (productoTipo != null) {
            System.out.println(productoTipo);
        } else {
            System.out.println("❌ No se encontró un ProductoTipo con el ID " + id);
        }
    }

    private void actualizarProductoTipo() {
        System.out.println("\n--- Actualizar ProductoTipo ---");
        System.out.print("Ingrese ID del ProductoTipo a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese nuevo nombre: ");
        String nombre = scanner.nextLine();

        ProductoTipo productoTipo = new ProductoTipo(id, nombre);

        String mensaje = controller.actualizarProductoTipo(productoTipo);
        System.out.println(mensaje);
    }

    private void eliminarProductoTipo() {
        System.out.println("\n--- Eliminar ProductoTipo ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensaje = controller.eliminarProductoTipo(id);
        System.out.println(mensaje);
    }
}
