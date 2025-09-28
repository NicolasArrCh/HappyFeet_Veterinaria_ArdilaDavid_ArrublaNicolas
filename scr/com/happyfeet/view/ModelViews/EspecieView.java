package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.EspeciesController;
import com.happyfeet.model.entities.Especie;

import java.util.List;
import java.util.Scanner;

public class EspecieView {

    private Scanner scanner;
    private EspeciesController controller;

    public EspecieView() {
        scanner = new Scanner(System.in);
        controller = new EspeciesController();
    }

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== GESTIÓN DE ESPECIES ===");
            System.out.println("1. Agregar especie");
            System.out.println("2. Listar especies");
            System.out.println("3. Buscar especie por ID");
            System.out.println("4. Buscar especie por nombre");
            System.out.println("5. Actualizar especie");
            System.out.println("6. Eliminar especie");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarEspecie();
                    case 2 -> listarEspecies();
                    case 3 -> buscarPorId();
                    case 4 -> buscarPorNombre();
                    case 5 -> actualizarEspecie();
                    case 6 -> eliminarEspecie();
                    case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                    default -> System.out.println("⚠️ Opción inválida, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número.");
            }
        } while (opcion != 0);
    }

    private void agregarEspecie() {
        System.out.println("\n--- Registrar nueva especie ---");
        System.out.print("Nombre de la especie: ");
        String nombre = scanner.nextLine();

        String mensaje = controller.agregarEspecie(nombre);
        System.out.println(mensaje);
    }

    private void listarEspecies() {
        System.out.println("\n--- Lista de especies ---");
        List<Especie> especies = controller.obtenerTodasEspecies();
        if (especies == null || especies.isEmpty()) {
            System.out.println("No hay especies registradas.");
        } else {
            especies.forEach(System.out::println);
        }
    }

    private void buscarPorId() {
        System.out.print("\nIngrese el ID de la especie: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Especie especie = controller.obtenerEspeciePorId(id);
            if (especie != null) {
                System.out.println("✅ Especie encontrada: " + especie);
            } else {
                System.out.println("⚠️ No existe una especie con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El ID debe ser un número entero.");
        }
    }

    private void buscarPorNombre() {
        System.out.print("\nIngrese el nombre de la especie: ");
        String nombre = scanner.nextLine();
        Especie especie = controller.obtenerPorNombre(nombre);
        if (especie != null) {
            System.out.println("✅ Especie encontrada: " + especie);
        } else {
            System.out.println("⚠️ No existe una especie con ese nombre.");
        }
    }

    private void actualizarEspecie() {
        try {
            System.out.print("\nIngrese el ID de la especie a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            String mensaje = controller.actualizarEspecie(id, nombre);
            System.out.println(mensaje);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El ID debe ser un número entero.");
        }
    }

    private void eliminarEspecie() {
        try {
            System.out.print("\nIngrese el ID de la especie a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.eliminarEspecie(id);
            System.out.println(mensaje);
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El ID debe ser un número entero.");
        }
    }
}
