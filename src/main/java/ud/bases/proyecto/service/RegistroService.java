package ud.bases.proyecto.service;

import org.springframework.stereotype.Service;
import ud.bases.proyecto.dao.RegistroDAO;
import ud.bases.proyecto.entity.Espacio;
import ud.bases.proyecto.entity.Registro;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class RegistroService {

    private final RegistroDAO registroDAO;

    public RegistroService(RegistroDAO registroDAO) {
        this.registroDAO = registroDAO;
    }

    public List<Registro> encontrarTodos() throws SQLException {
        return registroDAO.encontrarTodos();
    }

    public Registro encontrarPorId(long id) throws SQLException {
        return registroDAO.encontrarPorId(id);
    }

    public void insertar(Registro registro) throws SQLException {
        registroDAO.insertar(registro);
    }

    public void actualizar(Registro registro) throws SQLException {
        registroDAO.actualizar(registro);
    }

    public void eliminar(Registro registro) throws SQLException {
        registroDAO.eliminar(registro);
    }

    public List<Registro> filtrarCampoValor(String campo, String valor) throws SQLException {
        return registroDAO.filtrarCampoValor(campo, valor);
    }

    public List<Registro> filtrarCampoValorId(String campo, long valor) throws SQLException {
        return registroDAO.filtrarCampoValorId(campo, valor);
    }

    public Registro registroActual(long id) throws SQLException {
        return registroDAO.registroActual(id);
    }

    public int contarRegistros() throws SQLException {
        return registroDAO.contarRegistros();
    }

    public void actualizarFechaSalida(int registro) throws SQLException {

        java.util.Date fecha = new java.util.Date();
        Timestamp timestamp = new Timestamp(fecha.getTime());

        registroDAO.actualizarFechaSalida(registro, timestamp);
    }
}
