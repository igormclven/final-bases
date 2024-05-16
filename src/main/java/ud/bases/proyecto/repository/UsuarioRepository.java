package ud.bases.proyecto.repository;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UsuarioRepository {

    private JdbcTemplate jdbcTemplate;

    public UsuarioRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int create(Usuario usuario) {
        String query = "INSERT INTO capacitacion.usuario (nombre, apellido) VALUES (?, ?)";
        return jdbcTemplate.update(query, usuario.getNombre(), usuario.getApellido());
    }

    public Usuario read(int id) {
        String query = "SELECT * FROM capacitacion.usuario WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new UsuarioRowMapper(), id);
    }

    public List<Usuario> readAll() {
        String query = "SELECT * FROM capacitacion.usuario";
        return jdbcTemplate.query(query, new UsuarioRowMapper());
    }

    public int update(Usuario usuario) {
        String query = "UPDATE capacitacion.usuario SET nombre = ?, apellido = ? WHERE id = ?";
        return jdbcTemplate.update(query, usuario.getNombre(), usuario.getApellido(), usuario.getId());
    }

    public int delete(int id) {
        String query = "DELETE FROM capacitacion.usuario WHERE id = ?";
        return jdbcTemplate.update(query, id);
    }

    private static class UsuarioRowMapper implements RowMapper<Usuario> {
        @Override
        public Usuario mapRow(ResultSet resultSet, int i) throws SQLException {
            Usuario usuario = new Usuario();
            usuario.setId(resultSet.getInt("id"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setApellido(resultSet.getString("apellido"));
            return usuario;
        }
    }
}
