package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Inventario;
import java.util.List;

public interface IInventarioService {
    void agregarInventario(Inventario inventario) throws Exception;
    List<Inventario> obtenerTodosInventarios() throws Exception;
    Inventario obtenerInventarioPorId(Integer id) throws Exception;
    void actualizarInventario(Inventario inventario) throws Exception;
    void eliminarInventario(Integer id) throws Exception;

    // Extras útiles en Inventario:
    void descontarStock(Integer id, int cantidad) throws Exception;
    boolean verificarStockDisponible(Integer id, int cantidad) throws Exception;
    List<Inventario> obtenerProductosPorVencer(int dias) throws Exception;
}
