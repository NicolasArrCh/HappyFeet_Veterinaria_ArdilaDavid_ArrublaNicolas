package com.happyfeet.service.impl;

import com.happyfeet.model.entities.ProductoTipo;
import com.happyfeet.repository.DAO.ProductoTipoDAO;
import com.happyfeet.repository.inter.IProductoTipoDAO;
import com.happyfeet.service.interfaces.IProductoTipoService;

import java.util.List;

public class ProductoTipoServiceImpl implements IProductoTipoService {

    private IProductoTipoDAO productoTipoDAO;

    public ProductoTipoServiceImpl() {
        this.productoTipoDAO = new ProductoTipoDAO();
    }

    @Override
    public void crearProductoTipo(ProductoTipo productoTipo) throws Exception {
        if (productoTipo == null) {
            throw new Exception("El objeto ProductoTipo no puede ser nulo");
        }
        if (productoTipo.getNombre() == null || productoTipo.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del ProductoTipo es obligatorio");
        }
        productoTipoDAO.agregarProductoTipo(productoTipo);
    }

    @Override
    public List<ProductoTipo> listarProductoTipos() throws Exception {
        return productoTipoDAO.obtenerTodosProductoTipos();
    }

    @Override
    public ProductoTipo obtenerProductoTipoPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del ProductoTipo no es válido");
        }
        return productoTipoDAO.obtenerProductoTipoPorId(id);
    }

    @Override
    public void actualizarProductoTipo(ProductoTipo productoTipo) throws Exception {
        if (productoTipo == null  || productoTipo.getId() <= 0) {
            throw new Exception("El ProductoTipo debe tener un ID válido para actualizar");
        }
        if (productoTipo.getNombre() == null || productoTipo.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del ProductoTipo es obligatorio");
        }
        productoTipoDAO.actualizarProductoTipo(productoTipo);
    }

    @Override
    public void eliminarProductoTipo(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del ProductoTipo no es válido para eliminar");
        }
        productoTipoDAO.eliminarProductoTipo(id);
    }
}
