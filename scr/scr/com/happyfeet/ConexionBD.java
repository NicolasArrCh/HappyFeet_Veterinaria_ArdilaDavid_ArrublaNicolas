package scr.com.happyfeet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static volatile ConexionBD instance;
    private Connection connection;

    private static String url ="jdbc:mysql://localhost:3306/database";
    private static String usuario="campus2023";
    private static String contrasena="campus2023";

    private ConexionBD () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Base de datos conectada");
        } catch (ClassNotFoundException e) {
            System.err.println("Error.. No se pudo cargar el driver de MySQL");
        } catch (SQLException e) {
            System.err.println("Error.. No se pudo establecer la conexión");
        }
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            synchronized (ConexionBD.class) {
                if (instance == null) {
                    instance = new ConexionBD();
                }
            }
        }

        return instance;
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

    private void reconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión reestablecida");
        } catch (SQLException e) {
            System.err.println("Error al reconectar");
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
}