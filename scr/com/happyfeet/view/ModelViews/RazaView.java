package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.RazaController;
import com.happyfeet.model.entities.Raza;

import java.util.List;
import java.util.Scanner;

public class RazaView {

    private final RazaController controller;
    private final Scanner scanner;

    public RazaView() {
        this.controller = new RazaController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Razas ---");
            System.out.println("1. Registrar raza");
            System.out.println("2. Listar razas");
            System.out.println("3. Buscar raza por ID");
            System.out.println("4. Actualizar raza");
            System.out.println("5. Eliminar raza");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarRaza();
                case 2 -> listarRazas();
                case 3 -> buscarRazaPorId();
                case 4 -> actualizarRaza();
                case 5 -> eliminarRaza();
                case 0 -> System.out.println("↩️ Volviendo al menú principal...");
                default -> System.out.println("⚠️ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void registrarRaza() {
        System.out.println("\n--- Registrar raza ---");
        try {
            System.out.print("Nombre de la raza: ");
            String nombre = scanner.nextLine();

            System.out.print("ID de la especie asociada: ");
            int especieId = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.registrarRaza(nombre, especieId);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarRazas() {
        System.out.println("\n--- Listado de razas ---");
        try {
            List<Raza> razas = controller.listarRazas();
            if (razas == null || razas.isEmpty()) {
                System.out.println("⚠️ No hay razas registradas.");
            } else {
                razas.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("❌ Error al listar razas: " + e.getMessage());
        }
    }

    private void buscarRazaPorId() {
        System.out.println("\n--- Buscar raza por ID ---");
        try {
            System.out.print("Ingrese el ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            Raza raza = controller.buscarRazaPorId(id);
            if (raza != null) {
                System.out.println("✅ Raza encontrada: " + raza);
            } else {
                System.out.println("⚠️ No se encontró una raza con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void actualizarRaza() {
        System.out.println("\n--- Actualizar raza ---");
        try {
            System.out.print("ID de la raza a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre de la raza: ");
            String nombre = scanner.nextLine();

            System.out.print("Nuevo ID de la especie: ");
            int especieId = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.actualizarRaza(id, nombre, especieId);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarRaza() {
        System.out.println("\n--- Eliminar raza ---");
        try {
            System.out.print("Ingrese el ID de la raza: ");
            int id = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.eliminarRaza(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
