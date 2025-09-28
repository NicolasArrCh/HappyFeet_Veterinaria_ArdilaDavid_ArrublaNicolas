package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Veterinario;
import java.util.List;

public interface IVeterinarioService {
    void registrarVeterinario(Veterinario veterinario) throws Exception;
    List<Veterinario> listarVeterinarios() throws Exception;
    Veterinario buscarVeterinarioPorId(Integer id) throws Exception;
    void actualizarVeterinario(Veterinario veterinario) throws Exception;
    void eliminarVeterinario(Integer id) throws Exception;
}
