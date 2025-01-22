package curso.spring.curso.dao;

import curso.spring.curso.model.Usuario;

import java.util.List;

public interface UsuarioDAO {
    public List<Usuario> obtenerUsuarios();

    public void eliminarUsuario(String id);

    public void registrarUsuario(Usuario usuario);

    public Usuario obtnerUsuarioCredenciales(Usuario usuario);
}
