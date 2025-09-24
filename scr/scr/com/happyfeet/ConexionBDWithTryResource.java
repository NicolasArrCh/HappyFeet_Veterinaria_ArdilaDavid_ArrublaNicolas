package scr.com.happyfeet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDWithTryResource {
    public static void main(String[] args) {
        // 0. Incluir el driver en el proyecto
        // 1. Conexión a bd mediante una cadena de coonexión
        String host = "jdbc:mysql://localhost:3306/";
        String user = "campus2023";
        String pass = "campus2023";
        String bd = "happyfeet";


        String strConn = host + bd;
        try (Connection connection = DriverManager.getConnection(strConn, user, pass)){
            System.out.println("La conexión ha sido exitosa.");
        } catch (SQLException e) {
            System.out.println("Error al conectarse con la base de datos.\n"+ e.getMessage());
        }

    }
}
