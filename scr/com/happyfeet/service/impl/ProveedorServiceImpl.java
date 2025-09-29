package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Proveedor;
import com.happyfeet.repository.DAO.ProveedorDAO;
import com.happyfeet.repository.inter.IProveedorDAO;
import com.happyfeet.service.interfaces.IProveedorService;

import java.util.List;

public class ProveedorServiceImpl implements IProveedorService {

    private final IProveedorDAO proveedorDAO = new ProveedorDAO();

    @Override
    public void registrarProveedor(Proveedor proveedor) throws Exception {
        if (proveedor == null) {
            throw new Exception("El proveedor no puede ser nulo");
        }
        if (proveedor.getNombre() == null || proveedor.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del proveedor es obligatorio");
        }
        if (proveedor.getTelefono() == null || proveedor.getTelefono().trim().isEmpty()) {
            throw new Exception("El teléfono del proveedor es obligatorio");
        }
        if (proveedor.getEmail() == null || proveedor.getEmail().trim().isEmpty()) {
            throw new Exception("El email del proveedor es obligatorio");
        }

        // Aquí podrías meter validaciones más avanzadas, por ejemplo regex para email 📧
        proveedorDAO.agregarProveedor(proveedor);
    }

    @Override
    public List<Proveedor> listarProveedores() throws Exception {
        return proveedorDAO.obtenerTodasProveedor();
    }

    @Override
    public Proveedor buscarProveedorPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de proveedor no es válido");
        }
        Proveedor proveedor = proveedorDAO.obtenerProveedorPorId(id);
        if (proveedor == null) {
            throw new Exception("Proveedor no encontrado con ID: " + id);
        }
        return proveedor;
    }

    @Override
    public void actualizarProveedor(Proveedor proveedor) throws Exception {
        if (proveedor == null  || proveedor.getId() <= 0) {
            throw new Exception("El proveedor o su ID no son válidos");
        }
        proveedorDAO.actualizarProveedor(proveedor);
    }

    @Override
    public void eliminarProveedor(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID del proveedor no es válido");
        }
        proveedorDAO.eliminarProveedor(id);
    }
}
