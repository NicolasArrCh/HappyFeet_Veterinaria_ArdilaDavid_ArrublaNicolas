package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Mascota;
import com.happyfeet.repository.DAO.MascotaDAO;
import com.happyfeet.repository.inter.IMascotaDAO;
import com.happyfeet.service.interfaces.IMascotaService;

import java.time.LocalDate;
import java.util.List;

public class MascotaServiceImpl implements IMascotaService {

    private IMascotaDAO mascotaDAO = new MascotaDAO();

    @Override
    public void registrarMascota(Mascota mascota) throws Exception {
        if (mascota.getNombre() == null || mascota.getNombre().isEmpty()) {
            throw new Exception("El nombre de la mascota es obligatorio.");
        }
        if (mascota.getDuenoId() <= 0) {
            throw new Exception("La mascota debe tener un dueño válido.");
        }
        if (mascota.getFechaNacimiento() != null && mascota.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new Exception("La fecha de nacimiento no puede ser en el futuro.");
        }

        mascotaDAO.agregarMascota(mascota);
    }

    @Override
    public List<Mascota> listarMascotas() throws Exception {
        return mascotaDAO.obtenerTodasMascotas();
    }

    @Override
    public Mascota buscarMascotaPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de la mascota no es válido.");
        }
        Mascota mascota = mascotaDAO.obtenerMascotaPorId(id);
        if (mascota == null) {
            throw new Exception("No se encontró ninguna mascota con el ID: " + id);
        }
        return mascota;
    }

    @Override
    public void actualizarMascota(Mascota mascota) throws Exception {
        if (mascota.getId() <= 0) {
            throw new Exception("El ID de la mascota no es válido para actualizar.");
        }
        mascotaDAO.actualizarMascota(mascota);
    }

    @Override
    public void eliminarMascota(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID de la mascota no es válido para eliminar.");
        }
        mascotaDAO.eliminarMascota(id);
    }
}
