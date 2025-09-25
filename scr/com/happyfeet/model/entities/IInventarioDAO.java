package com.happyfeet.model.entities;

import java.util.List;

public interface IInventarioDAO {
    void agregarInventario(Inventario inventario);
    List<Inventario> obtenerTodosInventarios();
    Inventario obtenerInventarioPorId(Integer id); 
    void actualizarInventario(Inventario inventario);   
    void eliminarInventario(Integer id);
}
