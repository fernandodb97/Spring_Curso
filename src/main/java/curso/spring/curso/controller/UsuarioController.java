package curso.spring.curso.controller;

import java.util.ArrayList;
import java.util.List;

import curso.spring.curso.dao.UsuarioDAO;
import curso.spring.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import curso.spring.curso.model.Usuario;

@RestController
public class UsuarioController{


    @Autowired
	private UsuarioDAO usuarioDAO;
	@Autowired
	private JWTUtil jwtUtil;
	@RequestMapping(value="api/usuarios")
	public List<Usuario> obtenerUsuarios(@RequestHeader(value = "Authorization") String token) {
		String idUsuario = jwtUtil.getKey(token);
		if(idUsuario == null){
			return new ArrayList<>();
		}
		return usuarioDAO.obtenerUsuarios();
	}

	@RequestMapping(value="api/usuario/{id}", method = RequestMethod.GET)
	public Usuario obtenerUsuario(@PathVariable String id) {
		Usuario usuarion = new Usuario();
		usuarion.setUsuarioId(Long.valueOf(5));
		usuarion.setApellido("Delgado");
		usuarion.setContaseña("123456");
		usuarion.setEmail("fernando.delgado@gmail.com");
		usuarion.setTelefono("+5612345678");
		usuarion.setNombre("Fernando");
		return usuarion;
	}


	@RequestMapping(value="api/usuario_editar/{id}")
	public Usuario editarUsuario(@PathVariable String id) {
		Usuario usuarion = new Usuario();
		usuarion.setUsuarioId(Long.valueOf(5));
		usuarion.setApellido("Delgado");
		usuarion.setContaseña("123456");
		usuarion.setEmail("fernando.delgado@gmail.com");
		usuarion.setTelefono("+5612345678");
		usuarion.setNombre("Fernando");
		return usuarion;
	}

	@RequestMapping(value="api/usuario_eliminar/{id}", method = RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable String id) {
		usuarioDAO.eliminarUsuario(id);
	}
	@RequestMapping(value="api/usuario_registrar", method = RequestMethod.POST)
	public void registrarUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash = argon2.hash(1,1024,1,usuario.getContaseña());
		usuario.setContaseña(hash);


		usuarioDAO.registrarUsuario(usuario);
	}


	@RequestMapping(value="api/usuario_insertar/{id}")
	public Usuario insertarUsuario(@PathVariable String id) {
		Usuario usuarion = new Usuario();
		usuarion.setUsuarioId(Long.valueOf(5));
		usuarion.setApellido("Delgado");
		usuarion.setContaseña("123456");
		usuarion.setEmail("fernando.delgado@gmail.com");
		usuarion.setTelefono("+5612345678");
		usuarion.setNombre("Fernando");
		return usuarion;
	}

}
