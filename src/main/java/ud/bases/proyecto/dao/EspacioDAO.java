package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Espacio;
import ud.bases.proyecto.repository.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class EspacioDAO implements IDAO<Espacio> {

    private static final Logger LOGGER = Logger.getLogger(EspacioDAO.class.getName());

    private Connection connection = new Connection();

    @Override
    public void insertar(Espacio espacio) throws SQLException {

        LOGGER.info("Insertando espacio: " + espacio.getId());

        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("INSERT INTO espacio (\"k_idEspacio\",\"n_Estado\", \"n_TipoEspacio\", \"k_idArea\") VALUES (?, ?, ?,?);");
            st.setLong(1, espacio.getId());
            st.setString(2, espacio.getEstado());
            st.setString(3, espacio.getTipoEspacio());
            st.setLong(4, espacio.getIdArea());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al insertar espacio: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    @Override
    public void actualizar(Espacio espacio) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE espacio SET \"n_Estado\" = ?, \"n_TipoEspacio\" = ?, \"k_idArea\" = ? WHERE \"k_idEspacio\" = ?;");
            st.setString(1, espacio.getEstado());
            st.setString(2, espacio.getTipoEspacio());
            st.setLong(3, espacio.getIdArea());
            st.setLong(4, espacio.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar espacio: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    @Override
    public void eliminar(Espacio espacio) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("DELETE FROM espacio WHERE \"k_idEspacio\" = ?;");
            st.setLong(1, espacio.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al eliminar espacio: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public Espacio encontrarPorId(int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        Espacio espacio = new Espacio();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM espacio WHERE \"k_idEspacio\" = ?;");
            st.setLong(1, id);
            result = st.executeQuery();
            while (result.next()) {
                espacio.setId(result.getLong("k_idEspacio"));
                espacio.setEstado(result.getString("n_Estado"));
                espacio.setTipoEspacio(result.getString("n_TipoEspacio"));
                espacio.setIdArea(result.getLong("k_idArea"));
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar espacio por id: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return espacio;
    }

    @Override
    public List<Espacio> encontrarTodos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Espacio> espacios = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM espacio;");
            while (result.next()) {
                Espacio espacio = new Espacio();
                espacio.setId(result.getLong("k_idEspacio"));
                espacio.setEstado(result.getString("n_Estado"));
                espacio.setTipoEspacio(result.getString("n_TipoEspacio"));
                espacio.setIdArea(result.getLong("k_idArea"));
                espacios.add(espacio);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todos los espacios: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return espacios;
    }

    @Override
    public List<Espacio> filtrarCampoValor(String campo, String valor) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        List<Espacio> espacios = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM espacio WHERE " + "\""+ campo + "\"" + " = ?;");
            st.setString(1, valor);
            result = st.executeQuery();
            while (result.next()) {
                Espacio espacio = new Espacio();
                espacio.setId(result.getLong("k_idEspacio"));
                espacio.setEstado(result.getString("n_Estado"));
                espacio.setTipoEspacio(result.getString("n_TipoEspacio"));
                espacio.setIdArea(result.getLong("k_idArea"));
                espacios.add(espacio);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar espacios por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return espacios;
    }

    @Override
    public List<Espacio> filtrarCampoValorId(String campo, int valor) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        List<Espacio> espacios = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM espacio WHERE " + "\""+ campo + "\"" + " = ? ORDER BY" + "\""+"k_idEspacio"+"\"" + "ASC;");
            st.setLong(1, valor);
            result = st.executeQuery();
            while (result.next()) {
                Espacio espacio = new Espacio();
                espacio.setId(result.getLong("k_idEspacio"));
                espacio.setEstado(result.getString("n_Estado"));
                espacio.setTipoEspacio(result.getString("n_TipoEspacio"));
                espacio.setIdArea(result.getLong("k_idArea"));
                espacios.add(espacio);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar espacios por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return espacios;
    }


    public void actualizarEstado(Long id, String estado) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE espacio SET \"n_Estado\" = ? WHERE \"k_idEspacio\" = ?;");
            st.setString(1, estado);
            st.setLong(2, id);
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar estado de espacio: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    public List<Espacio> disponiblePorArea (Long id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        List<Espacio> espacios = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM espacio WHERE \"k_idArea\" = ? AND \"n_Estado\" = 'disponible';");
            st.setLong(1, id);
            result = st.executeQuery();
            while (result.next()) {
                Espacio espacio = new Espacio();
                espacio.setId(result.getLong("k_idEspacio"));
                espacio.setEstado(result.getString("n_Estado"));
                espacio.setTipoEspacio(result.getString("n_TipoEspacio"));
                espacio.setIdArea(result.getLong("k_idArea"));
                espacios.add(espacio);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar espacios disponibles por area: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return espacios;
    }
}
