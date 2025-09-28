package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.ActividadEspecialController;
import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.enums.TipoActividad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ActividadEspecialView {
    private final ActividadEspecialController controller;
    private final Scanner scanner;

    public ActividadEspecialView() {
        this.controller = new ActividadEspecialController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n===== GESTIÓN DE ACTIVIDADES ESPECIALES =====");
            System.out.println("1. Registrar actividad especial");
            System.out.println("2. Listar actividades especiales");
            System.out.println("3. Buscar actividad especial por ID");
            System.out.println("4. Actualizar actividad especial");
            System.out.println("5. Eliminar actividad especial");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarActividadEspecial();
                    case 2 -> obtenerTodasActividadEspecial();
                    case 3 -> obtenerActividadEspecialPorId();
                    case 4 -> actualizarActividadEspecial();
                    case 5 -> eliminarActividadEspecial();
                    case 6 -> obtenerPorTipo();
                    case 7 -> obtenerPorFecha();
                    case 0 -> System.out.println("↩ Volviendo al menú principal...");
                    default -> System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }

    private void agregarActividadEspecial() {
        System.out.println("\n--- Registrar actividad especial ---");
        System.out.print("Tipo de actividad (ADOPCION, VACUNACION, CLUB_FRECUENTES): ");
        String tipoInput = scanner.nextLine().toUpperCase();
        TipoActividad tipo = TipoActividad.valueOf(tipoInput);
        System.out.print("Descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();

        Date fecha;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.parse(fechaInput);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Usa yyyy-MM-dd");
            return;
        }

        String mensaje = controller.agregarActividadEspecial(tipo, descripcion, fecha);
        System.out.println(mensaje);
    }

    private void obtenerTodasActividadEspecial() {
        System.out.println("\n--- Lista actividades especiales ---");
        List<ActividadEspecial> lista = controller.obtenerTodasActividadEspecial();
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No hay actividades especiales.");
        }
    }

    private void obtenerActividadEspecialPorId() {
        System.out.println("\n--- Buscar actividad especial por ID ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        ActividadEspecial ae = controller.obtenerActividadEspecialPorId(id);
        if (ae != null) {
            System.out.println("✅ Usuario encontrado: " + ae);
        } else {
            System.out.println("❌ No se encontró usuario con ID " + id);
        }
    }

    private void actualizarActividadEspecial() {
        System.out.println("\n--- Actualizar Usuario ---");
        System.out.print("ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo actividad (ADOPCION, VACUNACION, CLUB_FRECUENTES): ");
        String tipoInput = scanner.nextLine().toUpperCase();
        TipoActividad tipo = TipoActividad.valueOf(tipoInput);
        System.out.print("Nueva descripcion: ");
        String descripcion = scanner.nextLine();
        System.out.print("Nueva fecha (yyyy-MM-dd): ");
        String fechaInput = scanner.nextLine();

        Date fecha;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sdf.parse(fechaInput);
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Usa yyyy-MM-dd");
            return;
        }

        String mensaje = controller.actualizarActividadEspecial(id, tipo, descripcion, fecha);
        System.out.println(mensaje);
    }

    private void eliminarActividadEspecial() {
        System.out.println("\n--- Eliminar actividad especial ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensaje = controller.eliminarActividadEspecial(id);
        System.out.println(mensaje);
    }

    private void obtenerPorTipo() {
        System.out.println("\n--- Obtener actividades por tipo ---");
        System.out.println("Ingrese el tipo de actividad (ADOPCION, VACUNACION, CLUB_FRECUENTES)");
        String tipoInput = scanner.nextLine().toUpperCase();

        try {
            TipoActividad tipo = TipoActividad.valueOf(tipoInput);
            List<ActividadEspecial> actividades = controller.obtenerPorTipo(tipo);

            if (actividades.isEmpty()) {
                System.out.println("No se encontraron actividades de tipo: " + tipo);
            } else {
                actividades.forEach(System.out::println); // muestra cada actividad
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de actividad no válido.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void obtenerPorFecha() {
        System.out.println("\n--- Obtener actividades por fecha ---");
        System.out.println("Ingrese la fecha (yyyy-MM-dd)");
        String fechaInput = scanner.nextLine();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = sdf.parse(fechaInput);

            List<ActividadEspecial> actividades = controller.obtenerPorFecha(fecha);

            if (actividades.isEmpty()) {
                System.out.println("No se encontraron actividades para la fecha: " + fechaInput);
            } else {
                actividades.forEach(System.out::println);
            }
        } catch (ParseException e) {
            System.out.println("Formato de fecha inválido. Usa yyyy-MM-dd");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
