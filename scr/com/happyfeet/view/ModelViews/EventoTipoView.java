package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.EventoTipoController;
import com.happyfeet.model.entities.EventoTipo;

import java.util.List;
import java.util.Scanner;

public class EventoTipoView {

    private final EventoTipoController controller;
    private final Scanner scanner;

    public EventoTipoView() {
        this.controller = new EventoTipoController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n=== GESTIÓN DE TIPOS DE EVENTOS ===");
            System.out.println("1. Registrar nuevo tipo de evento");
            System.out.println("2. Listar todos los tipos de evento");
            System.out.println("3. Buscar tipo de evento por ID");
            System.out.println("4. Actualizar tipo de evento");
            System.out.println("5. Eliminar tipo de evento");
            System.out.println("6. Buscar tipo de evento por nombre");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> agregarEventoTipo();
                    case 2 -> listarEventoTipos();
                    case 3 -> buscarPorId();
                    case 4 -> actualizarEventoTipo();
                    case 5 -> eliminarEventoTipo();
                    case 6 -> buscarPorNombre();
                    case 0 -> System.out.println("👋 Volviendo al menú principal...");
                    default -> System.out.println("⚠️ Opción no válida, intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Ingrese un número.");
            }

        } while (opcion != 0);
    }

    private void agregarEventoTipo() {
        System.out.println("\n--- Registrar tipo de evento ---");
        System.out.print("Nombre del tipo de evento: ");
        String nombre = scanner.nextLine();

        String mensaje = controller.agregarEventoTipo(new EventoTipo(0, nombre));
        System.out.println(mensaje);
    }

    private void listarEventoTipos() {
        System.out.println("\n--- Lista de tipos de eventos ---");
        List<EventoTipo> lista = controller.obtenerTodosEventoTipos();
        if (lista.isEmpty()) {
            System.out.println("No hay tipos de eventos registrados.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private void buscarPorId() {
        System.out.print("\nIngrese el ID del tipo de evento: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            EventoTipo eventoTipo = controller.obtenerEventoTipoPorId(id);
            System.out.println(eventoTipo);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void actualizarEventoTipo() {
        System.out.print("\nIngrese el ID del tipo de evento a actualizar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nuevo nombre: ");
            String nuevoNombre = scanner.nextLine();

            String mensaje = controller.actualizarEventoTipo(new EventoTipo(id, nuevoNombre));
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarEventoTipo() {
        System.out.print("\nIngrese el ID del tipo de evento a eliminar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarEventoTipo(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void buscarPorNombre() {
        System.out.print("\nIngrese el nombre del tipo de evento: ");
        String nombre = scanner.nextLine();
        try {
            EventoTipo eventoTipo = controller.obtenerPorNombre(nombre);
            System.out.println(eventoTipo);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
