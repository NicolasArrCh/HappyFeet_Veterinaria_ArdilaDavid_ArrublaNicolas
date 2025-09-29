package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.HistorialMedicoController;
import com.happyfeet.model.entities.HistorialMedico;
import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.model.entities.Mascota;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HistorialMedicoView {

    private final HistorialMedicoController controller = new HistorialMedicoController();
    private final Scanner scanner = new Scanner(System.in);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== GESTIÓN DE HISTORIAL MÉDICO =====");
            System.out.println("1. Agregar historial médico");
            System.out.println("2. Listar historiales médicos");
            System.out.println("3. Buscar historial médico por ID");
            System.out.println("4. Actualizar historial médico");
            System.out.println("5. Eliminar historial médico");
            System.out.println("6. Buscar por mascota");
            System.out.println("7. Buscar por fecha");
            System.out.println("8. Buscar por tipo de evento");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarHistorial();
                case 2 -> controller.obtenerTodosHistorialesMedicos();
                case 3 -> buscarPorId();
                case 4 -> actualizarHistorial();
                case 5 -> eliminarHistorial();
                case 6 -> buscarPorMascota();
                case 7 -> buscarPorFecha();
                case 8 -> buscarPorEventoTipo();
                case 0 -> System.out.println("⬅ Volviendo al menú principal...");
                default -> System.out.println("⚠ Opción inválida. Intente de nuevo.");
            }

        } while (opcion != 0);
    }

    private void agregarHistorial() {
        System.out.println("\n--- Registrar historial médico ---");
        try {
            System.out.print("ID de la mascota: ");
            int mascotaId = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha del evento (yyyy-MM-dd): ");
            String fechaInput = scanner.nextLine();
            LocalDate fechaEvento = LocalDate.parse(fechaInput, formatter);

            System.out.print("ID del tipo de evento: ");
            int eventoTipoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();

            Mascota mascota = new Mascota();
            mascota.setId(mascotaId);

            EventoTipo eventoTipo = new EventoTipo();
            eventoTipo.setId(eventoTipoId);

            System.out.print("Diagnóstico: ");
            String diagnostico = scanner.nextLine();

            System.out.print("Tratamiento recomendado: ");
            String tratamiento = scanner.nextLine();

            HistorialMedico historial = new HistorialMedico(
                    0, mascota, fechaEvento, eventoTipo, descripcion, diagnostico, tratamiento
            );

            controller.agregarHistorialMedico(historial);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void buscarPorId() {
        System.out.print("Ingrese el ID del historial: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.obtenerHistorialMedicoPorId(id);
    }

    private void actualizarHistorial() {
        System.out.println("\n--- Actualizar historial médico ---");
        try {
            System.out.print("ID del historial a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva descripción: ");
            String descripcion = scanner.nextLine();

            // Nota: solo actualizamos la descripción aquí
            HistorialMedico historial = new HistorialMedico();
            historial.setId(id);
            historial.setDescripcion(descripcion);

            controller.actualizarHistorialMedico(historial);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarHistorial() {
        System.out.print("Ingrese el ID del historial a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.eliminarHistorialMedico(id);
    }

    private void buscarPorMascota() {
        System.out.print("Ingrese el ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        controller.obtenerPorMascota(mascotaId);
    }

    private void buscarPorFecha() {
        System.out.print("Ingrese la fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaInput, formatter);
        controller.obtenerPorFecha(fecha);
    }

    private void buscarPorEventoTipo() {
        System.out.print("Ingrese el ID del tipo de evento: ");
        int eventoTipoId = Integer.parseInt(scanner.nextLine());
        controller.obtenerPorEventoTipo(eventoTipoId);
    }
}
