package curso.spring.curso.dao;

import curso.spring.curso.model.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
    public Usuario obtnerUsuarioCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE email= :email";

        List<Usuario> listaUsuarios = entityManager.createQuery(query)
                .setParameter("email", usuario.getEmail())
                .getResultList();

        if (listaUsuarios.isEmpty()){return null;}
        String claveHashed = listaUsuarios.get(0).getContaseña();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(claveHashed, usuario.getContaseña())){
            return listaUsuarios.get(0);
        }
        return null;
    }
}
