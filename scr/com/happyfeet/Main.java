package com.happyfeet;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.view.view; // 👈 importa tu menú principal

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConexionBD.getConnection()) {
            if (connection != null) {
                System.out.println("✅ Conexión establecida con la base de datos.");

                // Lanzar menú principal
                view menuPrincipal = new view();
                menuPrincipal.mostrarMenuPrincipal();
            } else {
                System.out.println("❌ No se pudo establecer la conexión con la BD.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error al conectar con la BD: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
