package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.ProductoTipo;
import java.util.List;

public interface IProductoTipoService {
    void crearProductoTipo(ProductoTipo productoTipo) throws Exception;
    List<ProductoTipo> listarProductoTipos() throws Exception;
    ProductoTipo obtenerProductoTipoPorId(Integer id) throws Exception;
    void actualizarProductoTipo(ProductoTipo productoTipo) throws Exception;
    void eliminarProductoTipo(Integer id) throws Exception;
}
