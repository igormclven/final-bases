package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Registro;
import ud.bases.proyecto.repository.Connection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class RegistroDAO implements IDAO<Registro> {

    private static final Logger LOGGER = Logger.getLogger(RegistroDAO.class.getName());

    private Connection connection = new Connection();

    @Override
    public void insertar(Registro registro) throws SQLException {

        LOGGER.info("Insertando registro: " + registro.getId());

        PreparedStatement st = null;

        try {
            connection.open();
            st = connection.conn.prepareStatement("INSERT INTO registro (\"k_idRegistro\",\"n_placa\", \"f_fechaEntrada\", \"n_tipoVehiculo\", \"k_idEspacio\") VALUES (?, ?, ?, ?,?);");
            st.setInt(1, registro.getId());
            st.setString(2, registro.getPlaca());
            st.setTimestamp(3, registro.getFechaEntrada());
            st.setString(4, registro.getTipoVehiculo());
            st.setLong(5, registro.getIdEspacio());
            st.executeUpdate();

        } catch (Exception e) {
            LOGGER.severe("Error al insertar registro: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    @Override
    public void actualizar(Registro registro) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE registro SET \"n_placa\" = ?, \"f_fechaEntrada\" = ?, \"f_fechaSalida\" = ?, \"n_tipoVehiculo\" = ?, \"k_idEspacio\" = ? WHERE \"k_idRegistro\" = ?;");
            st.setString(1, registro.getPlaca());
            st.setTimestamp(2, registro.getFechaEntrada());
            st.setTimestamp(3, registro.getFechaSalida());
            st.setString(4, registro.getTipoVehiculo());
            st.setLong(5, registro.getIdEspacio());
            st.setInt(6, registro.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar registro: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    @Override
    public void eliminar(Registro registro) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("DELETE FROM registro WHERE \"k_idRegistro\" = ?;");
            st.setInt(1, registro.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al eliminar registro: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
    }

    @Override
    public Registro encontrarPorId(int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        Registro Registro = new Registro();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM registro WHERE \"k_idRegistro\" = ?;");
            st.setInt(1, (int) id);
            result = st.executeQuery();
            if (result.next()) {
                Registro registro = new Registro();
                registro.setId(result.getInt("k_idRegistro"));
                registro.setPlaca(result.getString("n_placa"));
                registro.setFechaEntrada(result.getTimestamp("f_fechaEntrada"));
                registro.setFechaSalida(result.getTimestamp("f_fechaSalida"));
                registro.setTipoVehiculo(result.getString("n_tipoVehiculo"));
                registro.setIdEspacio(result.getInt("k_idEspacio"));
                return registro;
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar registro por id: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return Registro;
    }

    @Override
    public List<Registro> encontrarTodos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Registro> registros = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM registro;");
            while (result.next()) {
                Registro registro = new Registro();
                registro.setId(result.getInt("k_idRegistro"));
                registro.setPlaca(result.getString("n_placa"));
                registro.setFechaEntrada(result.getTimestamp("f_fechaEntrada"));
                registro.setFechaSalida(result.getTimestamp("f_fechaSalida"));
                registro.setTipoVehiculo(result.getString("n_tipoVehiculo"));
                registro.setIdEspacio(result.getInt("k_idEspacio"));
                registros.add(registro);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todos los registros: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return registros;
    }

    @Override
    public List<Registro> filtrarCampoValor (String campo, String valor) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        List<Registro> registros = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM registro WHERE ? = ?;");
            st.setString(1, campo);
            st.setString(2, valor);
            result = st.executeQuery();
            while (result.next()) {
                Registro registro = new Registro();
                registro.setId(result.getInt("k_idRegistro"));
                registro.setPlaca(result.getString("n_placa"));
                registro.setFechaEntrada(result.getTimestamp("f_fechaEntrada"));
                registro.setFechaSalida(result.getTimestamp("f_fechaSalida"));
                registro.setTipoVehiculo(result.getString("n_tipoVehiculo"));
                registro.setIdEspacio(result.getInt("k_idEspacio"));
                registros.add(registro);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar registros por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return registros;
    }

    @Override
    public List<Registro> filtrarCampoValorId (String campo, int valor) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        List<Registro> registros = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM registro WHERE ? = ?;");
            st.setString(1, campo);
            st.setInt(2, (int) valor);
            result = st.executeQuery();
            while (result.next()) {
                Registro registro = new Registro();
                registro.setId(result.getInt("k_idRegistro"));
                registro.setPlaca(result.getString("n_placa"));
                registro.setFechaEntrada(result.getTimestamp("f_fechaEntrada"));
                registro.setFechaSalida(result.getTimestamp("f_fechaSalida"));
                registro.setTipoVehiculo(result.getString("n_tipoVehiculo"));
                registro.setIdEspacio(result.getInt("k_idEspacio"));
                registros.add(registro);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar registros por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return registros;
    }

    public Registro registroActual(long id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        Registro registro = new Registro();
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM registro WHERE \"k_idEspacio\" = ? and \"f_fechaSalida\" is null;");
            st.setInt(1, (int) id);
            result = st.executeQuery();
            if (result.next()) {
                registro.setId(result.getInt("k_idRegistro"));
                registro.setPlaca(result.getString("n_placa"));
                registro.setFechaEntrada(result.getTimestamp("f_fechaEntrada"));
                registro.setFechaSalida(result.getTimestamp("f_fechaSalida"));
                registro.setTipoVehiculo(result.getString("n_tipoVehiculo"));
                registro.setIdEspacio(result.getInt("k_idEspacio"));
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar registro por id de espacio: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return registro;
    }

    public int contarRegistros() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        int registros = 0;
        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT COUNT(*) FROM registro;");
            if (result.next()) {
                registros = result.getInt(1);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al contar registros: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return registros;
    }

    public void actualizarFechaSalida(int registro, Timestamp fecha) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE registro SET \"f_fechaSalida\" = ? WHERE \"k_idRegistro\" = ?;");
            st.setTimestamp(1, fecha);
            st.setInt(2, registro);
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar fecha de salida: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
        }
}