package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.MascotaController;
import com.happyfeet.model.entities.Mascota;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MascotaView {

    private final MascotaController controller = new MascotaController();
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = -1;
        do {
            System.out.println("\n=== Gestión de Mascotas ===");
            System.out.println("1. Registrar Mascota");
            System.out.println("2. Listar Mascotas");
            System.out.println("3. Buscar Mascota por ID");
            System.out.println("4. Actualizar Mascota");
            System.out.println("5. Eliminar Mascota");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> registrarMascota();
                    case 2 -> listarMascotas();
                    case 3 -> buscarMascotaPorId();
                    case 4 -> actualizarMascota();
                    case 5 -> eliminarMascota();
                    case 0 -> System.out.println("🔙 Volviendo al menú principal...");
                    default -> System.out.println("❌ Opción inválida. Intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Debe ingresar un número válido.");
            }
        } while (opcion != 0);
    }

    private void registrarMascota() {
        try {
            System.out.println("\n--- Registrar Mascota ---");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Fecha de nacimiento (yyyy-MM-dd) [opcional]: ");
            String fechaInput = scanner.nextLine();
            LocalDate fechaNacimiento = fechaInput.isEmpty() ? null : LocalDate.parse(fechaInput);

            System.out.println("ID de la raza: ");
            int razaId = Integer.parseInt(scanner.nextLine());

            Mascota mascota = new Mascota();
            mascota.setNombre(nombre);
            mascota.setDuenoId(duenoId);
            mascota.setFechaNacimiento(fechaNacimiento);
            mascota.setRazaId(razaId);

            String mensaje = controller.registrarMascota(mascota);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarMascotas() {
        System.out.println("\n--- Lista de Mascotas ---");
        List<Mascota> mascotas = controller.listarMascotas();
        if (mascotas == null || mascotas.isEmpty()) {
            System.out.println("⚠️ No hay mascotas registradas.");
        } else {
            mascotas.forEach(System.out::println);
        }
    }

    private void buscarMascotaPorId() {
        try {
            System.out.print("\nIngrese el ID de la mascota: ");
            int id = Integer.parseInt(scanner.nextLine());

            Mascota mascota = controller.buscarMascotaPorId(id);
            if (mascota != null) {
                System.out.println("✅ Mascota encontrada: " + mascota);
            } else {
                System.out.println("⚠️ No se encontró ninguna mascota con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void actualizarMascota() {
        try {
            System.out.print("\nIngrese el ID de la mascota a actualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Nuevo ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva fecha de nacimiento (yyyy-MM-dd) [opcional]: ");
            String fechaInput = scanner.nextLine();
            LocalDate fechaNacimiento = fechaInput.isEmpty() ? null : LocalDate.parse(fechaInput);

            Mascota mascota = new Mascota();
            mascota.setId(id);
            mascota.setNombre(nombre);
            mascota.setDuenoId(duenoId);
            mascota.setFechaNacimiento(fechaNacimiento);

            String mensaje = controller.actualizarMascota(mascota);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarMascota() {
        try {
            System.out.print("\nIngrese el ID de la mascota a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.eliminarMascota(id);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
