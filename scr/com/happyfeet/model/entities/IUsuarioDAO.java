package com.happyfeet.model.entities;

import java.util.List;

public interface IUsuarioDAO {
    void agregarUsuario(Usuario usuario);
    List<Usuario> obtenerTodasUsuario();
    Usuario obtenerUsuarioPorId(Integer id);
    void actualizarUsuario(Usuario usuario);
    void eliminarUsuario(Integer id);
}
