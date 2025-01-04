package curso.spring.curso.dao;

import curso.spring.curso.model.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImp implements UsuarioDAO{

    @Override
    public List<Usuario> obtenerUsuarios() {
        return List.of();
    }
}
