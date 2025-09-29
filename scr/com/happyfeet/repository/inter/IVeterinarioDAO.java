package com.happyfeet.repository.inter;

import com.happyfeet.model.entities.Veterinario;

import java.util.List;

public interface IVeterinarioDAO {
    void agregarVeterinario(Veterinario veterinario);
    List<Veterinario> obtenerTodasVeterinario();
    Veterinario obtenerVeterinarioPorId(Integer id);
    void actualizarVeterinario(Veterinario veterinario);
    void eliminarVeterinario(Integer id);
}
