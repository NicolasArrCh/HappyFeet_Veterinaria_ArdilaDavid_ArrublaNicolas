package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.HistorialMedico;
import com.happyfeet.model.entities.Mascota;
import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.repository.inter.IHistorialMedicoDAO;
import com.happyfeet.controller.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistorialMedicoDAO implements IHistorialMedicoDAO {

    @Override
    public void agregarHistorialMedico(HistorialMedico historialMedico) {
        String sql = "INSERT INTO historial_medico (mascota_id, fecha_evento, evento_tipo_id, descripcion, diagnostico, tratamiento_recomendado) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historialMedico.getMascota().getId());
            stmt.setDate(2, Date.valueOf(historialMedico.getFechaEvento()));
            stmt.setInt(3, historialMedico.getEventoTipo().getId());
            stmt.setString(4, historialMedico.getDescripcion());
            stmt.setString(5, historialMedico.getDiagnostico());
            stmt.setString(6, historialMedico.getTratamientoRecomendado());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HistorialMedico> obtenerTodosHistorialesMedicos() {
        List<HistorialMedico> historiales = new ArrayList<>();
        String sql = "SELECT * FROM historial_medico";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                HistorialMedico historial = mapearHistorial(rs);
                historiales.add(historial);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historiales;
    }

    @Override
    public HistorialMedico obtenerHistorialMedicoPorId(Integer id) {
        String sql = "SELECT * FROM historial_medico WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return mapearHistorial(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarHistorialMedico(HistorialMedico historialMedico) {
        String sql = "UPDATE historial_medico SET mascota_id = ?, fecha_evento = ?, evento_tipo_id = ?, descripcion = ?, diagnostico = ?, tratamiento_recomendado = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, historialMedico.getMascota().getId());
            stmt.setDate(2, Date.valueOf(historialMedico.getFechaEvento()));
            stmt.setInt(3, historialMedico.getEventoTipo().getId());
            stmt.setString(4, historialMedico.getDescripcion());
            stmt.setString(5, historialMedico.getDiagnostico());
            stmt.setString(6, historialMedico.getTratamientoRecomendado());
            stmt.setInt(7, historialMedico.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarHistorialMedico(Integer id) {
        String sql = "DELETE FROM historial_medico WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔥 Método privado para mapear el ResultSet a un HistorialMedico
    private HistorialMedico mapearHistorial(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int mascotaId = rs.getInt("mascota_id");
        int eventoTipoId = rs.getInt("evento_tipo_id");
        LocalDate fechaEvento = rs.getDate("fecha_evento").toLocalDate();
        String descripcion = rs.getString("descripcion");
        String diagnostico = rs.getString("diagnostico");
        String tratamiento = rs.getString("tratamiento_recomendado");

        // Por ahora solo cargamos el ID en Mascota y EventoTipo (lazy load)
        Mascota mascota = new Mascota(mascotaId);
        EventoTipo eventoTipo = new EventoTipo(eventoTipoId, null);

        return new HistorialMedico(id, mascota, fechaEvento, eventoTipo, descripcion, diagnostico, tratamiento);
    }
}
