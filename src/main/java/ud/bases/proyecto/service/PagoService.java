package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.PagoDAO;
import ud.bases.proyecto.entity.Pago;

import java.sql.SQLException;
import java.util.List;

@Service
public class PagoService {

    private final PagoDAO pagoDAO;

    public PagoService(PagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }

    public List<Pago> encontrarTodos() throws SQLException {
        return pagoDAO.encontrarTodos();
    }

    public Pago encontrarPorId(int id) throws SQLException {
        return pagoDAO.encontrarPorId(id);
    }

    public void insertar(Pago pago) throws SQLException {
        pagoDAO.insertar(pago);
    }

    public void actualizar(Pago pago) throws SQLException {
        pagoDAO.actualizar(pago);
    }

    public void eliminar(Pago pago) throws SQLException {
        pagoDAO.eliminar(pago);
    }

    public List<Pago> filtrarCampoValor(String campo, String valor) throws SQLException {
        return pagoDAO.filtrarCampoValor(campo, valor);
    }

    public List<Pago> filtrarCampoValorId(String campo, int valor) throws SQLException {
        return pagoDAO.filtrarCampoValorId(campo, valor);
    }


    public int contarPagos() throws SQLException {
        return pagoDAO.contarPagos();
    }

    public float calcularTarifa(int id) throws SQLException {
        return pagoDAO.calcularTarifa(id);
    }

}
