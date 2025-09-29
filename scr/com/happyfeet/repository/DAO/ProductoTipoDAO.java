package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.repository.inter.IProductoTipoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoTipoDAO implements IProductoTipoDAO {

    private Connection con;

    public ProductoTipoDAO() {
        con = ConexionBD.getConnection();
    }

    @Override
    public void agregarProductoTipo(ProductoTipo productoTipo) {
        String sql = "Insert into producto_tipos (nombre) values (?)";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(2, productoTipo.getNombre());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    productoTipo.setId(rs.getInt(1));
                }
            }
        }catch (SQLException e) {
            throw new RuntimeException("Error al agregar los productos" + e.getMessage());
        }
    }

    @Override
    public List<ProductoTipo> obtenerTodosProductoTipos() {
        List<ProductoTipo> lst = new ArrayList<>();
        String sql = "select * from producto_tipos";

        try(Connection con = ConexionBD.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                ProductoTipo pta = new ProductoTipo(
                        rs.getInt("Id"),
                        rs.getString("nombre"));

                lst.add(pta);
            }
        }catch (SQLException e){
            System.out.println("Error al consultar todos los productos");
        }

        return lst;
    }

    @Override
    public ProductoTipo obtenerProductoTipoPorId(Integer id) {
        ProductoTipo pta = null;

        String sql = "select * from producto_tipos where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);){

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pta = new ProductoTipo(
                            rs.getInt("id"),
                            rs.getString("nombre"));
                }
            }
        }catch (SQLException e){
            throw new RuntimeException("Error al consultar todas los productos" + id);
        }

        return pta;
    }

    @Override
    public void actualizarProductoTipo(ProductoTipo productoTipo) {
        String sql = "update producto_tipo set nombre = ?, where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1, productoTipo.getNombre());
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el producto " + productoTipo);
        }
    }

    @Override
    public void eliminarProductoTipo(Integer id) {
        String sql = "delete from producto_tipos where id = ?";

        try(Connection con = ConexionBD.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el producto ID: " + id);
        }
    }
}