package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Veterinario;
import com.happyfeet.repository.inter.IVeterinarioDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioDAO implements IVeterinarioDAO {

    @Override
    public void agregarVeterinario(Veterinario veterinario) {
        String sql = "Insert into veterinarios (nombre_completo, documento_identidad, especialidad, telefono, email) values (?, ?, ?, ?, ?)";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, veterinario.getNombreCompleto());
            pstmt.setString(2, veterinario.getDocumentoIdentidad());
            pstmt.setString(3, veterinario.getEspecialidad());
            pstmt.setString(4, veterinario.getTelefono());
            pstmt.setString(5, veterinario.getEmail());

            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar los veterinarios" + e.getMessage());
        }
    }

    @Override
    public List<Veterinario> obtenerTodasVeterinario() {
        List<Veterinario> lst = new ArrayList<>();
        String sql = "select * from veterinarios";

        try(Connection con = ConexionBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Veterinario vt = new Veterinario(
                        rs.getInt("Id"),
                        rs.getString("nombre_completo"),
                        rs.getString("documento_identidad"),
                        rs.getString("especialidad"),
                        rs.getString("telefono"),
                        rs.getString("email"));

                lst.add(vt);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todos los veterinarios");
        }

        return lst;
    }

    @Override
    public Veterinario obtenerVeterinarioPorId(Integer id) {
        Veterinario vt = null;

        String sql = "select * from veterinarios where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vt = new Veterinario(
                            rs.getInt("id"),
                            rs.getString("nombre_completo"),
                            rs.getString("documento_identidad"),
                            rs.getString("especialidad"),
                            rs.getString("telefono"),
                            rs.getString("email"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todos los veterinarios" + id);
        }

        return vt;
    }

    @Override
    public void actualizarVeterinario(Veterinario veterinario) {
        String sql = "update veterinarios set nombre_completo = ?, documento_identidad = ?, especialidad = ?, telefono = ?, email = ?, where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, veterinario.getNombreCompleto());
            pstmt.setString(2, veterinario.getDocumentoIdentidad());
            pstmt.setString(3, veterinario.getEspecialidad());
            pstmt.setString(4, veterinario.getTelefono());
            pstmt.setString(5, veterinario.getEmail());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el veterinario " + veterinario);
        }
    }

    @Override
    public void eliminarVeterinario(Integer id) {
        String sql = "delete from veterinarios where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el veterinario ID: " + id);
        }
    }
}