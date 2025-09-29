package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Factura;
import com.happyfeet.model.entities.Dueno;
import com.happyfeet.repository.inter.IFacturaDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO implements IFacturaDAO {

    private Connection con;

    public FacturaDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarFactura(Factura factura) {
        String sql = "Insert into facturas (dueno_id, fecha_emision, total) values (?, ?, ?)";

        try(PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setInt(1, factura.getDueno().getId());
            pstmt.setDate(2, Date.valueOf(factura.getFechaEmision().toLocalDate()));
            pstmt.setDouble(3, factura.getTotal());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    factura.setId(rs.getInt(1));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar las facturas" + e.getMessage());
        }
    }

    @Override
    public List<Factura> obtenerTodasFacturas() {
        List<Factura> lst = new ArrayList<>();
        String sql = "select * from facturas";

        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dueno dueno = new Dueno();
                dueno.setId(rs.getInt("dueno_id"));
                LocalDateTime fechaEmision = null;
                Timestamp ts = rs.getTimestamp("fecha_emision");
                if (ts != null) {
                    fechaEmision = ts.toLocalDateTime();
                }
                Factura fac = new Factura(
                        rs.getInt("Id"),
                        dueno,
                        fechaEmision,
                        rs.getDouble("total"));

                lst.add(fac);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todas las facturas");
        }

        return lst;
    }

    @Override
    public Factura obtenerFacturaPorId(Integer id) {
        Factura fac = null;

        String sql = "select * from facturas where id = ?";

        try(PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Dueno dueno = new Dueno();
                    dueno.setId(rs.getInt("dueno_id"));
                    LocalDateTime fechaEmision = null;
                    Timestamp ts = rs.getTimestamp("fecha_emision");
                    if (ts != null) {
                        fechaEmision = ts.toLocalDateTime();
                    }
                    fac = new Factura(
                            rs.getInt("Id"),
                            dueno,
                            fechaEmision,
                            rs.getDouble("total"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas las facturas" + id);
        }

        return fac;
    }

    @Override
    public void actualizarFactura(Factura factura) {
        String sql = "update facturas set dueno_id = ?, fecha_emision = ?, total = ?, where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, factura.getDueno().getId());
            pstmt.setDate(2, Date.valueOf(factura.getFechaEmision().toLocalDate()));
            pstmt.setDouble(3, factura.getTotal());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar la factura " + factura);
        }
    }

    @Override
    public void eliminarFactura(Integer id) {
        String sql = "delete from actividades_especiales where id = ?";

        try(PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la actividad ID: " + id);
        }
    }
}