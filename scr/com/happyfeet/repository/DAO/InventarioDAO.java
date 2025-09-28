package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Inventario;
import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.repository.inter.IInventarioDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO implements IInventarioDAO {

    @Override
    public void agregarInventario(Inventario inventario) {
        String sql = "INSERT INTO inventario (nombre_producto, producto_tipo_id, descripcion, fabricante, lote, cantidad_stock, stock_minimo, fecha_vencimiento, precio_venta) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getNombreProducto());
            stmt.setInt(2, inventario.getProductoTipo().getId()); // asumiendo que ProductoTipo tiene id
            stmt.setString(3, inventario.getDescripcion());
            stmt.setString(4, inventario.getFabricante());
            stmt.setString(5, inventario.getLote());
            stmt.setInt(6, inventario.getCantidadStock());
            stmt.setInt(7, inventario.getStockMinimo());
            stmt.setDate(8, Date.valueOf(inventario.getFechaVencimiento()));
            stmt.setDouble(9, inventario.getPrecioVenta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // luego lo mandamos a logs
        }
    }

    @Override
    public List<Inventario> obtenerTodosInventarios() {
        List<Inventario> lista = new ArrayList<>();
        String sql = "SELECT * FROM inventario";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Inventario inventario = mapResultSetToInventario(rs);
                lista.add(inventario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Inventario obtenerInventarioPorId(Integer id) {
        String sql = "SELECT * FROM inventario WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToInventario(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizarInventario(Inventario inventario) {
        String sql = "UPDATE inventario SET nombre_producto = ?, producto_tipo_id = ?, descripcion = ?, fabricante = ?, lote = ?, cantidad_stock = ?, stock_minimo = ?, fecha_vencimiento = ?, precio_venta = ? " +
                "WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, inventario.getNombreProducto());
            stmt.setInt(2, inventario.getProductoTipo().getId());
            stmt.setString(3, inventario.getDescripcion());
            stmt.setString(4, inventario.getFabricante());
            stmt.setString(5, inventario.getLote());
            stmt.setInt(6, inventario.getCantidadStock());
            stmt.setInt(7, inventario.getStockMinimo());
            stmt.setDate(8, Date.valueOf(inventario.getFechaVencimiento()));
            stmt.setDouble(9, inventario.getPrecioVenta());
            stmt.setInt(10, inventario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarInventario(Integer id) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔥 Helper privado para convertir un ResultSet en Inventario
    private Inventario mapResultSetToInventario(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombreProducto = rs.getString("nombre_producto");
        int productoTipoId = rs.getInt("producto_tipo_id");
        String descripcion = rs.getString("descripcion");
        String fabricante = rs.getString("fabricante");
        String lote = rs.getString("lote");
        int cantidadStock = rs.getInt("cantidad_stock");
        int stockMinimo = rs.getInt("stock_minimo");
        LocalDate fechaVencimiento = rs.getDate("fecha_vencimiento").toLocalDate();
        double precioVenta = rs.getDouble("precio_venta");

        // ⚠️ Ojo: aquí depende de cómo manejes ProductoTipo (si tienes un Repository o lo cargas después)
        ProductoTipo productoTipo = new ProductoTipo(productoTipoId, ""); // temporal solo con id

        return new Inventario(id, nombreProducto, productoTipo, descripcion, fabricante, lote, cantidadStock, stockMinimo, fechaVencimiento, precioVenta);
    }
}
