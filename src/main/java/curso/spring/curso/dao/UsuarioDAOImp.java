package curso.spring.curso.dao;

import curso.spring.curso.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public class UsuarioDAOImp implements UsuarioDAO{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Usuario> obtenerUsuarios() {
        String query = "FROM Usuario";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarUsuario(String id) {
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean validarUsuario(Usuario usuario) {
        String query = "FROM Usuario WHERE email= :email AND contaseña = :contraseña";

        List<Usuario> listaUsuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .setParameter("contraseña", usuario.getContaseña())
                .getResultList();
        return !listaUsuarios.isEmpty();
    }
}
