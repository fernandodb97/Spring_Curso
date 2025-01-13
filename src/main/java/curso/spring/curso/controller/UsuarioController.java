package curso.spring.curso.controller;

import java.util.ArrayList;
import java.util.List;

import curso.spring.curso.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import curso.spring.curso.model.Usuario;

@RestController
public class UsuarioController{


    @Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="api/usuarios")
	public List<Usuario> obtenerUsuarios() {

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
