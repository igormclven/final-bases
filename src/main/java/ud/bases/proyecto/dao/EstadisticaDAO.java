package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Estadistica;
import ud.bases.proyecto.repository.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class EstadisticaDAO {

    private static final Logger LOGGER = Logger.getLogger(EstadisticaDAO.class.getName());

    private Connection connection = new Connection();

    public List<Estadistica> estadisticaDia() throws SQLException {
        LOGGER.info("Estadisticas dia ");
        PreparedStatement st = null;
        ResultSet result = null;
        List<Estadistica> datos = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT TO_CHAR(\"f_fechaEntrada\", 'YYYY-MM-DD') AS dia, COUNT(*) AS cantidad FROM registro GROUP BY dia ORDER BY dia;");
            result = st.executeQuery();
            while (result.next()) {
                Estadistica estadistica = new Estadistica();
                estadistica.setAgrupacion(result.getString("dia"));
                estadistica.setCantidad(result.getInt("cantidad"));
                datos.add(estadistica);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error al obtener las estadisticas de los dias: " + e.getMessage());
            throw new SQLException("Error al obtener las estadisticas de los dias: " + e.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
            return datos;
        }
    }

    public List<Estadistica> estadisticaSemana() throws SQLException {
        LOGGER.info("Estadisticas semana ");
        PreparedStatement st = null;
        ResultSet result = null;
        List<Estadistica> datos = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT TO_CHAR(\"f_fechaEntrada\", 'IYYY-IW') AS ano_semana, COUNT(*) AS cantidad FROM registro GROUP BY ano_semana ORDER BY ano_semana;");
            result = st.executeQuery();
            while (result.next()) {
                Estadistica estadistica = new Estadistica();
                estadistica.setAgrupacion(result.getString("ano_semana"));
                estadistica.setCantidad(result.getInt("cantidad"));
                datos.add(estadistica);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error al obtener las estadisticas de las semanas del año: " + e.getMessage());
            throw new SQLException("Error al obtener las estadisticas de las semanas del año: " + e.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
            return datos;
        }
    }

    public List<Estadistica> estadisticaMes() throws SQLException {
        LOGGER.info("Estadisticas mes ");
        PreparedStatement st = null;
        ResultSet result = null;
        List<Estadistica> datos = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT TO_CHAR(\"f_fechaEntrada\", 'YYYY-MM') AS mes, COUNT(*) AS cantidad FROM registro GROUP BY mes ORDER BY mes;");
            result = st.executeQuery();
            while (result.next()) {
                Estadistica estadistica = new Estadistica();
                estadistica.setAgrupacion(result.getString("mes"));
                estadistica.setCantidad(result.getInt("cantidad"));
                datos.add(estadistica);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error al obtener las estadisticas de los meses: " + e.getMessage());
            throw new SQLException("Error al obtener las estadisticas de los meses: " + e.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
            return datos;
        }
    }

    public List<Estadistica> estadisticaAno() throws SQLException {
        LOGGER.info("Estadisticas año ");
        PreparedStatement st = null;
        ResultSet result = null;
        List<Estadistica> datos = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT TO_CHAR(\"f_fechaEntrada\", 'YYYY') AS ano, COUNT(*) AS cantidad FROM registro GROUP BY ano ORDER BY ano;");
            result = st.executeQuery();
            while (result.next()) {
                Estadistica estadistica = new Estadistica();
                estadistica.setAgrupacion(result.getString("ano"));
                estadistica.setCantidad(result.getInt("cantidad"));
                datos.add(estadistica);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error al obtener las estadisticas de los años: " + e.getMessage());
            throw new SQLException("Error al obtener las estadisticas de los años: " + e.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
            return datos;
        }
    }
}
