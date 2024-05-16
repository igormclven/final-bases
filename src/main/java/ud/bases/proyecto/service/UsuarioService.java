package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.entity.Usuario;
import ud.bases.proyecto.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public int createUser(Usuario usuario) {
        return usuarioRepository.create(usuario);
    }

    public Usuario getUserById(int id) {
        return usuarioRepository.read(id);
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.readAll();
    }

    public int updateUser(Usuario usuario) {
        return usuarioRepository.update(usuario);
    }

    public int deleteUser(int id) {
        return usuarioRepository.delete(id);
    }
}
