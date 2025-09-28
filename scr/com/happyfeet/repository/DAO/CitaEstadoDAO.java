package com.happyfeet.repository.DAO;

import com.happyfeet.controller.ConexionBD;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.model.entities.CitaEstado.*;
import com.happyfeet.repository.inter.ICitaEstadoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CitaEstadoDAO implements ICitaEstadoDAO {

    private Connection con;

    public CitaEstadoDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarCitaEstado(CitaEstado citaEstado) {
        String sql = "Insert into cita_estados (nombre) values (?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, citaEstado.getNombre());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar los nombres" + e.getMessage());
        }
    }

    @Override
    public List<CitaEstado> obtenerTodasCitaEstados() {
        List<CitaEstado> lst = new ArrayList<>();
        String sql = "select * from cita_estados";

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                CitaEstado ae = new CitaEstado(
                        rs.getInt("Id"),
                        rs.getString("nombre"));

                lst.add(ae);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las actividades");
        }

        return lst;
    }

    @Override
    public CitaEstado obtenerCitaEstadoPorId(Integer id) {
        CitaEstado ce = null;

        String sql = "select * from actividades_especiales where id = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ce = new CitaEstado(
                            rs.getInt("id"),
                            rs.getString("descripcion"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas los nombres" + id);
        }

        return ce;
    }

    @Override
    public void actualizarCitaEstado(CitaEstado citaEstado) {
        String sql = "update cita_estados set nombre = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, citaEstado.getNombre());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el nombre " + citaEstado);
        }
    }

    @Override
    public void eliminarCitaEstado(Integer id) {
        String sql = "delete from cita_estados where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el nombre ID: " + id);
        }
    }
}