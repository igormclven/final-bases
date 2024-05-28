package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.ParqueaderoDAO;
import ud.bases.proyecto.entity.Parqueadero;

import java.sql.SQLException;
import java.util.List;

@Service
public class ParqueaderoService {

    private final ParqueaderoDAO parqueaderoDAO;

    public ParqueaderoService(ParqueaderoDAO parqueaderoDAO) {
        this.parqueaderoDAO = parqueaderoDAO;
    }

    public void insertar(Parqueadero parqueadero) throws SQLException {
        parqueaderoDAO.insertar(parqueadero);
    }

    public void actualizar(Parqueadero parqueadero) throws SQLException {
        parqueaderoDAO.actualizar(parqueadero);
    }

    public void eliminar(Parqueadero parqueadero) throws SQLException {
        parqueaderoDAO.eliminar(parqueadero);
    }

    public List<Parqueadero> encontrarTodos() throws SQLException {
        return parqueaderoDAO.encontrarTodos();
    }

    public Parqueadero encontrarPorId(int id) throws SQLException {
        return parqueaderoDAO.encontrarPorId(id);
    }

    public List<Parqueadero> filtrarCampoValor(String campo, String valor) throws SQLException {
        return parqueaderoDAO.filtrarCampoValor(campo, valor);
    }

    public List<Parqueadero> filtrarCampoValorId(String campo, int valor) throws SQLException {
        return parqueaderoDAO.filtrarCampoValorId(campo, valor);
    }

}
