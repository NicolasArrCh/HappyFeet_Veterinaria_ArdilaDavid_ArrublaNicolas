package com.happyfeet.repository.DAO;

import com.happyfeet.util.ConexionBD;
import com.happyfeet.model.entities.Factura;
import com.happyfeet.model.entities.Inventario;
import com.happyfeet.model.entities.ItemFactura;
import com.happyfeet.model.entities.ItemFactura.*;
import com.happyfeet.repository.inter.IItemFacturaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemFacturaDAO implements IItemFacturaDAO {

    @Override
    public void agregarItemFactura(ItemFactura itemFactura) {
        String sql = "Insert into items_factura (factura_id, producto_id, servicio_descripcion, cantidad, precio_unitario, subtotal) values (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, itemFactura.getFactura().getId());
            pstmt.setInt(2, itemFactura.getProducto().getId());
            pstmt.setString(3, itemFactura.getServicioDescripcion());
            pstmt.setInt(4, itemFactura.getCantidad());
            pstmt.setDouble(5, itemFactura.getPrecioUnitario());
            pstmt.setDouble(6, itemFactura.getSubtotal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al agregar los items" + e.getMessage());
        }
    }

    @Override
    public List<ItemFactura> obtenerTodosItemFacturas() {
        List<ItemFactura> lst = new ArrayList<>();
        String sql = "select * from items_factura";

        try (Connection con = ConexionBD.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Factura factura = new Factura();
                factura.setId(rs.getInt("factura_id"));
                Inventario producto = new Inventario();
                producto .setId(rs.getInt("producto_id"));
                ItemFactura ifac = new ItemFactura(
                        rs.getInt("Id"),
                        factura,
                        producto,
                        rs.getString("servicio_descripcion"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_unitario"),
                        rs.getDouble("subtotal"));

                lst.add(ifac);
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar todos los items");
        }

        return lst;
    }

    @Override
    public ItemFactura obtenerItemFacturaPorId(Integer id) {
        ItemFactura ifac = null;

        String sql = "select * from items_factura where id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Factura factura = new Factura();
                    factura.setId(rs.getInt("factura_id"));
                    Inventario producto = new Inventario();
                    producto .setId(rs.getInt("producto_id"));
                    ifac = new ItemFactura(
                            rs.getInt("Id"),
                            factura,
                            producto,
                            rs.getString("servicio_descripcion"),
                            rs.getInt("cantidad"),
                            rs.getDouble("precio_unitario"),
                            rs.getDouble("subtotal"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar todos los items" + id);
        }

        return ifac;
    }

    @Override
    public void actualizarItemFactura(ItemFactura itemFactura) {
        String sql = "update items set factura_id = ?, producto_id = ?, servicio_descripcion = ?, cantidad = ?, precio_unitario = ?, subtotal = ?, where id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, itemFactura.getFactura().getId());
            pstmt.setInt(2, itemFactura.getProducto().getId());
            pstmt.setString(3, itemFactura.getServicioDescripcion());
            pstmt.setInt(4, itemFactura.getCantidad());
            pstmt.setDouble(5, itemFactura.getPrecioUnitario());
            pstmt.setDouble(6, itemFactura.getSubtotal());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar el item " + itemFactura);
        }
    }

    @Override
    public void eliminarItemFactura(Integer id) {
        String sql = "delete from actividades_especiales where id = ?";

        try (Connection con = ConexionBD.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar el item ID: " + id);
        }
    }
}