package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Factura;
import com.happyfeet.repository.DAO.FacturaDAO;
import com.happyfeet.repository.inter.IFacturaDAO;
import com.happyfeet.service.interfaces.IFacturaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FacturaServiceImpl implements IFacturaService {

    private IFacturaDAO facturaDAO = new FacturaDAO();

    @Override
    public void agregarFactura(Factura factura) throws Exception {
        if (factura.getDueno() == null || factura.getDueno().getId() <= 0) {
            throw new Exception("La factura debe estar asociada a un dueño válido");
        }
        if (factura.getFechaEmision() == null) {
            throw new Exception("La fecha de emisión es obligatoria");
        }
        if (factura.getTotal() <= 0) {
            throw new Exception("El total de la factura debe ser mayor a 0");
        }
        facturaDAO.agregarFactura(factura);
    }

    @Override
    public List<Factura> obtenerTodasFacturas() throws Exception {
        return facturaDAO.obtenerTodasFacturas();
    }

    @Override
    public Factura obtenerFacturaPorId(int id) throws Exception {
        Factura factura = facturaDAO.obtenerFacturaPorId(id);
        if (factura == null) {
            throw new Exception("No existe una factura con ID: " + id);
        }
        return factura;
    }

    @Override
    public void actualizarFactura(Factura factura) throws Exception {
        if (factura.getId() <= 0) {
            throw new Exception("El ID de la factura no es válido");
        }
        if (factura.getTotal() <= 0) {
            throw new Exception("El total de la factura debe ser mayor a 0");
        }
        facturaDAO.actualizarFactura(factura);
    }

    @Override
    public void eliminarFactura(int id) throws Exception {
        Factura factura = facturaDAO.obtenerFacturaPorId(id);
        if (factura == null) {
            throw new Exception("No se puede eliminar: la factura no existe");
        }
        facturaDAO.eliminarFactura(id);
    }

    @Override
    public List<Factura> obtenerPorDueno(int duenoId) throws Exception {
        return facturaDAO.obtenerTodasFacturas().stream()
                .filter(f -> f.getDueno() != null && f.getDueno().getId() == duenoId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Factura> obtenerPorFecha(LocalDateTime fecha) throws Exception {
        return facturaDAO.obtenerTodasFacturas().stream()
                .filter(f -> f.getFechaEmision() != null &&
                        f.getFechaEmision().toLocalDate().equals(fecha.toLocalDate()))
                .collect(Collectors.toList());
    }
}