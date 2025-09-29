package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.CitaController;
import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CitaView {

    private CitaController controller;
    private Scanner scanner;
    private DateTimeFormatter formatter;

    public CitaView() {
        this.controller = new CitaController();
        this.scanner = new Scanner(System.in);
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Citas ===");
            System.out.println("1. Registrar nueva cita");
            System.out.println("2. Listar todas las citas");
            System.out.println("3. Buscar cita por ID");
            System.out.println("4. Actualizar cita");
            System.out.println("5. Cancelar cita");
            System.out.println("6. Listar por mascota");
            System.out.println("7. Listar por fecha");
            System.out.println("8. Listar por estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarCita();
                case 2 -> listarCitas();
                case 3 -> buscarCitaPorId();
                case 4 -> actualizarCita();
                case 5 -> cancelarCita();
                case 6 -> listarPorMascota();
                case 7 -> listarPorFecha();
                case 8 -> listarPorEstado();
                case 0 -> System.out.println("👋 Volviendo al menú principal...");
                default -> System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void agregarCita() {
        System.out.println("\n--- Registrar cita ---");
        try {
            System.out.print("Id de la mascota: ");
            int mascotaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha y hora (yyyy-MM-dd HH:mm): ");
            String fechaInput = scanner.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaInput, formatter);

            System.out.print("Motivo: ");
            String motivo = scanner.nextLine();

            System.out.print("Id del estado (ej: 1=PENDIENTE, 2=CONFIRMADA, 3=CANCELADA, 4=COMPLETADA): ");
            int estadoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nombre del estado: ");
            String estadoNombre = scanner.nextLine().toUpperCase();

            String mensaje = controller.agregarCita(mascotaId, fechaHora, motivo, estadoId, estadoNombre);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarCitas() {
        System.out.println("\n--- Lista de citas ---");
        List<Cita> citas = controller.obtenerTodasCitas();
        if (citas != null && !citas.isEmpty()) {
            citas.forEach(System.out::println);
        } else {
            System.out.println("No hay citas registradas.");
        }
    }

    private void buscarCitaPorId() {
        System.out.print("Ingrese ID de la cita: ");
        int id = Integer.parseInt(scanner.nextLine());
        Cita cita = controller.obtenerCitaPorId(id);
        if (cita != null) {
            System.out.println(cita);
        } else {
            System.out.println("❌ No se encontró cita con ese ID.");
        }
    }

    private void actualizarCita() {
        try {
            System.out.print("ID de la cita a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo ID de la mascota: ");
            int mascotaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva fecha y hora (yyyy-MM-dd HH:mm): ");
            String fechaInput = scanner.nextLine();
            LocalDateTime fechaHora = LocalDateTime.parse(fechaInput, formatter);

            System.out.print("Nuevo motivo: ");
            String motivo = scanner.nextLine();

            System.out.print("Nuevo ID del estado: ");
            int estadoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre del estado: ");
            String estadoNombre = scanner.nextLine().toUpperCase();

            String mensaje = controller.actualizarCita(id, mascotaId, fechaHora, motivo, estadoId, estadoNombre);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void cancelarCita() {
        System.out.print("Ingrese ID de la cita a cancelar: ");
        int id = Integer.parseInt(scanner.nextLine());
        String mensaje = controller.eliminarCita(id);
        System.out.println(mensaje);
    }

    private void listarPorMascota() {
        System.out.print("Ingrese ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        List<Cita> citas = controller.obtenerPorMascota(mascotaId);
        if (citas != null && !citas.isEmpty()) {
            citas.forEach(System.out::println);
        } else {
            System.out.println("❌ No hay citas para esa mascota.");
        }
    }

    private void listarPorFecha() {
        try {
            System.out.print("Ingrese fecha y hora exacta (yyyy-MM-dd HH:mm): ");
            String fechaInput = scanner.nextLine();
            LocalDateTime fecha = LocalDateTime.parse(fechaInput, formatter);

            List<Cita> citas = controller.obtenerPorFecha(fecha);
            if (citas != null && !citas.isEmpty()) {
                citas.forEach(System.out::println);
            } else {
                System.out.println("❌ No hay citas en esa fecha.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarPorEstado() {
        System.out.print("Ingrese ID del estado: ");
        int estadoId = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese nombre del estado: ");
        String estadoNombre = scanner.nextLine().toUpperCase();

        CitaEstado estado = new CitaEstado(estadoId, estadoNombre);
        List<Cita> citas = controller.obtenerPorEstado(estado);
        if (citas != null && !citas.isEmpty()) {
            citas.forEach(System.out::println);
        } else {
            System.out.println("❌ No hay citas con ese estado.");
        }
    }
}
