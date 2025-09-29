package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Especie;
import com.happyfeet.repository.inter.IEspecieDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspeciesDAO implements IEspecieDAO {

    @Override
    public void agregarEspecie(Especie especie) {
        String sql = "INSERT INTO especies (nombre) VALUES (?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, especie.getNombre());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    especie.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // luego mandamos a log
        }
    }

    @Override
    public List<Especie> obtenerTodasEspecies() {
        List<Especie> especies = new ArrayList<>();
        String sql = "SELECT * FROM especies";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Especie especie = new Especie(
                        rs.getInt("id"),
                        rs.getString("nombre")
                );
                especies.add(especie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especies;
    }

    @Override
    public Especie obtenerEspeciePorId(Integer id) {
        String sql = "SELECT * FROM especies WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Especie(
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
    public void actualizarEspecie(Especie especie) {
        String sql = "UPDATE especies SET nombre = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, especie.getNombre());
            stmt.setInt(2, especie.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEspecie(Integer id) {
        String sql = "DELETE FROM especies WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

