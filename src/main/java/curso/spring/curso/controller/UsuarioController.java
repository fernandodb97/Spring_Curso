package curso.spring.curso.controller;

import java.util.ArrayList;
import java.util.List;

import curso.spring.curso.dao.UsuarioDAO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.spring.curso.model.Usuario;

@RestController
public class UsuarioController implements UsuarioDAO {

	@RequestMapping(value="usuarios")
	public List<Usuario> obtenerUsuarios() {
		List<Usuario> listaUsuarios = new ArrayList<>();
		Usuario usuarion = new Usuario();
		usuarion.setUsuarioId(Long.valueOf(1));
		usuarion.setApellido("Delgado");
		usuarion.setContaseña("123456");
		usuarion.setEmail("fernando.delgado@gmail.com");
		usuarion.setTelefono("+5612345678");
		usuarion.setNombre("Fernando");
		Usuario usuarion2 = new Usuario();
		usuarion2.setUsuarioId(Long.valueOf(2));
		usuarion2.setApellido("Delgado");
		usuarion2.setContaseña("123456");
		usuarion2.setEmail("fernando.delgado@gmail.com");
		usuarion2.setTelefono("+5612345678");
		usuarion2.setNombre("Fernando");
		Usuario usuarion3 = new Usuario();
		usuarion3.setUsuarioId(Long.valueOf(3));
		usuarion3.setApellido("Delgado");
		usuarion3.setContaseña("123456");
		usuarion3.setEmail("fernando.delgado@gmail.com");
		usuarion3.setTelefono("+5612345678");
		usuarion3.setNombre("Fernando");
		listaUsuarios.add(usuarion);
		listaUsuarios.add(usuarion2);
		listaUsuarios.add(usuarion3);
		return listaUsuarios;
	}
	
	@RequestMapping(value="usuario_editar/{id}")
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

	@RequestMapping(value="usuario_eliminar/{id}")
	public Usuario eliminarUsuario(@PathVariable String id) {
		Usuario usuarion = new Usuario();
		usuarion.setUsuarioId(Long.valueOf(5));
		usuarion.setApellido("Delgado");
		usuarion.setContaseña("123456");
		usuarion.setEmail("fernando.delgado@gmail.com");
		usuarion.setTelefono("+5612345678");
		usuarion.setNombre("Fernando");
		return usuarion;
	}

	@RequestMapping(value="usuario_insertar/{id}")
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
