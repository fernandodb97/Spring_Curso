package curso.spring.curso.dao;

import curso.spring.curso.model.Usuario;
import org.apache.catalina.LifecycleState;

import java.util.List;

public interface UsuarioDAO {
    List<Usuario> obtenerUsuarios();
}
