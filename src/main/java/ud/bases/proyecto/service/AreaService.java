package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.AreaDAO;
import ud.bases.proyecto.entity.Area;

import java.sql.SQLException;
import java.util.List;

@Service
public class AreaService {

    private final AreaDAO areaDAO;

    public AreaService(AreaDAO areaDAO) {
        this.areaDAO = areaDAO;
    }

    public List<Area> encontrarTodos() throws SQLException {
        return areaDAO.encontrarTodos();
    }

    public Area encontrarPorId(int id) throws SQLException {
        return areaDAO.encontrarPorId(id);
    }

    public void insertar(Area area) throws SQLException {
        areaDAO.insertar(area);
    }

    public void actualizar(Area area) throws SQLException {
        areaDAO.actualizar(area);
    }

    public void eliminar(Area area) throws SQLException {
        areaDAO.eliminar(area);
    }

    public List<Area> filtrarCampoValor(String campo, String valor) throws SQLException {
        return areaDAO.filtrarCampoValor(campo, valor);
    }

    public List<Area> filtrarCampoValorId(String campo, int valor) throws SQLException {
        return areaDAO.filtrarCampoValorId(campo, valor);
    }

}
