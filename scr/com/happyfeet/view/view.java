package com.happyfeet.view;

import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.entities.Adopcion;
import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.model.entities.Especie;
import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.model.entities.Factura;
import com.happyfeet.model.entities.HistorialMedico;
import com.happyfeet.model.entities.Inventario;
import com.happyfeet.model.entities.ItemFactura;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.model.entities.Proveedor;
import com.happyfeet.model.entities.PuntosCliente;
import com.happyfeet.model.entities.Raza;
import com.happyfeet.model.entities.Usuario;
import com.happyfeet.model.entities.Veterinario;

import com.happyfeet.view.ModelViews.ActividadEspecialView;
import com.happyfeet.view.ModelViews.AdopcionView;
import com.happyfeet.view.ModelViews.CitaView;
import com.happyfeet.view.ModelViews.CitaEstadoView;
import com.happyfeet.view.ModelViews.DuenoView;
import com.happyfeet.view.ModelViews.EspecieView;
import com.happyfeet.view.ModelViews.EventoTipoView;
import com.happyfeet.view.ModelViews.FacturaView;
import com.happyfeet.view.ModelViews.HistorialMedicoView;
import com.happyfeet.view.ModelViews.InventarioView;
import com.happyfeet.view.ModelViews.ItemFacturaView;
import com.happyfeet.view.ModelViews.MascotaView;
import com.happyfeet.view.ModelViews.ProductoTipoView;
import com.happyfeet.view.ModelViews.ProveedorView;
import com.happyfeet.view.ModelViews.PuntosClienteView;
import com.happyfeet.view.ModelViews.RazaView;
import com.happyfeet.view.ModelViews.UsuarioView;
import com.happyfeet.view.ModelViews.VeterinarioView;

import java.util.Scanner;

public class view {

    private final Scanner scanner;

    private final ActividadEspecialView actividadEspecialView;
    private final AdopcionView adopcionView;
    private final CitaView citaView;
    private final CitaEstadoView citaEstadoView;
    private final DuenoView duenoView;
    private final EspecieView especieView;
    private final EventoTipoView eventoTipoView;
    private final FacturaView facturaView;
    private final HistorialMedicoView historialMedicoView;
    private final InventarioView inventarioView;
    private final ItemFacturaView itemFacturaView;
    private final MascotaView mascotaView;
    private final ProductoTipoView productoTipoView;
    private final ProveedorView proveedorView;
    private final PuntosClienteView puntosClienteView;
    private final RazaView razaView;
    private final UsuarioView usuarioView;
    private final VeterinarioView veterinarioView;

    public view() {
        scanner = new Scanner(System.in);
        actividadEspecialView = new ActividadEspecialView();
        adopcionView = new AdopcionView();
        citaView = new CitaView();
        citaEstadoView = new CitaEstadoView();
        duenoView = new DuenoView();
        especieView = new EspecieView();
        eventoTipoView = new EventoTipoView();
        facturaView = new FacturaView();
        historialMedicoView = new HistorialMedicoView();
        inventarioView = new InventarioView();
        itemFacturaView = new ItemFacturaView();
        mascotaView = new MascotaView();
        productoTipoView = new ProductoTipoView();
        proveedorView = new ProveedorView();
        puntosClienteView = new PuntosClienteView();
        usuarioView = new UsuarioView();
        razaView = new RazaView();
        veterinarioView = new VeterinarioView();
    }

    public void mostrarMenuPrincipal() {
        int opcion = -1;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL HAPPY FEET =====");
            System.out.println("1. Gestión de Actividad Especial");
            System.out.println("2. Gestión de Adopcion");
            System.out.println("3. Gestión de Citas");
            System.out.println("4. Gestión de Estado de citas");
            System.out.println("5. Gestión de Duenos");
            System.out.println("6. Gestión de Especies");
            System.out.println("7. Gestión de Tipos de eventos");
            System.out.println("8. Gestión de Facturas");
            System.out.println("9. Gestión de Historial Medico");
            System.out.println("10. Gestión de Inventario");
            System.out.println("11. Gestión de Items de Facturacion");
            System.out.println("12. Gestión de Mascotas");
            System.out.println("13. Gestión de Tipos de productos");
            System.out.println("14. Gestión de Proveedores");
            System.out.println("15. Gestión de Puntos de cliente");
            System.out.println("16. Gestión de Usuarios");
            System.out.println("17. Gestión de Razas");
            System.out.println("18. Gestión de Veterinarios");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> actividadEspecialView.mostrarMenu();
                    case 2 -> adopcionView.mostrarMenu();
                    case 3 -> citaView.mostrarMenu();
                    case 4 -> especieView.mostrarMenu();
                    case 5 -> citaEstadoView.mostrarMenu();
                    case 6 -> eventoTipoView.mostrarMenu();
                    case 7 -> facturaView.mostrarMenu();
                    case 8 -> historialMedicoView.mostrarMenu();
                    case 9 -> inventarioView.mostrarMenu();
                    case 10 -> itemFacturaView.mostrarMenu();
                    case 11 -> mascotaView.mostrarMenu();
                    case 12 -> productoTipoView.mostrarMenu();
                    case 13 -> proveedorView.mostrarMenu();
                    case 14 -> puntosClienteView.mostrarMenu();
                    case 15 -> razaView.mostrarMenu();
                    case 16 -> usuarioView.mostrarMenu();
                    case 17 -> veterinarioView.mostrarMenu();
                    case 18 -> citaEstadoView.mostrarMenu();
                    case 0 -> System.out.println("👋 Saliendo del sistema Happy Feet...");
                    default -> System.out.println("⚠️ Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Debe ingresar un número válido.");
            }

        } while (opcion != 0);
    }
}
