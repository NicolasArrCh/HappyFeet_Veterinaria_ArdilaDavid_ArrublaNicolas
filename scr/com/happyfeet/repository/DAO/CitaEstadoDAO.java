package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.CitaEstado;
import com.happyfeet.repository.inter.ICitaEstadoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CitaEstadoDAO implements ICitaEstadoDAO {

    @Override
    public void agregarCitaEstado(CitaEstado citaEstado) {
        String sql = "Insert into cita_estados (nombre) values (?)";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, citaEstado.getNombre());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    citaEstado.setId(rs.getInt(1));
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("❌ Ya existe un estado con ese nombre: " + citaEstado.getNombre());
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar el estado: " + e.getMessage(), e);
        }
    }

    @Override
    public List<CitaEstado> obtenerTodasCitaEstados() {
        List<CitaEstado> lst = new ArrayList<>();
        String sql = "select * from cita_estados";

        try(Connection con = ConexionBD.getConnection();
            Statement stmt = con.createStatement();
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

        String sql = "select * from cita_estados set nombre = ? where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ce = new CitaEstado(
                            rs.getInt("id"),
                            rs.getString("nombre"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al al buscar estdo con ID: " + id);
        }

        return ce;
    }

    @Override
    public void actualizarCitaEstado(CitaEstado citaEstado) {
        String sql = "update cita_estados set nombre = ? WHERE id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, citaEstado.getNombre());
            pstmt.setInt(2, citaEstado.getId());
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("❌ Ya existe un estado con ese nombre: " + citaEstado.getNombre());
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el estado con ID: " + citaEstado.getId(), e);
        }
    }

    @Override
    public void eliminarCitaEstado(Integer id) {
        String sql = "delete from cita_estados where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el nombre ID: " + id);
        }
    }
}