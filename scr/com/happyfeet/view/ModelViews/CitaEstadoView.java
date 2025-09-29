package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.CitaEstadoController;
import com.happyfeet.model.entities.CitaEstado;

import java.util.List;
import java.util.Scanner;

public class CitaEstadoView {

    private Scanner scanner;
    private CitaEstadoController controller;

    public CitaEstadoView() {
        this.scanner = new Scanner(System.in);
        this.controller = new CitaEstadoController();
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n=== GESTIÓN DE ESTADOS DE CITAS ===");
            System.out.println("1. Registrar nuevo estado");
            System.out.println("2. Listar todos los estados");
            System.out.println("3. Buscar estado por ID");
            System.out.println("4. Buscar estado por nombre");
            System.out.println("5. Actualizar estado");
            System.out.println("6. Eliminar estado");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1 -> agregarCitaEstado();
                    case 2 -> listarEstados();
                    case 3 -> buscarPorId();
                    case 4 -> buscarPorNombre();
                    case 5 -> actualizarEstado();
                    case 6 -> eliminarEstado();
                    case 0 -> System.out.println("↩ Volviendo al menú principal...");
                    default -> System.out.println("⚠ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Ingrese un número.");
            }
        } while (opcion != 0);
    }

    private void agregarCitaEstado() {
        System.out.print("Ingrese el nombre del nuevo estado: ");
        String nombre = scanner.nextLine();
        String mensaje = controller.agregarCitaEstado(nombre);
        System.out.println(mensaje);
    }

    private void listarEstados() {
        List<CitaEstado> estados = controller.obtenerTodasCitaEstados();
        if (estados != null && !estados.isEmpty()) {
            System.out.println("\n📋 Lista de estados de citas:");
            estados.forEach(System.out::println);
        } else {
            System.out.println("⚠ No hay estados registrados.");
        }
    }

    private void buscarPorId() {
        try {
            System.out.print("Ingrese el ID del estado: ");
            int id = Integer.parseInt(scanner.nextLine());
            CitaEstado estado = controller.obtenerCitaEstadoPorId(id);
            if (estado != null) {
                System.out.println("✅ Estado encontrado: " + estado);
            } else {
                System.out.println("⚠ No se encontró un estado con ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }

    private void buscarPorNombre() {
        System.out.print("Ingrese el nombre del estado: ");
        String nombre = scanner.nextLine();
        CitaEstado estado = controller.obtenerPorNombre(nombre);
        if (estado != null) {
            System.out.println("✅ Estado encontrado: " + estado);
        } else {
            System.out.println("⚠ No se encontró un estado con nombre '" + nombre + "'");
        }
    }

    private void actualizarEstado() {
        try {
            System.out.print("Ingrese el ID del estado a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el nuevo nombre: ");
            String nombre = scanner.nextLine();

            String mensaje = controller.actualizarCitaEstado(id, nombre);
            System.out.println(mensaje);
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }

    private void eliminarEstado() {
        try {
            System.out.print("Ingrese el ID del estado a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarCitaEstado(id);
            System.out.println(mensaje);
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }
}
