package com.happyfeet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection connection = null;

    private static String url ="jdbc:mysql://localhost:3306/happyfeet?useSSL=false&serverTimezone=UTC";
    private static String usuario="campus2023";
    private static String contrasena="campus2023";

    private ConexionBD() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, usuario, contrasena);
                System.out.println("✅ Conexión establecida con éxito.");
            }
        } catch(SQLException e){
            System.out.println("❌ Error al conectar: " + e.getMessage());
        }
        return connection;
    }
}
