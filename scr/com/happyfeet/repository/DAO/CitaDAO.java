package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Cita;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.repository.inter.ICitaDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO implements ICitaDAO {

    @Override
    public void agregarCita(Cita cita) {
        String sql = "INSERT INTO citas (mascota_id, fecha_hora, motivo, estado_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, cita.getMascota().getId());
            stmt.setTimestamp(2, Timestamp.valueOf(cita.getFechaHora()));
            stmt.setString(3, cita.getMotivo());
            stmt.setInt(4, cita.getEstado().getId());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                cita.setId(rs.getInt(1)); // asigna el id generado
            }
        } catch (SQLException e) {
            e.printStackTrace(); // TODO: enviar a logs
        }
    }

    @Override
    public List<Cita> obtenerTodasCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT c.id, c.mascota_id, c.fecha_hora, c.motivo, c.estado_id FROM citas c";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cita cita = mapResultSetToCita(rs);
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    @Override
    public Cita obtenerCitaPorId(Integer id) {
        String sql = "SELECT c.id, c.mascota_id, c.fecha_hora, c.motivo, c.estado_id FROM citas c WHERE c.id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToCita(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarCita(Cita cita) {
        String sql = "UPDATE citas SET mascota_id = ?, fecha_hora = ?, motivo = ?, estado_id = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cita.getMascota().getId());
            stmt.setTimestamp(2, Timestamp.valueOf(cita.getFechaHora()));
            stmt.setString(3, cita.getMotivo());
            stmt.setInt(4, cita.getEstado().getId());
            stmt.setInt(5, cita.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarCita(Integer id) {
        String sql = "DELETE FROM citas WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 Helper para mapear ResultSet a objeto Cita
    private Cita mapResultSetToCita(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int mascotaId = rs.getInt("mascota_id");
        LocalDateTime fechaHora = rs.getTimestamp("fecha_hora").toLocalDateTime();
        String motivo = rs.getString("motivo");
        int estadoId = rs.getInt("estado_id");

        // ⚠️ Aquí necesitas traer la mascota y el estado desde sus repositorios
        Mascota mascota = new Mascota(mascotaId); // placeholder
        CitaEstado estado = new CitaEstado(estadoId, null); // placeholder

        return new Cita(id, mascota, fechaHora, motivo, estado);
    }
}
