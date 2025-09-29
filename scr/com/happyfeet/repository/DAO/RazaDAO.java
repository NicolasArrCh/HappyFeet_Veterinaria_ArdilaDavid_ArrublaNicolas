package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Especie;
import com.happyfeet.model.entities.Raza;
import com.happyfeet.repository.inter.IRazaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazaDAO implements IRazaDAO {

    @Override
    public void agregarRaza(Raza raza) {
        String sql = "Insert into razas (nombre, especie_id) values (?, ?)";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, raza.getNombre());
            pstmt.setInt(2, raza.getEspecie().getId());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    raza.setId(rs.getInt(1));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar la raza" + e.getMessage());
        }
    }

    @Override
    public List<Raza> obtenerTodasRazas() {
        List<Raza> lst = new ArrayList<>();
        String sql = "select * from razas";

        try(Connection con = ConexionBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Especie especie = new Especie();
                especie.setId(rs.getInt("especie_id"));
                Raza rz = new Raza(
                        rs.getInt("Id"),
                        rs.getString("nombre"),
                        especie);

                lst.add(rz);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las actividades");
        }

        return lst;
    }

    @Override
    public Raza obtenerRazaPorId(Integer id) {
        Raza rz = null;

        String sql = "select * from razas where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Especie especie = new Especie();
                    especie.setId(rs.getInt("especie_id"));
                    rz = new Raza(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            especie);
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas las razas" + id);
        }

        return rz;
    }

    @Override
    public void actualizarRaza(Raza raza) {
        String sql = "update razas set especie_id = ?, nombre = ?, where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, raza.getNombre());
            pstmt.setInt(2, raza.getEspecie().getId());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la informacion " + raza);
        }
    }

    @Override
    public void eliminarRaza(Integer id) {
        String sql = "delete from razas where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la informacion ID: " + id);
        }
    }
}

