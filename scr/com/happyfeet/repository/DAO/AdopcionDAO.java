package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Adopcion;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.repository.inter.IAdopcionDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdopcionDAO implements IAdopcionDAO {

    @Override
    public void agregarAdopcion(Adopcion adopcion) {
        String sql = "INSERT INTO adopciones (mascota_id, nuevo_dueno_id, fecha, contrato) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, adopcion.getMascota().getId());
            stmt.setInt(2, adopcion.getNuevoDueno().getId());
            stmt.setDate(3, Date.valueOf(adopcion.getFecha()));
            stmt.setString(4, adopcion.getContrato());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar adopción: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Adopcion> obtenerTodasAdopcion() {
        List<Adopcion> adopciones = new ArrayList<>();
        String sql = "SELECT * FROM adopciones";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Adopcion adopcion = mapResultSetToAdopcion(rs);
                adopciones.add(adopcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adopciones;
    }

    @Override
    public Adopcion obtenerAdopcionPorId(Integer id) {
        String sql = "SELECT * FROM adopciones WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToAdopcion(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarAdopcion(Adopcion adopcion) {
        String sql = "UPDATE adopciones SET mascota_id = ?, nuevo_dueno_id = ?, fecha = ?, contrato = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, adopcion.getMascota().getId());
            stmt.setInt(2, adopcion.getNuevoDueno().getId());
            stmt.setDate(3, Date.valueOf(adopcion.getFecha()));
            stmt.setString(4, adopcion.getContrato());
            stmt.setInt(5, adopcion.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarAdopcion(Integer id) {
        String sql = "DELETE FROM adopciones WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔥 Método auxiliar para mapear ResultSet -> Adopcion
    private Adopcion mapResultSetToAdopcion(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int mascotaId = rs.getInt("mascota_id");
        int duenoId = rs.getInt("nuevo_dueno_id");
        LocalDate fecha = rs.getDate("fecha").toLocalDate();
        String contrato = rs.getString("contrato");

        // Por ahora solo creamos objetos con el id,
        // luego puedes reemplazar con un MascotaRepository y DuenoRepository reales
        Mascota mascota = new Mascota(mascotaId);
        Dueno dueno = new Dueno(duenoId, null, null, null, null, null);

        return new Adopcion(id, mascota, dueno, fecha, contrato);
    }
}
