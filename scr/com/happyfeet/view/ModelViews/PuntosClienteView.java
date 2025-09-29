package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.PuntosClienteController;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.model.entities.PuntosCliente;

import java.util.List;
import java.util.Scanner;

public class PuntosClienteView {

    private final Scanner scanner = new Scanner(System.in);
    private final PuntosClienteController controller = new PuntosClienteController();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== Gestión de Puntos de Cliente ===");
            System.out.println("1. Registrar puntos cliente");
            System.out.println("2. Listar puntos de clientes");
            System.out.println("3. Buscar puntos cliente por ID");
            System.out.println("4. Actualizar puntos cliente");
            System.out.println("5. Eliminar puntos cliente");
            System.out.println("6. Sumar puntos a cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> agregarPuntosCliente();
                case 2 -> listarPuntosClientes();
                case 3 -> buscarPorId();
                case 4 -> actualizarPuntosCliente();
                case 5 -> eliminarPuntosCliente();
                case 6 -> sumarPuntos();
                case 0 -> System.out.println("👋 Saliendo de PuntosCliente...");
                default -> System.out.println("❌ Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void agregarPuntosCliente() {
        try {
            System.out.print("ID del dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de puntos iniciales: ");
            int puntos = Integer.parseInt(scanner.nextLine());

            Dueno dueno = new Dueno();
            dueno.setId(duenoId);

            PuntosCliente pc = new PuntosCliente();
            pc.setDueno(dueno);
            pc.setPuntos(puntos);

            String mensaje = controller.agregarPuntosCliente(pc);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void listarPuntosClientes() {
        List<PuntosCliente> lista = controller.obtenerTodasPuntosCliente();
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No hay registros de puntos cliente.");
        }
    }

    private void buscarPorId() {
        try {
            System.out.print("Ingrese el ID de puntos cliente: ");
            int id = Integer.parseInt(scanner.nextLine());
            PuntosCliente pc = controller.obtenerPuntosClientePorId(id);
            if (pc != null) {
                System.out.println(pc);
            } else {
                System.out.println("⚠️ No se encontró un cliente con ese ID.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void actualizarPuntosCliente() {
        try {
            System.out.print("ID del registro de puntos cliente: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nuevo ID de dueño: ");
            int duenoId = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva cantidad de puntos: ");
            int puntos = Integer.parseInt(scanner.nextLine());

            Dueno dueno = new Dueno();
            dueno.setId(duenoId);

            PuntosCliente pc = new PuntosCliente();
            pc.setId(id);
            pc.setDueno(dueno);
            pc.setPuntos(puntos);

            String mensaje = controller.actualizarPuntosCliente(pc);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void eliminarPuntosCliente() {
        try {
            System.out.print("ID del registro de puntos cliente a eliminar: ");
            int id = Integer.parseInt(scanner.nextLine());
            String mensaje = controller.eliminarPuntosCliente(id);
            System.out.println(mensaje);
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void sumarPuntos() {
        try {
            System.out.print("ID del cliente: ");
            int idCliente = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de puntos a sumar: ");
            int puntos = Integer.parseInt(scanner.nextLine());

            String mensaje = controller.sumarPuntos(idCliente, puntos);
            System.out.println(mensaje);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
