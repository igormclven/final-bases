package ud.bases.proyecto.dao;

import org.springframework.stereotype.Repository;
import ud.bases.proyecto.entity.Pago;
import ud.bases.proyecto.repository.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class PagoDAO implements IDAO<Pago>{

    private static final Logger LOGGER = Logger.getLogger(PagoDAO.class.getName());

    private Connection connection = new Connection();

    @Override
    public void insertar(Pago pago) throws SQLException {
        LOGGER.info("Insertando pago: " + pago.getId());

        LOGGER.info("Insertando pago: " + pago.getFechaPago());

        PreparedStatement st = null;

        try {
            connection.open();

            // Se inserta
            st = connection.conn.prepareStatement("INSERT INTO pago (\"k_idPago\",\"n_formaPago\", \"v_valorPagado\", \"f_fechaPago\", \"k_idRegistro\") VALUES (?, ?, ?, ?,?);");
            st.setInt(1, pago.getId());
            st.setString(2, pago.getFormaPago());
            st.setDouble(3, pago.getValorPagado());
            st.setTimestamp(4, pago.getFechaPago());
            st.setInt(5, pago.getIdRegistro());
            st.executeUpdate();

        } catch (Exception e) {
            LOGGER.severe("Error al insertar pago: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void actualizar(Pago pago) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("UPDATE pago SET \"n_formaPago\" = ?, \"v_valorPagado\" = ?, \"f_fechaPago\" = ?, \"k_idRegistro\" = ? WHERE \"k_idPago\" = ?;");
            st.setString(1, pago.getFormaPago());
            st.setDouble(2, pago.getValorPagado());
            st.setTimestamp(3, pago.getFechaPago());
            st.setInt(4, pago.getIdRegistro());
            st.setInt(5, pago.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al actualizar pago: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public void eliminar(Pago pago) throws SQLException {
        PreparedStatement st = null;
        try {
            connection.open();
            st = connection.conn.prepareStatement("DELETE FROM pago WHERE \"k_idPago\" = ?;");
            st.setInt(1, pago.getId());
            st.executeUpdate();
        } catch (Exception e) {
            LOGGER.severe("Error al eliminar pago: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            connection.close();
        }
    }

    @Override
    public Pago encontrarPorId(int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        Pago pago = new Pago();

        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM pago WHERE \"k_idPago\" = ?;");
            st.setInt(1, (int) id);
            result = st.executeQuery();
            if (result.next()) {
                pago.setId(result.getInt("k_idPago"));
                pago.setFormaPago(result.getString("n_formaPago"));
                pago.setValorPagado(result.getDouble("v_valorPagado"));
                pago.setFechaPago(result.getTimestamp("f_fechaPago"));
                pago.setIdRegistro(result.getInt("k_idRegistro"));
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar pago: " + e.getMessage());
            throw e;
        } finally {
            st.close();
        }
        return pago;
    }

    @Override
    public List<Pago> encontrarTodos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        List<Pago> pagos = new ArrayList<>();
        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT * FROM pago;");
            while (result.next()) {
                Pago pago = new Pago();
                pago.setId(result.getInt("k_idPago"));
                pago.setFormaPago(result.getString("n_formaPago"));
                pago.setValorPagado(result.getDouble("v_valorPagado"));
                pago.setFechaPago(result.getTimestamp("f_fechaPago"));
                pago.setIdRegistro(result.getInt("k_idRegistro"));
                pagos.add(pago);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al encontrar todos los pagos: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return pagos;
    }

    @Override
    public List<Pago> filtrarCampoValor (String campo, String valor) throws SQLException {

        PreparedStatement st = null;
        ResultSet result = null;
        List<Pago> pagos = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM pago WHERE ? = ?;");
            st.setString(1, campo);
            st.setString(2, valor);
            result = st.executeQuery();
            while (result.next()) {
                Pago pago = new Pago();
                pago.setId(result.getInt("k_idPago"));
                pago.setFormaPago(result.getString("n_formaPago"));
                pago.setValorPagado(result.getDouble("v_valorPagado"));
                pago.setFechaPago(result.getTimestamp("f_fechaPago"));
                pago.setIdRegistro(result.getInt("k_idRegistro"));
                pagos.add(pago);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar pagos por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return pagos;
    }

    @Override
    public List<Pago> filtrarCampoValorId (String campo, int valor) throws SQLException {

        PreparedStatement st = null;
        ResultSet result = null;
        List<Pago> pagos = new ArrayList<>();

        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT * FROM pago WHERE ? = ?;");
            st.setString(1, campo);
            st.setLong(2, valor);
            result = st.executeQuery();
            while (result.next()) {
                Pago pago = new Pago();
                pago.setId(result.getInt("k_idPago"));
                pago.setFormaPago(result.getString("n_formaPago"));
                pago.setValorPagado(result.getDouble("v_valorPagado"));
                pago.setFechaPago(result.getTimestamp("f_fechaPago"));
                pago.setIdRegistro(result.getInt("k_idRegistro"));
                pagos.add(pago);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al filtrar pagos por campo y valor: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return pagos;
    }

    public int contarPagos() throws SQLException {
        Statement st = null;
        ResultSet result = null;
        int registros = 0;
        try {
            connection.open();
            st = connection.conn.createStatement();
            result = st.executeQuery("SELECT COUNT(*) FROM pago;");
            if (result.next()) {
                registros = result.getInt(1);
            }
        } catch (Exception e) {
            LOGGER.severe("Error al contar pagos: " + e.getMessage());
            throw e;
        } finally {
            result.close();
            st.close();
        }
        return registros;
    }

    public long calcularTarifa(int id) throws SQLException {
        PreparedStatement st = null;
        ResultSet result = null;
        long tarifa = 0;
        try {
            connection.open();
            st = connection.conn.prepareStatement("SELECT FLOOR((EXTRACT(EPOCH FROM (reg.\"f_fechaSalida\" - reg.\"f_fechaEntrada\")) / 60) * tar.\"v_valor\") AS tarifa FROM registro AS reg JOIN (SELECT tarifa.* FROM parqueadero_tarifa AS pt JOIN tarifa ON pt.\"k_idTarifa\" = tarifa.\"k_idTarifa\") AS tar ON reg.\"n_tipoVehiculo\" = tar.\"n_tipoVehiculo\" WHERE reg.\"k_idRegistro\" = ?;");
            st.setInt(1, id);
            result = st.executeQuery();
            if (result.next()) {
                tarifa = result.getLong("tarifa");
            }
        } catch (Exception e) {
            LOGGER.severe("Error al calcular tarifa: " + e.getMessage());
            throw e;
        } finally {
            st.close();
            result.close();
        }
        return tarifa;
    }

}
