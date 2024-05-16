package ud.bases.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ud.bases.proyecto.entity.Usuario;
import ud.bases.proyecto.service.UsuarioService;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/create")
    public int createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }

    @GetMapping("/read/{id}")
    public String getUserById(@PathVariable int id, Model model) {
        Usuario usuario = usuarioService.getUserById(id);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }

    @GetMapping("/readAll")
    public String getAllUsers(Model model) {
        List<Usuario> listadoUsuarios = usuarioService.getAllUsers();
        model.addAttribute("usuarios", listadoUsuarios);
        return "usuarios";
    }

    @PutMapping("/update")
    public int updateUser(@RequestBody Usuario usuario) {
        return usuarioService.updateUser(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteUser(@PathVariable int id) {
        return usuarioService.deleteUser(id);
    }

}
