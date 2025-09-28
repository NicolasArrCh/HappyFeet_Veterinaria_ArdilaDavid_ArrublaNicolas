package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.ProveedorController;
import com.happyfeet.model.entities.Proveedor;

import java.util.List;
import java.util.Scanner;

public class ProveedorView {

    private final ProveedorController controller = new ProveedorController();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Proveedores ===");
            System.out.println("1. Registrar proveedor");
            System.out.println("2. Listar proveedores");
            System.out.println("3. Buscar proveedor por ID");
            System.out.println("4. Actualizar proveedor");
            System.out.println("5. Eliminar proveedor");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarProveedor();
                case 2 -> listarProveedores();
                case 3 -> buscarProveedorPorId();
                case 4 -> actualizarProveedor();
                case 5 -> eliminarProveedor();
                case 0 -> System.out.println("👋 Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarProveedor() {
        System.out.println("\n--- Registrar Proveedor ---");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        // Crear nuevo
        Proveedor proveedor = new Proveedor(0, nombre, telefono, email, direccion);
        String mensaje = controller.crearProveedor(proveedor);
        System.out.println(mensaje);
    }

    private void listarProveedores() {
        System.out.println("\n--- Lista de Proveedores ---");
        List<Proveedor> proveedores = controller.listarProveedores();
        if (proveedores == null || proveedores.isEmpty()) {
            System.out.println("No hay proveedores registrados.");
        } else {
            proveedores.forEach(System.out::println);
        }
    }

    private void buscarProveedorPorId() {
        System.out.print("\nIngrese el ID del proveedor: ");
        int id = Integer.parseInt(scanner.nextLine());
        Proveedor proveedor = controller.obtenerProveedorPorId(id);
        if (proveedor != null) {
            System.out.println("Proveedor encontrado: " + proveedor);
        } else {
            System.out.println("No se encontró un proveedor con ID " + id);
        }
    }

    private void actualizarProveedor() {
        System.out.print("\nIngrese el ID del proveedor a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Proveedor proveedorExistente = controller.obtenerProveedorPorId(id);
        if (proveedorExistente == null) {
            System.out.println("No existe un proveedor con ID " + id);
            return;
        }

        System.out.print("Nuevo nombre (" + proveedorExistente.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (nombre.isBlank()) nombre = proveedorExistente.getNombre();

        System.out.print("Nuevo teléfono (" + proveedorExistente.getTelefono() + "): ");
        String telefono = scanner.nextLine();
        if (telefono.isBlank()) telefono = proveedorExistente.getTelefono();

        System.out.print("Nuevo email (" + proveedorExistente.getEmail() + "): ");
        String email = scanner.nextLine();
        if (email.isBlank()) email = proveedorExistente.getEmail();

        System.out.print("Nueva direccion (" + proveedorExistente.getDireccion() + "): ");
        String direccion = scanner.nextLine();
        if (direccion.isBlank()) direccion = proveedorExistente.getDireccion();

        // Actualizar
        Proveedor actualizado = new Proveedor(id, nombre, telefono, email, direccion);
        String mensaje = controller.actualizarProveedor(actualizado);
        System.out.println(mensaje);
    }

    private void eliminarProveedor() {
        System.out.print("\nIngrese el ID del proveedor a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensaje = controller.eliminarProveedor(id);
        System.out.println(mensaje);
    }
}
