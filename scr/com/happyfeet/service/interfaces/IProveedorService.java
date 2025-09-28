package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Proveedor;
import java.util.List;

public interface IProveedorService {
    void registrarProveedor(Proveedor proveedor) throws Exception;
    List<Proveedor> listarProveedores() throws Exception;
    Proveedor buscarProveedorPorId(Integer id) throws Exception;
    void actualizarProveedor(Proveedor proveedor) throws Exception;
    void eliminarProveedor(Integer id) throws Exception;
}
