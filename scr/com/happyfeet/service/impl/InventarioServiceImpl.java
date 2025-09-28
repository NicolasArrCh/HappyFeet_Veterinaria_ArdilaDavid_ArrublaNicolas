package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Inventario;
import com.happyfeet.repository.DAO.InventarioDAO;
import com.happyfeet.repository.inter.IInventarioDAO;
import com.happyfeet.service.interfaces.IInventarioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class InventarioServiceImpl implements IInventarioService {

    private IInventarioDAO inventarioDAO = new InventarioDAO();

    @Override
    public void agregarInventario(Inventario inventario) throws Exception {
        if (inventario.getNombreProducto() == null || inventario.getNombreProducto().isEmpty()) {
            throw new Exception("El nombre del producto es obligatorio");
        }
        if (inventario.getCantidadStock() < 0) {
            throw new Exception("La cantidad en stock no puede ser negativa");
        }
        if (inventario.getStockMinimo() < 0) {
            throw new Exception("El stock mínimo no puede ser negativo");
        }
        if (inventario.getFechaVencimiento().isBefore(LocalDate.now())) {
            throw new Exception("La fecha de vencimiento debe ser futura");
        }
        inventarioDAO.agregarInventario(inventario);
    }

    @Override
    public List<Inventario> obtenerTodosInventarios() throws Exception {
        return inventarioDAO.obtenerTodosInventarios();
    }

    @Override
    public Inventario obtenerInventarioPorId(Integer id) throws Exception {
        Inventario inv = inventarioDAO.obtenerInventarioPorId(id);
        if (inv == null) {
            throw new Exception("No existe un producto en inventario con ID: " + id);
        }
        return inv;
    }

    @Override
    public void actualizarInventario(Inventario inventario) throws Exception {
        if (inventario.getId() <= 0) {
            throw new Exception("El ID del inventario no es válido");
        }
        inventarioDAO.actualizarInventario(inventario);
    }

    @Override
    public void eliminarInventario(Integer id) throws Exception {
        Inventario inv = inventarioDAO.obtenerInventarioPorId(id);
        if (inv == null) {
            throw new Exception("No se puede eliminar: producto inexistente");
        }
        inventarioDAO.eliminarInventario(id);
    }

    // 🔥 Regla de negocio: descontar stock
    @Override
    public void descontarStock(Integer id, int cantidad) throws Exception {
        Inventario inv = obtenerInventarioPorId(id);
        if (inv.getCantidadStock() < cantidad) {
            throw new Exception("Stock insuficiente para el producto: " + inv.getNombreProducto());
        }
        inv.setCantidadStock(inv.getCantidadStock() - cantidad);
        actualizarInventario(inv);
    }

    // 🔥 Validar stock suficiente
    @Override
    public boolean verificarStockDisponible(Integer id, int cantidad) throws Exception {
        Inventario inv = obtenerInventarioPorId(id);
        return inv.getCantidadStock() >= cantidad;
    }

    // 🔥 Productos próximos a vencer
    @Override
    public List<Inventario> obtenerProductosPorVencer(int dias) throws Exception {
        LocalDate limite = LocalDate.now().plusDays(dias);
        return obtenerTodosInventarios().stream()
                .filter(inv -> inv.getFechaVencimiento().isBefore(limite))
                .collect(Collectors.toList());
    }
}
