package scr.com.happyfeet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static volatile ConexionBD instance;
    private Connection connection;

    private static String url ="jdbc:mysql://localhost:3306/happyfeet";
    private static String usuario="campus2023";
    private static String contrasena="campus2023";

    private ConexionBD () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Base de datos conectada");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error en la conexión: " + e.getMessage());
        }
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            if (instance == null) {
                instance = new ConexionBD();
            }
            return instancia;
        }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                reconnect();
            }
        } catch (SQLException e) {
            System.err.println("Error verificando el estado de la conexión");
            e.printStackTrace();
            reconnect();
        }
        return null;
    }

        public Connection getConexion() {
            return conexion;
        }
    }