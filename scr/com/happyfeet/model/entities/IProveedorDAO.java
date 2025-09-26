package com.happyfeet.model.entities;

import java.util.List;

public interface IProveedorDAO {
    void agregarProveedor(Proveedor proveedor);
    List<Proveedor> obtenerTodasProveedor();
    Proveedor obtenerProveedorPorId(Integer id);
    void actualizarProveedor(Proveedor proveedor);
    void eliminarProveedor(Integer id);
}
