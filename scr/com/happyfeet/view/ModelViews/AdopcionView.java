package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.AdopcionController;
import com.happyfeet.model.entities.Adopcion;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AdopcionView {
    private final AdopcionController controller;
    private final Scanner scanner;

    public AdopcionView() {
        this.controller = new AdopcionController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Registrar adopcion");
            System.out.println("2. Listar adopciones");
            System.out.println("3. Buscar adopcion por ID");
            System.out.println("4. Actualizar adopcion");
            System.out.println("5. Eliminar adopcion");
            System.out.println("6. Obtener adopcion por dueno");
            System.out.println("7. Obtener adopcion por mascota");
            System.out.println("8. Obtener adopcion por mascota");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarAdopcion();
                    case 2 -> obtenerTodasAdopcion();
                    case 3 -> obtenerAdopcionPorId();
                    case 4 -> actualizarAdopcion();
                    case 5 -> eliminarAdopcion();
                    case 6 -> obtenerPorDueno();
                    case 7 -> obtenerPorMascota();
                    case 8 -> obtenerPorFecha();
                    case 0 -> System.out.println("↩ Volviendo al menú principal...");
                    default -> System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }

    private void agregarAdopcion() {
        System.out.println("\n--- Registrar adopcion ---");
        System.out.print("Id de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Id del nuevo dueno: ");
        int nuevoDuenoId = Integer.parseInt(scanner.nextLine());
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("❌ Fecha inválida. Usa el formato yyyy-MM-dd.");
            return;
        }
        System.out.println("Nuevo contrato");
        String contrato = scanner.nextLine();

        String mensaje = controller.agregarAdopcion(mascotaId, nuevoDuenoId, fecha, contrato);
        System.out.println(mensaje);
    }

    private void obtenerTodasAdopcion() {
        System.out.println("\n--- Listar adopciones ---");
        List<Adopcion> lista = controller.obtenerTodasAdopcion();
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No hay adopciones registradas.");
        }
    }

    private void obtenerAdopcionPorId() {
        System.out.println("\n--- Buscar adopcion por ID ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Adopcion adp = controller.obtenerAdopcionPorId(id);
        if (adp != null) {
            System.out.println("✅ informacion encontrado: " + adp);
        } else {
            System.out.println("❌ No se encontró informacion con ID " + id);
        }
    }

    private void actualizarAdopcion() {
        System.out.println("\n--- Actualizar Usuario ---");
        System.out.println("ID de adopcion");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Id de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());
        System.out.print("Id del dueno: ");
        int nuevoDuenoId = Integer.parseInt(scanner.nextLine());
        System.out.print("nueva fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("❌ Fecha inválida. Usa el formato yyyy-MM-dd.");
            return;
        }
        System.out.println("Nuevo contrato");
        String contrato = scanner.nextLine();

        String mensaje = controller.actualizarAdopcion(id, mascotaId, nuevoDuenoId, fecha, contrato);
        System.out.println(mensaje);
    }

    private void eliminarAdopcion() {
        System.out.println("\n--- Eliminar adopcion ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensaje = controller.eliminarAdopcion(id);
        System.out.println(mensaje);
    }

    private void obtenerPorDueno() {
        System.out.println("\n--- Obtener adopciones por dueño ---");
        System.out.print("Ingrese el ID del dueño adoptivo: ");
        int duenoId = Integer.parseInt(scanner.nextLine());

        List<Adopcion> lista = controller.obtenerPorDueno(duenoId);
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No se encontraron adopciones para este dueño.");
        }
    }

    private void obtenerPorMascota() {
        System.out.println("\n--- Obtener adopciones por mascota ---");
        System.out.print("Ingrese el ID de la mascota: ");
        int mascotaId = Integer.parseInt(scanner.nextLine());

        List<Adopcion> lista = controller.obtenerPorMascota(mascotaId);
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No se encontraron adopciones para esta mascota.");
        }
    }

    private void obtenerPorFecha() {
        System.out.println("\n--- Obtener adopciones por fecha ---");
        System.out.print("Ingrese la fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaInput);
        } catch (Exception e) {
            System.out.println("❌ Fecha inválida. Usa el formato yyyy-MM-dd.");
            return;
        }

        List<Adopcion> lista = controller.obtenerPorFecha(fecha);
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No se encontraron adopciones en esa fecha.");
        }
    }
}
