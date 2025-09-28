package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Usuario;
import com.happyfeet.repository.inter.IUsuarioDAO;
import com.happyfeet.model.enums.Rol;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IUsuarioDAO {

    private Connection con;

    public UsuarioDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        String sql = "Insert into usuarios (nombre_usuario, contrasena, rol) values (?, ?, ?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());
            pstmt.setString(3, usuario.getRol().name());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar al usuario" + e.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerTodasUsuario() {
        List<Usuario> lst = new ArrayList<>();
        String sql = "select * from usuarios";

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario us = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre_usuario"),
                        rs.getString("contrasena"),
                        Rol.valueOf(rs.getString("rol").toUpperCase()));

                lst.add(us);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las actividades");
        }

        return lst;
    }

    @Override
    public Usuario obtenerUsuarioPorId(Integer id) {
        Usuario us = null;

        String sql = "select * from usurios where id = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    us = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre_usuario"),
                            rs.getString("contrasena"),
                            Rol.valueOf(rs.getString("rol").toUpperCase()));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todos los usuarios" + id);
        }

        return us;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        String sql = "update usuarios set nombre_usuario = ?, contrasena = ?, rol = ?, where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, usuario.getNombreUsuario());
            pstmt.setString(2, usuario.getContrasena());
            pstmt.setString(3, usuario.getRol().name());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la actividad " + usuario);
        }
    }

    @Override
    public void eliminarUsuario(Integer id) {
        String sql = "delete from usuarios where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar al usuario ID: " + id);
        }
    }
}