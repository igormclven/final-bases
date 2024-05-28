package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.EstadisticaDAO;
import ud.bases.proyecto.entity.Estadistica;

import java.sql.SQLException;
import java.util.List;

@Service
public class EstadisticaService {

    private final EstadisticaDAO estadisticaDAO;

    public EstadisticaService(EstadisticaDAO estadisticaDAO) {
        this.estadisticaDAO = estadisticaDAO;
    }

    public List<Estadistica> estadisticaDia() throws SQLException {
        return estadisticaDAO.estadisticaDia();
    }

    public List<Estadistica> estadisticaMes() throws SQLException {
        return estadisticaDAO.estadisticaMes();
    }

    public List<Estadistica> estadisticaSemana() throws SQLException {
        return estadisticaDAO.estadisticaSemana();
    }

    public List<Estadistica> estadisticaAno() throws SQLException {
        return estadisticaDAO.estadisticaAno();
    }
}
