package com.happyfeet.model.entities;

import java.util.List;

public interface IProductoTipoDAO {
    void agregarProductoTipo(ProductoTipo productoTipo);
    List<ProductoTipo> obtenerTodosProductoTipos();
    ProductoTipo obtenerProductoTipoPorId(Integer id);
    void actualizarProductoTipo(ProductoTipo productoTipo);
    void eliminarProductoTipo(Integer id);
}
