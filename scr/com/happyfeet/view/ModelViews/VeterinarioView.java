package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.VeterinarioController;
import com.happyfeet.model.entities.Veterinario;

import java.util.List;
import java.util.Scanner;

public class VeterinarioView {

    private final VeterinarioController controller;
    private final Scanner scanner;

    public VeterinarioView() {
        this.controller = new VeterinarioController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE VETERINARIOS ===");
            System.out.println("1. Registrar veterinario");
            System.out.println("2. Listar veterinarios");
            System.out.println("3. Buscar veterinario por ID");
            System.out.println("4. Actualizar veterinario");
            System.out.println("5. Eliminar veterinario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> registrarVeterinario();
                case 2 -> listarVeterinarios();
                case 3 -> buscarVeterinarioPorId();
                case 4 -> actualizarVeterinario();
                case 5 -> eliminarVeterinario();
                case 0 -> System.out.println("⬅ Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void registrarVeterinario() {
        System.out.println("\n--- Registrar Veterinario ---");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Documento de identidad: ");
        String documento = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        String mensaje = controller.registrarVeterinario(nombre, documento, especialidad, telefono, email);
        System.out.println(mensaje);
    }

    private void listarVeterinarios() {
        System.out.println("\n--- Lista de Veterinarios ---");
        List<Veterinario> lista = controller.listarVeterinarios();
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("No hay veterinarios registrados.");
        }
    }

    private void buscarVeterinarioPorId() {
        System.out.println("\n--- Buscar Veterinario ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        Veterinario vt = controller.buscarVeterinarioPorId(id);
        if (vt != null) {
            System.out.println("✅ Veterinario encontrado: " + vt);
        } else {
            System.out.println("❌ No se encontró un veterinario con ID " + id);
        }
    }

    private void actualizarVeterinario() {
        System.out.println("\n--- Actualizar Veterinario ---");
        System.out.print("ID del veterinario a actualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nuevo nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Nuevo documento de identidad: ");
        String documento = scanner.nextLine();
        System.out.print("Nueva especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Nuevo teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Nuevo email: ");
        String email = scanner.nextLine();

        String mensaje = controller.actualizarVeterinario(id, nombre, documento, especialidad, telefono, email);
        System.out.println(mensaje);
    }

    private void eliminarVeterinario() {
        System.out.println("\n--- Eliminar Veterinario ---");
        System.out.print("Ingrese ID del veterinario: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensaje = controller.eliminarVeterinario(id);
        System.out.println(mensaje);
    }
}
