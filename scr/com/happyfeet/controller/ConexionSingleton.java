package main.java.com.happyfeet.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// La conexion como un Singleton
public class ConexionSingleton {
    private static String host = "jdbc:mysql://localhost:3306/";
    private static String user = "campus2023"; //cambiar user en caso necesario
    private static String pass = "campus2023"; //cambiar pass en caso necesario
    private static String db = "happyfeet";

    private static String StrConn = host + db;
    private static Connection connection;
    private static ConexionSingleton instancia;

    private ConexionSingleton() {
        this.instancia = null;
        this.connection = null;

    }

    public static ConexionSingleton getInstance() {
        if (instancia == null){
            instancia = new ConexionSingleton();
            try {
                if(connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(StrConn, user, pass);
                    System.out.println("Conexion con exito!!");
                }
            }catch (SQLException e) {
                connection = null;
                System.out.println("Error al conectarse a la base de datos.\n" + e.getMessage());
            }
        }
        return instancia;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void closeConnection() {
        try {
            if(connection != null || !connection.isClosed()) {
                connection.close();
                System.out.println("Conexion cerrada");
            }
        } catch(SQLException e) {
            System.out.println("Error al cerrar la conexion!!\n" + e.getMessage());
        }
    }
}
