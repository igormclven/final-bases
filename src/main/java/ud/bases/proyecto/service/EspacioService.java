package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.EspacioDAO;
import ud.bases.proyecto.entity.Espacio;

import java.sql.SQLException;
import java.util.List;

@Service
public class EspacioService {

    private final EspacioDAO espacioDAO;

    public EspacioService(EspacioDAO espacioDAO) {
        this.espacioDAO = espacioDAO;
    }

    public List<Espacio> encontrarTodos() throws SQLException {
        return espacioDAO.encontrarTodos();
    }

    public Espacio encontrarPorId(long id) throws SQLException {
        return espacioDAO.encontrarPorId(id);
    }

    public void insertar(Espacio espacio) throws SQLException {
        espacioDAO.insertar(espacio);
    }

    public void actualizar(Espacio espacio) throws SQLException {
        espacioDAO.actualizar(espacio);
    }

    public void eliminar(Espacio espacio) throws SQLException {
        espacioDAO.eliminar(espacio);
    }

    public void actualizarEstado(Long id, String estado) throws SQLException {
        espacioDAO.actualizarEstado(id, estado);
    }

    public List<Espacio> filtrarCampoValor(String campo, String valor) throws SQLException {
        return espacioDAO.filtrarCampoValor(campo, valor);
    }

    public List<Espacio> filtrarCampoValorId(String campo, long valor) throws SQLException {
        return espacioDAO.filtrarCampoValorId(campo, valor);
    }

}
