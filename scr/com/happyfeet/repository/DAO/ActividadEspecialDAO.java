package com.happyfeet.repository.DAO;

import com.happyfeet.controller.ConexionBD;
import com.happyfeet.model.entities.ActividadEspecial;
import com.happyfeet.model.entities.ActividadEspecial.*;
import com.happyfeet.repository.inter.IActividadEspecialDAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActividadEspecialDAO implements IActividadEspecialDAO {

    private Connection con;

    public ActividadEspecialDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarActividadEspecial(ActividadEspecial actividadEspecial) {
        String sql = "Insert into actividades_especiales (tipo, descripcion, fecha) values (?, ?, ?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, actividadEspecial.getTipo().name());
            pstmt.setString(2, actividadEspecial.getDescripcion());
            pstmt.setDate(3, new java.sql.Date(actividadEspecial.getFecha().getTime()));
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar las actividades" + e.getMessage());
        }
    }

    @Override
    public List<ActividadEspecial> obtenerTodasActividadEspecial() {
        List<ActividadEspecial> lst = new ArrayList<>();
        String sql = "select * from actividades_especiales";

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ActividadEspecial ae = new ActividadEspecial(
                        rs.getInt("Id"),
                        TipoActividad.valueOf(rs.getString("tipo")),
                        rs.getString("descripcion"),
                        rs.getDate("fecha"));

                lst.add(ae);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las actividades");
        }

        return lst;
    }

    @Override
    public ActividadEspecial obtenerActividadEspecialPorId(Integer id) {
        ActividadEspecial ae = null;

        String sql = "select * from actividades_especiales where id = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ae = new ActividadEspecial(
                            rs.getInt("id"),
                            TipoActividad.valueOf(rs.getString("tipo")),
                            rs.getString("descripcion"),
                            rs.getDate("fecha"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas las actividades" + id);
        }

        return ae;
    }

    @Override
    public void actualizarActividadEspecial(ActividadEspecial actividadEspecial) {
        String sql = "update actividades_especiales set tipo = ?, descripcion = ?, fecha = ?, where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, actividadEspecial.getTipo().name());
            pstmt.setString(2, actividadEspecial.getDescripcion());
            pstmt.setDate(3, new java.sql.Date(actividadEspecial.getFecha().getTime()));
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la actividad " + actividadEspecial);
        }
    }

    @Override
    public void eliminarActividadEspecial(Integer id) {
        String sql = "delete from actividades_especiales where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la actividad ID: " + id);
        }
    }
}

