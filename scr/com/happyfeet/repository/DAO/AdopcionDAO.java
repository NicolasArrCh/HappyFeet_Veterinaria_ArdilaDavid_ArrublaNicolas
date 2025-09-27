package com.happyfeet.repository.DAO;

import com.happyfeet.controller.ConexionBD;
import com.happyfeet.model.entities.Adopcion;
import com.happyfeet.model.entities.Adopcion.*;
import com.happyfeet.repository.inter.IAdopcionDAO;


import java.sql.*;
        import java.util.ArrayList;
import java.util.List;

public class AdopcionDAO implements IAdopcionDAO {

    private Connection con;

    public AdopcionDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarAdopcion(Adopcion adopcion) {
        String sql = "Insert into adopciones (mascota_id, nuevo_dueno_id, fecha, contrato) values (?, ?, ?, ?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, adopcion.getMascota().getId());
            pstmt.setInt(2, adopcion.getNuevoDueno().getId());
            pstmt.setDate(3, java.sql.Date.valueOf(adopcion.getFecha()));
            pstmt.setString(4, adopcion.getContrato());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar informacion" + e.getMessage());
        }
    }

    @Override
    public List<Adopcion> obtenerTodasAdopcion() {
        List<Adopcion> lst = new ArrayList<>();
        String sql = "select * from adopciones";

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Adopcion adp = new Adopcion(
                        rs.getInt("id"),
                        rs.getInt("mascota_id"),
                        rs.getInt("nuevo_dueno_id"),
                        rs.getDate("fecha"),
                        rs.getString("contrato"));

                lst.add(adp);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las actividades");
        }

        return lst;
    }

    @Override
    public Adopcion obtenerAdopcionPorId(Integer id) {
        Adopcion adp = null;

        String sql = "select * from adopciones where id = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    adp = new Adopcion(
                            rs.getInt("id"),
                            rs.getInt("mascota_id"),
                            rs.getInt("nuevo_dueno_id"),
                            rs.getDate("fecha"),
                            rs.getString("contrato"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas las actividades" + id);
        }

        return adp;
    }

    @Override
    public void actualizarAdopcion(Adopcion adopcion) {
        String sql = "update adopciones set mascota_id = ?, nuevo_dueno = ?, fecha = ?, contrato = ? where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, adopcion.getMascota().getId());
            pstmt.setInt(2, adopcion.getNuevoDueno().getId());
            pstmt.setDate(3, java.sql.Date.valueOf(adopcion.getFecha()));
            pstmt.setString(4, adopcion.getContrato());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la informacion " + adopcion);
        }
    }

    @Override
    public void eliminarAdopcion(Integer id) {
        String sql = "delete from adopciones where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la informacion ID: " + id);
        }
    }
}

