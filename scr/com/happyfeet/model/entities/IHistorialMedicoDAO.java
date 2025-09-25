package com.happyfeet.model.entities;

import java.util.List;

public interface IHistorialMedicoDAO {
    void agregarHistorialMedico(HistorialMedico historialMedico);
    List<HistorialMedico> obtenerTodosHistorialesMedicos();
    HistorialMedico obtenerHistorialMedicoPorId(Integer id);
    void actualizarHistorialMedico(HistorialMedico historialMedico);
    void eliminarHistorialMedico(Integer id);
}
