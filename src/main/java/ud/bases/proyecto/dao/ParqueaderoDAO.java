package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Parqueadero;
import ud.bases.proyecto.repository.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class ParqueaderoDAO implements IDAO<Parqueadero> {


    private static final Logger LOGGER = Logger.getLogger(AreaDAO.class.getName());

    private Connection connection = new Connection();

    @Override
    public void insertar(Parqueadero parqueadero) throws SQLException {
        LOGGER.info("Insertando parqueadero: " + parqueadero.getId());

        PreparedStatement st = null;

        try {
            connection.open();

            st = connection.conn.prepareStatement("INSERT INTO parqueadero (\"k_idParqueadero\",\"n_nombre\", \"n_direccion\", \"n_tipoParqueadero\", \"k_idLocalidad\") VALUES (?, ?, ?, ?, ?);");
            st.setInt(1, parqueadero.getId());
            st.setString(2, parqueadero.getNombre());
            st.setString(3, parqueadero.getDireccion());
            st.setString(4, parqueadero.getTipoParqueadero());
            st.setInt(5, parqueadero.getLocalidad());
            st.executeUpdate();

        } catch (Exception e) {
            LOGGER.severe("Error al insertar parqueadero: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void actualizar(Parqueadero parqueadero) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE parqueadero SET \"n_nombre\" = ?, \"n_direccion\" = ?, \"n_tipoParqueadero\" = ?, \"k_idLocalidad\" = ? WHERE \"k_idParqueadero\" = ?;");
            st.setString(1, parqueadero.getNombre());
            st.setString(2, parqueadero.getDireccion());
            st.setString(3, parqueadero.getTipoParqueadero());
            st.setInt(4, parqueadero.getLocalidad());
            st.setInt(5, parqueadero.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar parqueadero: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void eliminar(Parqueadero parqueadero) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("DELETE FROM parqueadero WHERE \"k_idParqueadero\" = ?;");
            st.setInt(1, parqueadero.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al eliminar parqueadero: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public Parqueadero encontrarPorId(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Parqueadero> encontrarTodos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Parqueadero> parqueaderos = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM parqueadero;");

            while (result.next()) {
                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setId(result.getInt("k_idParqueadero"));
                parqueadero.setNombre(result.getString("n_nombre"));
                parqueadero.setDireccion(result.getString("n_direccion"));
                parqueadero.setTipoParqueadero(result.getString("n_tipoParqueadero"));
                parqueadero.setLocalidad(result.getInt("k_idLocalidad"));
                parqueaderos.add(parqueadero);
            }

            return parqueaderos;
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todos los parqueaderos: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public List<Parqueadero> filtrarCampoValor (String campo, String valor) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Parqueadero> parqueaderos = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM parqueadero WHERE \"" + campo + "\" = '" + valor + "';");

            while (result.next()) {
                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setId(result.getInt("k_idParqueadero"));
                parqueadero.setNombre(result.getString("n_nombre"));
                parqueadero.setDireccion(result.getString("n_direccion"));
                parqueadero.setTipoParqueadero(result.getString("n_tipoParqueadero"));
                parqueadero.setLocalidad(result.getInt("k_idLocalidad"));
                parqueaderos.add(parqueadero);
            }

            return parqueaderos;
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar parqueaderos por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public List<Parqueadero> filtrarCampoValorId (String campo, int valor) throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Parqueadero> parqueaderos = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM parqueadero WHERE \"" + campo + "\" = " + valor + ";");

            while (result.next()) {
                Parqueadero parqueadero = new Parqueadero();
                parqueadero.setId(result.getInt("k_idParqueadero"));
                parqueadero.setNombre(result.getString("n_nombre"));
                parqueadero.setDireccion(result.getString("n_direccion"));
                parqueadero.setTipoParqueadero(result.getString("n_tipoParqueadero"));
                parqueadero.setLocalidad(result.getInt("k_idLocalidad"));
                parqueaderos.add(parqueadero);
            }

            return parqueaderos;
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar parqueaderos por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }
}
