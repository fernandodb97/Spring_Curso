package curso.spring.curso.controller;

import curso.spring.curso.dao.UsuarioDAO;
import curso.spring.curso.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDAO usuarioDAO;


    @RequestMapping(value="api/login", method = RequestMethod.POST)
    public String ingresoUsuario(@RequestBody Usuario usuario) {
        if (usuarioDAO.validarUsuario(usuario)){
            return "OK";
        }
        return "False";

    }

}
