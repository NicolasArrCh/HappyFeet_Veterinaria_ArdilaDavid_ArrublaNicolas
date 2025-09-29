package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Inventario;

import java.util.List;

public interface IInventarioDAO {
    void agregarInventario(Inventario inventario);
    List<Inventario> obtenerTodosInventarios();
    Inventario obtenerInventarioPorId(Integer id); 
    void actualizarInventario(Inventario inventario);   
    void eliminarInventario(Integer id);
}
