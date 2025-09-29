package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.repository.inter.IDuenoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DuenoDAO implements IDuenoDAO {

    @Override
    public void agregarDueno(Dueno dueno) {
        String sql = "Insert into duenos (nombre_completo, documento_identidad, direccion, telefono, email) values (?, ?, ?, ?, ?)";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, dueno.getNombreCompleto());
            pstmt.setString(2, dueno.getDocumentoIdentidad());
            pstmt.setString(3, dueno.getDireccion());
            pstmt.setString(4, dueno.getTelefono());
            pstmt.setString(5, dueno.getEmail());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    dueno.setId(rs.getInt(1));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar los duenos" + e.getMessage());
        }
    }

    @Override
    public List<Dueno> obtenerTodosDuenos() {
        List<Dueno> lst = new ArrayList<>();
        String sql = "select * from duenos";

        try(Connection con = ConexionBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dueno due = new Dueno(
                        rs.getInt("Id"),
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("direccion"),
                        rs.getString("telefono"),
                        rs.getString("email"));

                lst.add(due);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todos los duenos" + e.getMessage());
        }

        return lst;
    }

    @Override
    public Dueno obtenerDuenoPorId(Integer id) {
        Dueno due = null;

        String sql = "select * from duenos where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    due = new Dueno(
                            rs.getInt("id"),
                            rs.getString("nombre_completo"),
                            rs.getString("documento_identidad"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todos los duenos" + id);
        }

        return due;
    }

    @Override
    public void actualizarDueno(Dueno dueno) {
        String sql = "update duenos set nombre_completo = ?, documento_identidad = ?, direccion = ?, telefono = ?, email = ?, where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, dueno.getNombreCompleto());
            pstmt.setString(2, dueno.getDocumentoIdentidad());
            pstmt.setString(3, dueno.getDireccion());
            pstmt.setString(4, dueno.getTelefono());
            pstmt.setString(5, dueno.getEmail());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el dueno " + dueno);
        }
    }

    @Override
    public void eliminarDueno(Integer id) {
        String sql = "delete from duenos where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el dueno ID: " + id);
        }
    }
}