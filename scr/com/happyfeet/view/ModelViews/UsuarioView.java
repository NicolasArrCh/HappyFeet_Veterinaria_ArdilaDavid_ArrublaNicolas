package com.happyfeet.view.ModelViews;

import com.happyfeet.controller.UsuarioController;
import com.happyfeet.model.entities.Usuario;

import java.util.List;
import java.util.Scanner;

public class UsuarioView {

    private final UsuarioController controller;
    private final Scanner scanner;

    public UsuarioView() {
        this.controller = new UsuarioController();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion = -1;

        do {
            System.out.println("\n===== GESTIÓN DE USUARIOS =====");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario por ID");
            System.out.println("4. Actualizar usuario");
            System.out.println("5. Eliminar usuario");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> registrarUsuario();
                    case 2 -> listarUsuarios();
                    case 3 -> buscarUsuarioPorId();
                    case 4 -> actualizarUsuario();
                    case 5 -> eliminarUsuario();
                    case 0 -> System.out.println("↩ Volviendo al menú principal...");
                    default -> System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }

    private void registrarUsuario() {
        System.out.println("\n--- Registrar Usuario ---");
        System.out.print("Nombre usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Rol (ADMIN/CLIENTE/VETERINARIO): ");
        String rol = scanner.nextLine();

        String mensaje = controller.registrarUsuario(nombre, contrasena, rol);
        System.out.println(mensaje);
    }

    private void listarUsuarios() {
        System.out.println("\n--- Lista de Usuarios ---");
        List<Usuario> lista = controller.listarUsuarios();
        if (lista != null && !lista.isEmpty()) {
            lista.forEach(System.out::println);
        } else {
            System.out.println("⚠️ No hay usuarios registrados.");
        }
    }

    private void buscarUsuarioPorId() {
        System.out.println("\n--- Buscar Usuario ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Usuario u = controller.buscarUsuarioPorId(id);
        if (u != null) {
            System.out.println("✅ Usuario encontrado: " + u);
        } else {
            System.out.println("❌ No se encontró usuario con ID " + id);
        }
    }

    private void actualizarUsuario() {
        System.out.println("\n--- Actualizar Usuario ---");
        System.out.print("ID del usuario: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva contraseña: ");
        String contrasena = scanner.nextLine();
        System.out.print("Nuevo rol (ADMIN/CLIENTE/VETERINARIO): ");
        String rol = scanner.nextLine();

        String mensaje = controller.actualizarUsuario(id, nombre, contrasena, rol);
        System.out.println(mensaje);
    }

    private void eliminarUsuario() {
        System.out.println("\n--- Eliminar Usuario ---");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        String mensaje = controller.eliminarUsuario(id);
        System.out.println(mensaje);
    }
}
