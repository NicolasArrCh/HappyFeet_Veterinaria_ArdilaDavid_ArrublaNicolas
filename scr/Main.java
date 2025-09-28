import com.happyfeet.util.ConexionBD;

import java.sql.Connection;
public class Main {
    public static void main(String[] args) {
        try (Connection connection = ConexionBD.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión lista para consultas 🚀");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}