package com.happyfeet.service.interfaces;

import com.happyfeet.model.entities.Usuario;
import java.util.List;

public interface IUsuarioService {
    void registrarUsuario(Usuario usuario) throws Exception;
    List<Usuario> listarUsuarios() throws Exception;
    Usuario buscarUsuarioPorId(Integer id) throws Exception;
    void actualizarUsuario(Usuario usuario) throws Exception;
    void eliminarUsuario(Integer id) throws Exception;

    // Extra: autenticación
    Usuario autenticar(String nombreUsuario, String contrasena) throws Exception;
}
