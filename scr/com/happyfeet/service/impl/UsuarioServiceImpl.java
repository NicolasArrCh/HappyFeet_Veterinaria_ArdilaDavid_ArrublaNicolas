package com.happyfeet.service.impl;

import com.happyfeet.model.entities.Usuario;
import com.happyfeet.repository.DAO.UsuarioDAO;
import com.happyfeet.repository.inter.IUsuarioDAO;
import com.happyfeet.service.interfaces.IUsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {

    private IUsuarioDAO usuarioDAO;

    public UsuarioServiceImpl() {
        this.usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void registrarUsuario(Usuario usuario) throws Exception {
        if (usuario.getNombreUsuario() == null || usuario.getNombreUsuario().isEmpty()) {
            throw new Exception("El nombre de usuario no puede estar vacío");
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().length() < 6) {
            throw new Exception("La contraseña debe tener mínimo 6 caracteres");
        }
        if (usuario.getRol() == null) {
            throw new Exception("El rol es obligatorio");
        }

        usuarioDAO.agregarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioDAO.obtenerTodasUsuario();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID no es válido");
        }
        return usuarioDAO.obtenerUsuarioPorId(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws Exception {
        if (usuario.getId() <= 0) {
            throw new Exception("El ID no es válido para actualizar");
        }
        usuarioDAO.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Integer id) throws Exception {
        if (id == null || id <= 0) {
            throw new Exception("El ID no es válido para eliminar");
        }
        usuarioDAO.eliminarUsuario(id);
    }

    @Override
    public Usuario autenticar(String nombreUsuario, String contrasena) throws Exception {
        List<Usuario> usuarios = usuarioDAO.obtenerTodasUsuario();
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombreUsuario) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        throw new Exception("Credenciales inválidas");
    }
}
