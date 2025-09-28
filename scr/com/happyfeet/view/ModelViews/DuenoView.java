package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.DuenoController;
import com.happyfeet.model.entities.Dueno;

import java.util.List;
import java.util.Scanner;

public class DuenoView {

    private DuenoController controller;
    private Scanner scanner;

    public DuenoView() {
        this.controller = new DuenoController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE DUEÑOS ===");
            System.out.println("1. Registrar dueño");
            System.out.println("2. Listar todos los dueños");
            System.out.println("3. Buscar dueño por ID");
            System.out.println("4. Actualizar dueño");
            System.out.println("5. Eliminar dueño");
            System.out.println("6. Buscar por documento");
            System.out.println("7. Buscar por nombre");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> agregarDueno();
                case 2 -> listarDuenos();
                case 3 -> buscarPorId();
                case 4 -> actualizarDueno();
                case 5 -> eliminarDueno();
                case 6 -> buscarPorDocumento();
                case 7 -> buscarPorNombre();
                case 0 -> System.out.println("⬅️ Volviendo al menú principal...");
                default -> System.out.println("❌ Opción no válida");
            }

        } while (opcion != 0);
    }

    private void agregarDueno() {
        System.out.println("\n--- Registrar dueño ---");
        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        String mensaje = controller.agregarDueno(nombre, documento, direccion, telefono, email);
        System.out.println(mensaje);
    }

    private void listarDuenos() {
        System.out.println("\n--- Lista de dueños ---");
        List<Dueno> lista = controller.obtenerTodosDuenos();
        if (lista == null || lista.isEmpty()) {
            System.out.println("⚠️ No hay dueños registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private void buscarPorId() {
        System.out.println("\n--- Buscar dueño por ID ---");
        System.out.print("Ingrese el ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            Dueno dueno = controller.obtenerDuenoPorId(id);
            if (dueno != null) {
                System.out.println(dueno);
            } else {
                System.out.println("⚠️ No se encontró un dueño con ese ID.");
            }
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }

    private void actualizarDueno() {
        System.out.println("\n--- Actualizar dueño ---");
        try {
            System.out.print("ID del dueño: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();

            System.out.print("Documento: ");
            String documento = scanner.nextLine();

            System.out.print("Dirección: ");
            String direccion = scanner.nextLine();

            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            String mensaje = controller.actualizarDueno(id, nombre, documento, direccion, telefono, email);
            System.out.println(mensaje);

        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }

    private void eliminarDueno() {
        System.out.println("\n--- Eliminar dueño ---");
        System.out.print("Ingrese el ID: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarDueno(id);
            System.out.println(mensaje);
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
        }
    }

    private void buscarPorDocumento() {
        System.out.println("\n--- Buscar dueño por documento ---");
        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        Dueno dueno = controller.obtenerPorDocumento(documento);
        if (dueno != null) {
            System.out.println(dueno);
        } else {
            System.out.println("⚠️ No se encontró un dueño con ese documento.");
        }
    }

    private void buscarPorNombre() {
        System.out.println("\n--- Buscar dueños por nombre ---");
        System.out.print("Ingrese nombre (o parte del nombre): ");
        String nombre = scanner.nextLine();

        List<Dueno> lista = controller.obtenerPorNombre(nombre);
        if (lista == null || lista.isEmpty()) {
            System.out.println("⚠️ No se encontraron dueños con ese nombre.");
        } else {
            lista.forEach(System.out::println);
        }
    }
}
