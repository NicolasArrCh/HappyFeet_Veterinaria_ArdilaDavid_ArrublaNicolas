package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.HistorialMedico;

import java.time.LocalDate;
import java.util.List;

public interface IHistorialMedicoService {
    void agregarHistorialMedico(HistorialMedico historial) throws Exception;
    List<HistorialMedico> obtenerTodosHistorialesMedicos() throws Exception;
    HistorialMedico obtenerHistorialMedicoPorId(int id) throws Exception;
    void actualizarHistorialMedico(HistorialMedico historial) throws Exception;
    void eliminarHistorialMedico(int id) throws Exception;

    // Extras útiles para consultas:
    List<HistorialMedico> obtenerPorMascota(int mascotaId) throws Exception;
    List<HistorialMedico> obtenerPorFecha(LocalDate fecha) throws Exception;
    List<HistorialMedico> obtenerPorEventoTipo(int eventoTipoId) throws Exception;
}
