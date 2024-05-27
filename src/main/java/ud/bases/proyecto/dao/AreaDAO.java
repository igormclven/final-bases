package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Area;
import ud.bases.proyecto.repository.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class AreaDAO implements IDAO<Area> {

    private static final Logger LOGGER = Logger.getLogger(AreaDAO.class.getName());

    private Connection connection = new Connection();

    @Override
    public void insertar(Area area) throws SQLException {
        LOGGER.info("Insertando area: " + area.getId());

        PreparedStatement st = null;

        try {
            connection.open();

            st = connection.conn.prepareStatement("INSERT INTO area (\"k_idArea\",\"n_nombre\", \"n_descripcion\", \"q_capacidadTotal\", \"q_capacidadDisponible\", \"k_idParqueadero\") VALUES (?, ?, ?, ?, ?, ?);");
            st.setInt(1, area.getId());
            st.setString(2, area.getNombre());
            st.setString(3, area.getDescripcion());
            st.setInt(4, area.getCapacidadTotal());
            st.setInt(5, area.getCapacidadDisponible());
            st.setInt(6, area.getIdParqueadero());
            st.executeUpdate();

        } catch (Exception e) {
            LOGGER.severe("Error al insertar area: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void actualizar(Area area) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE area SET \"n_nombre\" = ?, \"n_descripcion\" = ?, \"q_capacidadTotal\" = ?, \"q_capacidadDisponible\" = ?, \"k_idParqueadero\" = ? WHERE \"k_idArea\" = ?;");
            st.setString(1, area.getNombre());
            st.setString(2, area.getDescripcion());
            st.setInt(3, area.getCapacidadTotal());
            st.setInt(4, area.getCapacidadDisponible());
            st.setInt(5, area.getIdParqueadero());
            st.setInt(6, area.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar area: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void eliminar(Area area) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("DELETE FROM area WHERE \"k_idArea\" = ?;");
            st.setInt(1, area.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al eliminar area: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public Area encontrarPorId(long id) throws SQLException {
        return null;
    }

    @Override
    public List<Area> encontrarTodos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Area> areas = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM area;");

            while (result.next()) {
                Area area = new Area();
                area.setId(result.getInt("k_idArea"));
                area.setNombre(result.getString("n_nombre"));
                area.setDescripcion(result.getString("n_descripcion"));
                area.setCapacidadTotal(result.getInt("q_capacidadTotal"));
                area.setCapacidadDisponible(result.getInt("q_capacidadDisponible"));
                area.setIdParqueadero(result.getInt("k_idParqueadero"));
                areas.add(area);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todas las areas: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
        return areas;
    }

    @Override
    public List<Area> filtrarCampoValor (String campo, String valor) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Area> areas = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM area WHERE " + campo + " = " + valor + ";");

            while (result.next()) {
                Area area = new Area();
                area.setId(result.getInt("k_idArea"));
                area.setNombre(result.getString("n_nombre"));
                area.setDescripcion(result.getString("n_descripcion"));
                area.setCapacidadTotal(result.getInt("q_capacidadTotal"));
                area.setCapacidadDisponible(result.getInt("q_capacidadDisponible"));
                area.setIdParqueadero(result.getInt("k_idParqueadero"));
                areas.add(area);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todas las areas: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
        return areas;
    }

    @Override
    public List<Area> filtrarCampoValorId (String campo, long valor) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Area> areas = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM area WHERE " + campo + " = " + valor + ";");

            while (result.next()) {
                Area area = new Area();
                area.setId(result.getInt("k_idArea"));
                area.setNombre(result.getString("n_nombre"));
                area.setDescripcion(result.getString("n_descripcion"));
                area.setCapacidadTotal(result.getInt("q_capacidadTotal"));
                area.setCapacidadDisponible(result.getInt("q_capacidadDisponible"));
                area.setIdParqueadero(result.getInt("k_idParqueadero"));
                areas.add(area);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todas las areas: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
        return areas;
    }
}
