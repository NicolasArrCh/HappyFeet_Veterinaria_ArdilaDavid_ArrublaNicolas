import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            // Obtener la instancia de conexión
            Connection conn = ConexionSingleton.getInstancia().getConexion();

            // Probar una consulta
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW() AS fecha_actual");

            while (rs.next()) {
                System.out.println("Fecha actual en la BD: " + rs.getString("fecha_actual"));
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}