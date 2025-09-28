package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Dueno;
import com.happyfeet.model.entities.PuntosCliente;
import com.happyfeet.repository.inter.IPuntosClienteDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PuntosClienteDAO implements IPuntosClienteDAO {

    @Override
    public void agregarPuntosCliente(PuntosCliente puntosCliente) {
        String sql = "INSERT INTO puntos_clientes (dueno_id, puntos) VALUES (?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, puntosCliente.getDueno().getId());
            stmt.setInt(2, puntosCliente.getPuntos());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // luego lo mandamos a logs
        }
    }

    @Override
    public List<PuntosCliente> obtenerTodasPuntosCliente() {
        List<PuntosCliente> lista = new ArrayList<>();
        String sql = "SELECT pc.id, pc.puntos, d.id AS dueno_id, d.nombreCompleto, d.documentoIdentidad, d.direccion, d.telefono, d.email " +
                "FROM puntos_clientes pc " +
                "INNER JOIN duenos d ON pc.dueno_id = d.id";

        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dueno dueno = new Dueno(
                        rs.getInt("dueno_id"),
                        rs.getString("nombreCompleto"),
                        rs.getString("documentoIdentidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );

                PuntosCliente pc = new PuntosCliente(
                        rs.getInt("id"),
                        dueno,
                        rs.getInt("puntos")
                );
                lista.add(pc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public PuntosCliente obtenerProveedorPorId(Integer id) {
        String sql = "SELECT pc.id, pc.puntos, d.id AS dueno_id, d.nombreCompleto, d.documentoIdentidad, d.direccion, d.telefono, d.email " +
                "FROM puntos_clientes pc " +
                "INNER JOIN duenos d ON pc.dueno_id = d.id " +
                "WHERE pc.id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Dueno dueno = new Dueno(
                        rs.getInt("dueno_id"),
                        rs.getString("nombreCompleto"),
                        rs.getString("documentoIdentidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );

                return new PuntosCliente(
                        rs.getInt("id"),
                        dueno,
                        rs.getInt("puntos")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarPuntosCliente(PuntosCliente puntosCliente) {
        String sql = "UPDATE puntos_clientes SET dueno_id = ?, puntos = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, puntosCliente.getDueno().getId());
            stmt.setInt(2, puntosCliente.getPuntos());
            stmt.setInt(3, puntosCliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPuntosCliente(Integer id) {
        String sql = "DELETE FROM puntos_clientes WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
