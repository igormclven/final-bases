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
            st = connection.conn.prepareStatement("SELECT DATE(\"f_fechaEntrada\") AS fecha, COUNT(*) AS cantidad FROM registro GROUP BY DATE(\"f_fechaEntrada\") ORDER BY DATE(\"f_fechaEntrada\");");
            result = st.executeQuery();
            while (result.next()) {
                Estadistica estadistica = new Estadistica();
                estadistica.setFecha(result.getDate("fecha"));
                estadistica.setCantidad(result.getInt("cantidad"));
                datos.add(estadistica);
            }
        } catch (SQLException e) {
            LOGGER.severe("Error al obtener las estadisticas del dia: " + e.getMessage());
            throw new SQLException("Error al obtener las estadisticas del dia: " + e.getMessage());
        } finally {
            if (result != null) {
                result.close();
            }
            if (st != null) {
                st.close();
            }
            connection.close();
            return datos;
        }
    }
}
