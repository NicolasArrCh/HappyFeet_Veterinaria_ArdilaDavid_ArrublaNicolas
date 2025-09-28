package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.EventoTipo;
import com.happyfeet.repository.inter.IEventoTipoDAO;
import com.happyfeet.controller.ConexionBD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoTipoDAO implements IEventoTipoDAO {

    @Override
    public void agregarEventoTipo(EventoTipo eventoTipo) {
        String sql = "INSERT INTO evento_tipos (nombre) VALUES (?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eventoTipo.getNombre());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // luego lo reemplazamos por logs
        }
    }

    @Override
    public List<EventoTipo> obtenerTodosEventoTipos() {
        List<EventoTipo> lista = new ArrayList<>();
        String sql = "SELECT * FROM evento_tipos";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                EventoTipo et = new EventoTipo(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                lista.add(et);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public EventoTipo obtenerEventoTipoPorId(Integer id) {
        String sql = "SELECT * FROM evento_tipos WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new EventoTipo(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarEventoTipo(EventoTipo eventoTipo) {
        String sql = "UPDATE evento_tipos SET nombre = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eventoTipo.getNombre());
            stmt.setInt(2, eventoTipo.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEventoTipo(Integer id) {
        String sql = "DELETE FROM evento_tipos WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
